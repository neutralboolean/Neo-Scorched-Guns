package top.ribs.scguns;

import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.event.FrameworkEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.ribs.scguns.attributes.SCAttributes;
import top.ribs.scguns.client.CustomGunManager;
import top.ribs.scguns.client.handler.*;
import top.ribs.scguns.client.screen.*;
import top.ribs.scguns.common.BoundingBoxManager;
import top.ribs.scguns.common.NetworkGunManager;
import top.ribs.scguns.common.ProjectileManager;
import top.ribs.scguns.common.exosuit.ExoSuitUpgradeManager;
import top.ribs.scguns.compat.CreateModCondition;
import top.ribs.scguns.compat.FarmersDelightModCondition;
import top.ribs.scguns.compat.IEModCondition;
import top.ribs.scguns.event.SculkHordeEvents;
import top.ribs.scguns.config.MerchantTradeConfig;
import top.ribs.scguns.config.ProjectileAdvantageConfig;
import top.ribs.scguns.entity.config.ConfigLoader;
import top.ribs.scguns.entity.projectile.*;
import top.ribs.scguns.entity.throwable.GrenadeEntity;
import top.ribs.scguns.event.*;
import top.ribs.scguns.init.ModBlockEntities;
import top.ribs.scguns.client.ClientHandler;
import top.ribs.scguns.entity.config.CogMinionConfig;
import top.ribs.scguns.init.*;
import top.ribs.scguns.network.PacketHandler;
import top.ribs.scguns.world.VillageStructures;
import java.io.IOException;
import java.io.InputStream;

import static top.ribs.scguns.NeoScorchedGunsMain.MODID;
import static top.ribs.scguns.compat.CompatManager.SCULK_HORDE_LOADED;

@Mod(MODID)
public class NeoScorchedGunsMain {
    public static final String MODID = "neoscorguns";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static CogMinionConfig COG_MINION_CONFIG = new CogMinionConfig();

    public static boolean backpackedLoaded;
    public static boolean curiosLoaded;
    public static boolean controllableLoaded;
    public static boolean playerReviveLoaded;
    public static boolean createLoaded;
    public static boolean farmersDelightLoaded;
    public static boolean mekanismLoaded;
    public static boolean ieLoaded;
    public static boolean valkyrienSkiesLoaded;
    public static boolean marjLoaded;

    private static boolean useEnergyGuns = false;

    public NeoScorchedGunsMain(IEventBus modBus) {
        var container = ModLoadingContext.get().getActiveContainer();
        // Common setup
        container.registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        container.registerConfig(ModConfig.Type.COMMON, Config.commonSpec);

        Config.GunScalingConfig.setup();

        container.registerConfig(ModConfig.Type.SERVER, Config.serverSpec);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onConfigLoad);
        ModItems.ITEMS.register(modBus);

        ModRecipes.register(modEventBus); // ebs'd
        SCAttributes.ATTRIBUTES.register(modEventBus); // ebs'd

        initializeModDependencies();
        ModBlockEntities.BLOCK_ENTITIES.register(modBus); // ebs'd

        // Register other mod features
        NeoForge.EVENT_BUS.addListener(VillageStructures::addNewVillageBuilding);
        ModItems.registerItems();
        ModCreativeModeTabs.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModContainers.CONTAINERS.register(modBus);
        ModEffects.EFFECTS.register(modBus);
        ModMenuTypes.register(modBus);
        ModEnchantments.ENCHANTMENTS.register(modBus);
        ModEntities.ENTITIES.register(modBus);
        ModParticleTypes.REGISTER.register(modBus);
        ModRecipes.register(modBus);
        ModSounds.SOUND_EVENTS.register(modBus);
        ModVillagers.register(modBus);
        ModFeatures.register(modBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modBus);
        ModPointOfInterestTypes.POIS.register(modBus);
        ModRecipes.register(modEventBus);

        ModStructures.STRUCTURES.register(modBus);
        modBus.addListener(this::onCommonSetup);

        // Ensure client-specific code is run only on the client side
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            ClientHandler.registerClientHandlers(modBus);
            NeoForge.EVENT_BUS.register(HUDRenderHandler.class);
            NeoForge.EVENT_BUS.register(InspectHandler.get());
            CraftingHelper.register(CreateModCondition.Serializer.INSTANCE);
            CraftingHelper.register(FarmersDelightModCondition.Serializer.INSTANCE);
            CraftingHelper.register(IEModCondition.Serializer.INSTANCE);
            NeoForge.EVENT_BUS.register(BeamHandler.class);
        });

        // Register the mod itself to the event bus
        NeoForge.EVENT_BUS.register(this);
        //NeoForge.EVENT_BUS.register(ArmorBoostEventHandler.class);
       /// NeoForge.EVENT_BUS.register(ArmorRemoveEventHandler.class);
        NeoForge.EVENT_BUS.register(WeaponMovementEventHandler.class);
        NeoForge.EVENT_BUS.register(OceanWeaponEventHandler.class);
        NeoForge.EVENT_BUS.register(PiglinWeaponEventHandler.class);
        NeoForge.EVENT_BUS.register(MerchantTradeConfig.class);
        NeoForge.EVENT_BUS.register(ProjectileAdvantageConfig.class);


        if (SCULK_HORDE_LOADED) {
            NeoForge.EVENT_BUS.register(SculkHordeEvents.class);
        }
    }
    private void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getType() == ModConfig.Type.SERVER) {
            // Only call RecoilHandler on client side
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                RecoilHandler.get().updateConfig();
            });
        }
    }

    private void initializeModDependencies() {
        // Check for optional mod dependencies
        valkyrienSkiesLoaded = ModList.get().isLoaded("valkyrienskies");
        controllableLoaded = ModList.get().isLoaded("controllable");
        backpackedLoaded = ModList.get().isLoaded("backpacked");
        curiosLoaded = ModList.get().isLoaded("curios");
        playerReviveLoaded = ModList.get().isLoaded("playerrevive");
        createLoaded = ModList.get().isLoaded("create");
        farmersDelightLoaded = ModList.get().isLoaded("farmersdelight");
        ieLoaded = ModList.get().isLoaded("immersiveengineering");
        mekanismLoaded = ModList.get().isLoaded("mekanism");
        marjLoaded = ModList.get().isLoaded("majruszsdifficulty");
    }

    @SubscribeEvent
    public void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(new ExoSuitUpgradeManager());
    }

    public static boolean shouldUseEnergyGuns() {
        return !createLoaded || useEnergyGuns;
    }

    // Register the Login Data using the Framework register event
    public static void onFrameworkRegister(FrameworkEvent event) {
        // Register login data
        event.registerLoginData(ResourceLocation.fromNamespaceAndPath(MODID, "network_gun_manager"), NetworkGunManager.LoginData::new);
        event.registerLoginData(ResourceLocation.fromNamespaceAndPath(MODID, "custom_gun_manager"), CustomGunManager.LoginData::new);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.AIMING);
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.RELOADING);
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.SHOOTING);
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.BURSTCOUNT);
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.ONBURSTCOOLDOWN);
            FrameworkAPI.registerSyncedDataKey(ModSyncedDataKeys.MELEE);
            NeoForge.EVENT_BUS.register(TemporaryLightManager.class);

            ProjectileManager.getInstance().registerFactory(ModItems.POWDER_AND_BALL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.GRAPESHOT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.COMPACT_COPPER_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.HOG_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new HogRoundProjectileEntity(ModEntities.HOG_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.STANDARD_COPPER_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.COMPACT_ADVANCED_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.RAMROD_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new RamrodProjectileEntity(ModEntities.RAMROD_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.ADVANCED_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new AdvancedRoundProjectileEntity(ModEntities.ADVANCED_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SHATTER_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ShatterRoundProjectileEntity(ModEntities.SHATTER_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.KRAHG_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new KrahgRoundProjectileEntity(ModEntities.KRAHG_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.BEOWULF_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new BeowulfProjectileEntity(ModEntities.BEOWULF_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.GIBBS_ROUND.get(), (worldIn, entity, weapon, item, modifiedGun) -> new GibbsRoundProjectileEntity(ModEntities.GIBBS_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SHOTGUN_SHELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.BEARPACK_SHELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new BearPackShellProjectileEntity(ModEntities.BEARPACK_SHELL_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.BLAZE_FUEL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new FireRoundEntity(ModEntities.FIRE_ROUND_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SCULK_CELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new SculkCellEntity(ModEntities.SCULK_CELL.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SHOCK_CELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new LightningProjectileEntity(ModEntities.PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SHULKSHOT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ShulkshotProjectileEntity(ModEntities.SHULKSHOT.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.ENERGY_CELL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new PlasmaProjectileEntity(ModEntities.PLASMA_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.OSBORNE_SLUG.get(), (worldIn, entity, weapon, item, modifiedGun) -> new OsborneSlugProjectileEntity(ModEntities.OSBORNE_SLUG_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(Items.BLAZE_ROD, (worldIn, entity, weapon, item, modifiedGun) -> new BlazeRodProjectileEntity(ModEntities.BLAZE_ROD_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SYRINGE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new SyringeProjectileEntity(ModEntities.SYRINGE_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.STANDARD_BULLET.get(), (worldIn, entity, weapon, item, modifiedGun) -> new BasicBulletProjectileEntity(ModEntities.BASIC_BULLET_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.ADVANCED_BULLET.get(), (worldIn, entity, weapon, item, modifiedGun) -> new HardenedBulletProjectileEntity(ModEntities.HARDENED_BULLET_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.BUCKSHOT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new BuckshotProjectileEntity(ModEntities.BUCKSHOT_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.NITRO_BUCKSHOT.get(), (worldIn, entity, weapon, item, modifiedGun) -> new BuckshotProjectileEntity(ModEntities.BUCKSHOT_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.SHOTBALL.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ShotballProjectileEntity(ModEntities.SHOTBALL_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.ROCKET.get(), (worldIn, entity, weapon, item, modifiedGun) -> new RocketEntity(ModEntities.ROCKET.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.MICROJET.get(), (worldIn, entity, weapon, item, modifiedGun) -> new MicroJetEntity(ModEntities.MICROJET.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(ModItems.GRENADE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new GrenadeEntity(ModEntities.GRENADE.get(), worldIn, entity, weapon, item, modifiedGun));
            useEnergyGuns = Config.COMMON.gameplay.forceEnergyGuns.get();

          if (Config.COMMON.gameplay.improvedHitboxes.get()) {
                NeoForge.EVENT_BUS.register(new BoundingBoxManager());
            }
            try {
                InputStream inputStream = NeoScorchedGunsMain.class.getClassLoader().getResourceAsStream("data/scguns/entity/cog_minion_item.json");
                if (inputStream != null) {
                    COG_MINION_CONFIG = ConfigLoader.loadCogMinionConfig(inputStream);
                    inputStream.close();
                } else {
                    LOGGER.error("Could not find Cog Minion config");
                }
            } catch (IOException e) {
                LOGGER.error("Failed to load Cog Minion config", e);
            }
        });
    }

    public static boolean isDebugging() {
        return false;
    }
}

