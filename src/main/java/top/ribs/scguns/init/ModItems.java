package top.ribs.scguns.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.common.Attachments;
import top.ribs.scguns.common.GunModifiers;
import top.ribs.scguns.item.*;
import top.ribs.scguns.item.ammo.impl.AmmoItem;
import top.ribs.scguns.item.ammo.impl.FuelAmmoItem;
import top.ribs.scguns.item.ammo.impl.ThrowableShotballItem;
import top.ribs.scguns.item.ammo.impl.ammo_boxes.*;

import top.ribs.scguns.item.animated.*;
import top.ribs.scguns.item.attachment.impl.*;
import top.ribs.scguns.item.blueprint.BlueprintItem;
import top.ribs.scguns.item.blueprint.GlintedBlueprintItem;
import top.ribs.scguns.item.exosuit.*;
import top.ribs.scguns.item.gun.EnergyGunItem;
import top.ribs.scguns.item.gun.GunItem;
import top.ribs.scguns.item.ingredient.DepletedDiamondSteelItem;
import top.ribs.scguns.item.ingredient.NiterDustItem;
import top.ribs.scguns.item.ingredient.SulfurDustItem;
import top.ribs.scguns.item.throwable.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NeoScorchedGunsMain.MODID);

    public static DeferredItem<Item> ANTHRALITE_KNIFE;
    public static DeferredItem<GunItem> GALE;
    public static DeferredItem<GunItem> UMAX_PISTOL;
    public static DeferredItem<Item> VENTURI;
    public static DeferredItem<Item> SCRATCHES;

    public static void registerItems() {
        SCRATCHES = ITEMS.register("scratches", () -> {
            Item.Properties properties = new Item.Properties().stacksTo(1).durability(1400);
            if (!NeoScorchedGunsMain.shouldUseEnergyGuns()) {
                return new AnimatedAirGunItem(properties,
                        "scratches",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value()
                );
            } else {
                return new AnimatedEnergyGunItem(properties,
                        "scratches",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        4900
                );
            }
        });
        GALE = ITEMS.register("gale", () -> {
            Item.Properties properties = new Item.Properties().stacksTo(1).durability(1400);
            if (!NeoScorchedGunsMain.shouldUseEnergyGuns()) {
                return new AnimatedAirGunItem(properties,
                        "gale",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value()
                );
            } else {
                return new AnimatedEnergyGunItem(properties,
                        "gale",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        4900
                );
            }
        });
        UMAX_PISTOL = ITEMS.register("umax_pistol", () -> {
            Item.Properties properties = new Item.Properties().stacksTo(1).durability(400);
            if (!NeoScorchedGunsMain.shouldUseEnergyGuns()) {
                return new AnimatedAirGunItem(properties,
                        "umax_pistol",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value()
                );
            } else {
                return new AnimatedEnergyGunItem(properties,
                        "umax_pistol",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        4900
                );
            }
        });


        VENTURI = ITEMS.register("venturi", () -> {
            Item.Properties properties = new Item.Properties().stacksTo(1).durability(800);
            if (!NeoScorchedGunsMain.shouldUseEnergyGuns()) {
                return new AnimatedAirGunItem(properties,
                        "venturi",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value()
                );
            } else {
                return new AnimatedEnergyGunItem(properties,
                        "venturi",
                        ModSounds.MAG_OUT.value(),
                        ModSounds.MAG_IN.value(),
                        ModSounds.RELOAD_END.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        ModSounds.COPPER_GUN_JAM.value(),
                        4900
                );
            }
        });


//        if (NeoScorchedGunsMain.farmersDelightLoaded) {
//            ANTHRALITE_KNIFE = REGISTER.register("anthralite_knife", () -> {
//                try {
//                    Class<?> knifeItemClass = Class.forName("vectorwing.farmersdelight.common.item.KnifeItem");
//                    Constructor<?> constructor = knifeItemClass.getConstructor(Tier.class, float.class, float.class, Item.Properties.class);
//                    return (Item) constructor.newInstance(ModTiers.ANTHRALITE, 0.5F, -2.0F, new Item.Properties());
//                } catch (Exception e) {
//                    throw new RuntimeException("Failed to create ANTHRALITE_KNIFE", e);
//                }
//            });
//        }
    }

    /**
     * Creates either an AirGunItem or EnergyGunItem based on whether Create is loaded
     *
     * @param durability     The durability for both gun types
     * @param energyCapacity The energy capacity (only used for EnergyGunItem)
     * @return The appropriate GunItem instance
     */
    private static GunItem createGunItem(int durability, int energyCapacity) {
        Item.Properties properties = new Item.Properties().stacksTo(1).durability(durability);

        // Stripping specific Create compat as part of simplification
//        if (!NeoScorchedGunsMain.shouldUseEnergyGuns()) {
//            return new AirGunItem(properties);
//        } else {
//            return new EnergyGunItem(properties, energyCapacity);
//        }
        return new EnergyGunItem(properties, energyCapacity);
    }

    public static final DeferredItem<AnimatedGunItem> M3_CARABINE = ITEMS.register("m3_carabine",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "m3_carabine",                               // Model path
                    ModSounds.MAG_OUT.value(),        // Reload sound mag out
                    ModSounds.MAG_IN.value(),         // Reload sound mag in
                    ModSounds.RELOAD_END.value(),           // Reload sound end
                    ModSounds.COPPER_GUN_JAM.value(),      // Ejector sound pull
                    ModSounds.COPPER_GUN_JAM.value()    // Ejector sound release
            )
    );

    public static final DeferredItem<AnimatedGunItem> M3_MARKSMAN = ITEMS.register("m3_marksman",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "m3_marksman",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MAKESHIFT_RIFLE = ITEMS.register("makeshift_rifle",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "makeshift_rifle",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> LOCKEWOOD = ITEMS.register("lockewood",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "lockewood",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> MICINA = ITEMS.register("micina",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "micina",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> RG_JIGSAW = ITEMS.register("rg_jigsaw",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "rg_jigsaw",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GRANDLE = ITEMS.register("grandle",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "grandle",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GRANDLE_OG = ITEMS.register("grandle_og",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "grandle_og",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> DEFENDER_PISTOL = ITEMS.register("defender_pistol",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "defender_pistol",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> TRENCHUR = ITEMS.register("trenchur",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "trenchur",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> AUVTOMAG = ITEMS.register("auvtomag",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "auvtomag",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GREASER_SMG = ITEMS.register("greaser_smg",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "greaser_smg",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BOOMSTICK = ITEMS.register("boomstick",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "boomstick",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> INERTIAL = ITEMS.register("inertial",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "inertial",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> M22_WALTZ = ITEMS.register("m22_waltz",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "m22_waltz",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedUnderWaterGunItem> FLOUNDERGAT = ITEMS.register("floundergat",
            () -> new AnimatedUnderWaterGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "floundergat",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedUnderWaterGunItem> HULLBREAKER = ITEMS.register("hullbreaker",
            () -> new AnimatedUnderWaterGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "hullbreaker",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.CANNON_RELOAD.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> KRAUSER = ITEMS.register("krauser",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "krauser",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> UPPERCUT = ITEMS.register("uppercut",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "uppercut",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> PRUSH_GUN = ITEMS.register("prush_gun",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "prush_gun",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> SOUL_DRUMMER = ITEMS.register("soul_drummer",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "soul_drummer",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> VALORA = ITEMS.register("valora",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "valora",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> RUSTY_GNAT = ITEMS.register("rusty_gnat",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "rusty_gnat",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CALLWELL = ITEMS.register("callwell",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "callwell",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CALLWELL_TERMINAL = ITEMS.register("callwell_terminal",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "callwell_terminal",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CALLWELL_CONVERSION = ITEMS.register("callwell_conversion",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "callwell_conversion",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> COMBAT_SHOTGUN = ITEMS.register("combat_shotgun",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "combat_shotgun",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> FLINTLOCK_PISTOL = ITEMS.register("flintlock_pistol",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "flintlock_pistol",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<NonUnderwaterAnimatedGunItem> HANDCANNON = ITEMS.register("handcannon",
            () -> new NonUnderwaterAnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "handcannon",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<NonUnderwaterAnimatedGunItem> MUSKET = ITEMS.register("musket",
            () -> new NonUnderwaterAnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "musket",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<NonUnderwaterAnimatedGunItem> REPEATING_MUSKET = ITEMS.register("repeating_musket",
            () -> new NonUnderwaterAnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "repeating_musket",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<NonUnderwaterAnimatedGunItem> BLUNDERBUSS = ITEMS.register("blunderbuss",
            () -> new NonUnderwaterAnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "blunderbuss",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<NonUnderwaterAnimatedGunItem> DOUBLET = ITEMS.register("doublet",
            () -> new NonUnderwaterAnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "doublet",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> MAS_55 = ITEMS.register("mas_55",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "mas_55",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> COGLOADER = ITEMS.register("cogloader",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "cogloader",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SAKETINI = ITEMS.register("saketini",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "saketini",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SAKETINI_IRONPORT = ITEMS.register("saketini_ironport",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "saketini_ironport",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    SoundEvents.LEVER_CLICK,
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SCRAPPER = ITEMS.register("scrapper",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "scrapper",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BRAWLER = ITEMS.register("brawler",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "brawler",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> WINNIE = ITEMS.register("winnie",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "winnie",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BRUISER = ITEMS.register("bruiser",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "bruiser",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> CYCLONE = ITEMS.register("cyclone",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "cyclone",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDiamondSteelGunItem> PLASGUN = ITEMS.register("plasgun",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "plasgun",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> ROCKET_RIFLE = ITEMS.register("rocket_rifle",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "rocket_rifle",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MARLIN = ITEMS.register("marlin",
            () -> new AnimatedUnderWaterGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "marlin",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GAUSS_RIFLE = ITEMS.register("gauss_rifle",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "gauss_rifle",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> NIAMI = ITEMS.register("niami",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "niami",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "iron_spear",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> IRON_JAVELIN = ITEMS.register("iron_javelin",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "iron_javelin",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );


    public static final DeferredItem<AnimatedGunItem> LLR_DIRECTOR = ITEMS.register("llr_director",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "llr_director",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BIRDFEEDER = ITEMS.register("birdfeeder",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "birdfeeder",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> TURNPIKE = ITEMS.register("turnpike",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "turnpike",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> STILETTO = ITEMS.register("stiletto",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "stiletto",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BASKER = ITEMS.register("basker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "basker",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> KALASKAH = ITEMS.register("kalaskah",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "kalaskah",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MOKOVA = ITEMS.register("mokova",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "mokova",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MAK_MKII = ITEMS.register("mak_mkii",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "mak_mkii",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> TL_RUNNER = ITEMS.register("tl_runner",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "tl_runner",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> KILLER_23 = ITEMS.register("killer_23",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "killer_23",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> HOMEMAKER = ITEMS.register("homemaker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "homemaker",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> RIBS_GLORY = ITEMS.register("ribs_glory",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "ribs_glory",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> STIGG = ITEMS.register("stigg",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(540),
                    "stigg",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> PAX = ITEMS.register("pax",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "pax",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BIG_BORE = ITEMS.register("big_bore",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(9),
                    "big_bore",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> HOWLER = ITEMS.register("howler",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "howler",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> HOWLER_CONVERSION = ITEMS.register("howler_conversion",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "howler_conversion",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> PULSAR = ITEMS.register("pulsar",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "pulsar",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> ARC_WORKER = ITEMS.register("arc_worker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "arc_worker",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> LASER_MUSKET = ITEMS.register("laser_musket",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(512),
                    "laser_musket",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> PLASMABUSS = ITEMS.register("plasmabuss",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(512),
                    "plasmabuss",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> JACKHAMMER = ITEMS.register("jackhammer",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "jackhammer",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SEQUOIA = ITEMS.register("sequoia",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "sequoia",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> ULTRA_KNIGHT_HAWK = ITEMS.register("ultra_knight_hawk",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(15),
                    "ultra_knight_hawk",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SUPER_SHOTGUN = ITEMS.register("super_shotgun",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "super_shotgun",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BOMB_LANCE = ITEMS.register("bomb_lance",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "bomb_lance",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> DOZIER_RL = ITEMS.register("dozier_rl",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(512),
                    "dozier_rl",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> DARK_MATTER = ITEMS.register("dark_matter",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "dark_matter",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MK43_RIFLE = ITEMS.register("mk43_rifle",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "mk43_rifle",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CRUSADER = ITEMS.register("crusader",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(256),
                    "crusader",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GYROJET_PISTOL = ITEMS.register("gyrojet_pistol",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(800),
                    "gyrojet_pistol",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> THUNDERHEAD = ITEMS.register("thunderhead",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(600),
                    "thunderhead",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> GATTALER = ITEMS.register("gattaler",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1000),
                    "gattaler",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CR4K_MINING_LASER = ITEMS.register("cr4k_mining_laser",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "cr4k_mining_laser",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SHARD_CULLER = ITEMS.register("shard_culler",
            () -> new AnimatedDiamondSteelGunItem(
                    new Item.Properties().stacksTo(1).durability(1350),
                    "shard_culler",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SPITFIRE = ITEMS.register("spitfire",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "spitfire",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> WALTZ_CONVERSION = ITEMS.register("waltz_conversion",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "waltz_conversion",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> OSGOOD_50 = ITEMS.register("osgood_50",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1400),
                    "osgood_50",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> FREYR = ITEMS.register("freyr",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "freyr",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> VULCANIC_REPEATER = ITEMS.register("vulcanic_repeater",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "vulcanic_repeater",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> PYROCLASTIC_FLOW = ITEMS.register("pyroclastic_flow",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "pyroclastic_flow",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> MANGALITSA = ITEMS.register("mangalitsa",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "mangalitsa",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> TROTTERS = ITEMS.register("trotters",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "trotters",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> BLASPHEMY = ITEMS.register("blasphemy",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1050),
                    "blasphemy",
                    SoundEvents.GENERIC_DRINK,
                    SoundEvents.PLAYER_BURP,
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedSculkGunItem> WHISPERS = ITEMS.register("whispers",
            () -> new AnimatedSculkGunItem(
                    new Item.Properties().stacksTo(1).durability(1100),
                    "whispers",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedSculkGunItem> SCULK_RESONATOR = ITEMS.register("sculk_resonator",
            () -> new AnimatedSculkGunItem(
                    new Item.Properties().stacksTo(1).durability(1100),
                    "sculk_resonator",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedSculkGunItem> ECHOES_2 = ITEMS.register("echoes_2",
            () -> new AnimatedSculkGunItem(
                    new Item.Properties().stacksTo(1).durability(1100),
                    "echoes_2",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedSculkGunItem> FORLORN_HOPE = ITEMS.register("forlorn_hope",
            () -> new AnimatedSculkGunItem(
                    new Item.Properties().stacksTo(1).durability(1100),
                    "forlorn_hope",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> RAYGUN = ITEMS.register("raygun",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "raygun",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> CARAPICE = ITEMS.register("carapice",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "carapice",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> SHELLURKER = ITEMS.register("shellurker",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "shellurker",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> WEEVIL = ITEMS.register("weevil",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "weevil",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> LONE_WONDER = ITEMS.register("lone_wonder",
            () -> new AnimatedGunItem(
                    new Item.Properties().stacksTo(1).durability(1600),
                    "lone_wonder",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedDualWieldGunItem> RAT_KING_AND_QUEEN = ITEMS.register("rat_king_and_queen",
            () -> new AnimatedDualWieldGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "rat_king_and_queen",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> LOCUST = ITEMS.register("locust",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "locust",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedGunItem> NEWBORN_CYST = ITEMS.register("newborn_cyst",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "newborn_cyst",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );


    public static final DeferredItem<AnimatedScorchedGunItem> ASTELLA = ITEMS.register("astella",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "astella",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedScorchedGunItem> TERRA_INCOGNITA = ITEMS.register("terra_incognita",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "terra_incognita",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    SoundEvents.PISTON_EXTEND
            )
    );

    public static final DeferredItem<AnimatedScorchedGunItem> PRIMA_MATERIA = ITEMS.register("prima_materia",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "prima_materia",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedScorchedGunItem> NERVEPINCH = ITEMS.register("nervepinch",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "nervepinch",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedScorchedGunItem> EARTHS_CORPSE = ITEMS.register("earths_corpse",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "earths_corpse",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );

    public static final DeferredItem<AnimatedScorchedGunItem> FLAYED_GOD = ITEMS.register("flayed_god",
            () -> new AnimatedScorchedGunItem(
                    new Item.Properties().stacksTo(1).durability(2400),
                    "flayed_god",
                    ModSounds.MAG_OUT.value(),
                    ModSounds.MAG_IN.value(),
                    ModSounds.RELOAD_END.value(),
                    ModSounds.COPPER_GUN_JAM.value(),
                    ModSounds.COPPER_GUN_JAM.value()
            )
    );


    public static final DeferredItem<PickaxeItem> ANTHRALITE_PICKAXE = ITEMS.register("anthralite_pickaxe", () -> new PickaxeItem(ModTiers.ANTHRALITE, 1, -2.8F, new Item.Properties()));

    public static final DeferredItem<SwordItem> ANTHRALITE_SWORD = ITEMS.register("anthralite_sword", () -> new SwordItem(ModTiers.ANTHRALITE, 3, -2.4F, new Item.Properties()));

    public static final DeferredItem<AxeItem> ANTHRALITE_AXE = ITEMS.register("anthralite_axe", () -> new AxeItem(ModTiers.ANTHRALITE, 5, -3.0F, new Item.Properties()));

    public static final DeferredItem<ShovelItem> ANTHRALITE_SHOVEL = ITEMS.register("anthralite_shovel", () -> new ShovelItem(ModTiers.ANTHRALITE, 1.5F, -3.0F, new Item.Properties()));

    public static final DeferredItem<HoeItem> ANTHRALITE_HOE = ITEMS.register("anthralite_hoe", () -> new HoeItem(ModTiers.ANTHRALITE, -3, -3.0F, new Item.Properties()));

    public static final DeferredItem<Item> RANGE_FINDER = ITEMS.register("range_finder", () -> new RangeFinderItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ANTHRALITE_RESPIRATOR = ITEMS.register("anthralite_respirator", () -> new AnthraliteGasMaskArmorItem(ModArmorMaterials.ANTHRALITE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_RESPIRATOR = ITEMS.register("netherite_respirator", () -> new NetheriteGasMaskArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_HELMET = ITEMS.register("diamond_steel_helmet", () -> new DiamondSteelArmorItem(ModArmorMaterials.DIAMOND_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_CHESTPLATE = ITEMS.register("diamond_steel_chestplate", () -> new DiamondSteelArmorItem(ModArmorMaterials.DIAMOND_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_LEGGINGS = ITEMS.register("diamond_steel_leggings", () -> new DiamondSteelArmorItem(ModArmorMaterials.DIAMOND_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_BOOTS = ITEMS.register("diamond_steel_boots", () -> new DiamondSteelArmorItem(ModArmorMaterials.DIAMOND_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_HELMET = ITEMS.register("treated_brass_helmet", () -> new ArmorItem(ModArmorMaterials.TREATED_BRASS, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_CHESTPLATE = ITEMS.register("treated_brass_chestplate", () -> new ArmorItem(ModArmorMaterials.TREATED_BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_LEGGINGS = ITEMS.register("treated_brass_leggings", () -> new ArmorItem(ModArmorMaterials.TREATED_BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_BOOTS = ITEMS.register("treated_brass_boots", () -> new ArmorItem(ModArmorMaterials.TREATED_BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_HELMET = ITEMS.register("anthralite_helmet", () -> new AnthraliteArmorItem(ModArmorMaterials.ANTHRALITE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(ModArmorMaterials.))));

    public static final DeferredItem<Item> ANTHRALITE_CHESTPLATE = ITEMS.register("anthralite_chestplate", () -> new AnthraliteArmorItem(ModArmorMaterials.ANTHRALITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_LEGGINGS = ITEMS.register("anthralite_leggings", () -> new AnthraliteArmorItem(ModArmorMaterials.ANTHRALITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_BOOTS = ITEMS.register("anthralite_boots", () -> new AnthraliteArmorItem(ModArmorMaterials.ANTHRALITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> RIDGETOP = ITEMS.register("ridgetop", () -> new RidgetopArmorItem(ArmorMaterials.LEATHER.value(), ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> BRASS_MASK = ITEMS.register("brass_mask", () -> new BrassMaskArmorItem(ModArmorMaterials.TREATED_BRASS, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> ADRIEN_HELM = ITEMS.register("adrien_helm", () -> new AdrienArmorItem(ModArmorMaterials.ADRIEN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> ADRIEN_CHESTPLATE = ITEMS.register("adrien_chestplate", () -> new AdrienArmorItem(ModArmorMaterials.ADRIEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> ADRIEN_LEGGINGS = ITEMS.register("adrien_leggings", () -> new AdrienArmorItem(ModArmorMaterials.ADRIEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> ADRIEN_BOOTS = ITEMS.register("adrien_boots", () -> new AdrienArmorItem(ModArmorMaterials.ADRIEN, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> COG_KNIGHT_HELMET = ITEMS.register("cog_knight_helmet", () -> new CogKnightArmorItem(ModArmorMaterials.ANCIENT_BRASS, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> COG_KNIGHT_CHESTPLATE = ITEMS.register("cog_knight_chestplate", () -> new CogKnightArmorItem(ModArmorMaterials.ANCIENT_BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> COG_KNIGHT_LEGGINGS = ITEMS.register("cog_knight_leggings", () -> new CogKnightArmorItem(ModArmorMaterials.ANCIENT_BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> COG_KNIGHT_BOOTS = ITEMS.register("cog_knight_boots", () -> new CogKnightArmorItem(ModArmorMaterials.ANCIENT_BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> EXO_SUIT_HELMET = ITEMS.register("exo_suit_helmet", () -> new ExoSuitItem(ModArmorMaterials.EXO_SUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> EXO_SUIT_CHESTPLATE = ITEMS.register("exo_suit_chestplate", () -> new ExoSuitItem(ModArmorMaterials.EXO_SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> EXO_SUIT_LEGGINGS = ITEMS.register("exo_suit_leggings", () -> new ExoSuitItem(ModArmorMaterials.EXO_SUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> EXO_SUIT_BOOTS = ITEMS.register("exo_suit_boots", () -> new ExoSuitItem(ModArmorMaterials.EXO_SUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    private static Item ancientBrassItem()

    public static final DeferredItem<Item> EXO_SUIT_CORE = ITEMS.register("exo_suit_core",
            () -> new ExoSuitCoreItem(new Item.Properties().stacksTo(1), ExoSuitCoreItem.CoreTier.BASIC));

    public static final DeferredItem<Item> ADVANCED_EXO_SUIT_CORE = ITEMS.register("advanced_exo_suit_core",
            () -> new ExoSuitCoreItem(new Item.Properties().stacksTo(1), ExoSuitCoreItem.CoreTier.ADVANCED));


    // Upgrade Materials
    public static final DeferredItem<Item> HEAVY_ARMOR_PLATE = ITEMS.register("heavy_armor_plate",
            () -> new DamageableUpgradeItem(new Item.Properties().durability(80)));

    public static final DeferredItem<Item> HEAVY_PAULDRON = ITEMS.register("heavy_pauldron",
            () -> new DamageableUpgradeItem(new Item.Properties().durability(80)));

    public static final DeferredItem<Item> ARMOR_PLATE = ITEMS.register("armor_plate",
            () -> new DamageableUpgradeItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> PAULDRON = ITEMS.register("pauldron",
            () -> new DamageableUpgradeItem(new Item.Properties().durability(64)));

    // Armor Modules
    public static final DeferredItem<Item> NIGHT_VISION_MODULE = ITEMS.register("night_vision_module",
            () -> new NightVisionModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> GAS_MASK_MODULE = ITEMS.register("gas_mask_module",
            () -> new GasMaskModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> REBREATHER_MODULE = ITEMS.register("rebreather_module",
            () -> new RebreatherModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> TARGET_TRACKER_MODULE = ITEMS.register("target_tracker_module",
            () -> new TargetTrackerModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> JETPACK_MODULE = ITEMS.register("jetpack_module",
            () -> new JetpackModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> ARMOR_POUCHES = ITEMS.register("armor_pouches",
            () -> new UpgradeItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> HEAVY_ARMOR_POUCHES = ITEMS.register("heavy_armor_pouches",
            () -> new UpgradeItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> RABBIT_MODULE = ITEMS.register("rabbit_module",
            () -> new RabbitModuleItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> SUIT_GREASE = ITEMS.register("suit_grease",
            () -> new DamageableUpgradeItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> TENSION_SPRING = ITEMS.register("tension_spring",
            () -> new DamageableUpgradeItem(new Item.Properties().stacksTo(1).durability(256)));


    public static final DeferredItem<Item> SHOCK_ABSORBER = ITEMS.register("shock_absorber",
            () -> new DamageableUpgradeItem(new Item.Properties().stacksTo(1).durability(256)));

    // Blueprints
    public static final DeferredItem<Item> ANTIQUE_BLUEPRINT = ITEMS.register("antique_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> FRONTIER_BLUEPRINT = ITEMS.register("frontier_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> COPPER_BLUEPRINT = ITEMS.register("copper_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> IRON_BLUEPRINT = ITEMS.register("iron_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> WRECKER_BLUEPRINT = ITEMS.register("wrecker_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> TREATED_BRASS_BLUEPRINT = ITEMS.register("treated_brass_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> DIAMOND_STEEL_BLUEPRINT = ITEMS.register("diamond_steel_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PIGLIN_BLUEPRINT = ITEMS.register("piglin_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> OCEAN_BLUEPRINT = ITEMS.register("ocean_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final DeferredItem<Item> DEEP_DARK_BLUEPRINT = ITEMS.register("deep_dark_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final DeferredItem<Item> END_BLUEPRINT = ITEMS.register("end_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> SCORCHED_BLUEPRINT = ITEMS.register("scorched_blueprint", () -> new GlintedBlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> EXO_SUIT_BLUEPRINT = ITEMS.register("exo_suit_blueprint", () -> new BlueprintItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    // Ammo ingredients
    public static final DeferredItem<Item> NITRO_POWDER = ITEMS.register("nitro_powder", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NITRO_POWDER_DUST = ITEMS.register("nitro_powder_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NITER_DUST = ITEMS.register("niter_dust", () -> new NiterDustItem(new Item.Properties()));

    public static final DeferredItem<Item> SHEOL = ITEMS.register("sheol", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PEAL = ITEMS.register("peal", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PEAL_DUST = ITEMS.register("peal_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VEHEMENT_COAL = ITEMS.register("vehement_coal", () -> new FuelItem(new Item.Properties(), 4800));

    public static final DeferredItem<Item> SHEOL_DUST = ITEMS.register("sheol_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SULFUR_CHUNK = ITEMS.register("sulfur_chunk", () -> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> COMPOSITE_FILTER = ITEMS.register("composite_filter", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", () -> new SulfurDustItem(new Item.Properties()));

    public static final DeferredItem<Item> PHOSPHOR_DUST = ITEMS.register("phosphor_dust", () -> new Item(new Item.Properties()));

    // Ammunition
    public static final DeferredItem<Item> STANDARD_BULLET = ITEMS.register("standard_bullet", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ADVANCED_BULLET = ITEMS.register("hardened_bullet", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SYRINGE = ITEMS.register("syringe", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BUCKSHOT = ITEMS.register("buckshot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FLECHETTE = ITEMS.register("flechette", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NITRO_BUCKSHOT = ITEMS.register("nitro_buckshot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_PHOSPHOR = ITEMS.register("raw_phosphor", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GUNPOWDER_DUST = ITEMS.register("gunpowder_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_ANTHRALITE = ITEMS.register("raw_anthralite", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRUSHED_RAW_ANTHRALITE = ITEMS.register("crushed_raw_anthralite", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_DUST = ITEMS.register("anthralite_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLUMP_ANTHRALITE = ITEMS.register("clump_anthralite", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHARD_ANTHRALITE = ITEMS.register("shard_anthralite", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIRTY_DUST_ANTHRALITE = ITEMS.register("dirty_dust_anthralite", () -> new Item(new Item.Properties()));

    // Music disks
    public static final DeferredItem<Item> MASS_PRODUCTION_MUSIC_DISC = ITEMS.register("music_disc_mass_production",
            () -> new RecordItem(12, ModSounds.MASS_PRODUCTION, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2580));

    public static final DeferredItem<Item> MASS_DESTRUCTION_MUSIC_DISC = ITEMS.register("music_disc_mass_destruction",
            () -> new RecordItem(15, ModSounds.MASS_DESTRUCTION, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 6280));

    public static final DeferredItem<Item> MASS_DESTRUCTION_EXTENDED_MUSIC_DISC = ITEMS.register("music_disc_mass_destruction_extended",
            () -> new RecordItem(20, ModSounds.MASS_DESTRUCTION_EXTENDED, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 8320));


    public static final DeferredItem<Item> TEAM_LOG = ITEMS.register("team_log", () -> new TeamLogItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ENEMY_LOG = ITEMS.register("enemy_log", () -> new EnemyLogItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> AUREOUS_SLAG = ITEMS.register("aureous_slag", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_INGOT = ITEMS.register("anthralite_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANTHRALITE_NUGGET = ITEMS.register("anthralite_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANCIENT_BRASS = ITEMS.register("ancient_brass", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_IRON_BLEND = ITEMS.register("treated_iron_blend", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_IRON_INGOT = ITEMS.register("treated_iron_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_IRON_NUGGET = ITEMS.register("treated_iron_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_BLEND = ITEMS.register("treated_brass_blend", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_INGOT = ITEMS.register("treated_brass_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_BLEND = ITEMS.register("diamond_steel_blend", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DEPLETED_DIAMOND_STEEL_INGOT = ITEMS.register("depleted_diamond_steel_ingot", () -> new DepletedDiamondSteelItem(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_INGOT = ITEMS.register("diamond_steel_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCORCHED_BLEND = ITEMS.register("scorched_blend", () -> new ScorchedItem(new Item.Properties()));

    public static final DeferredItem<Item> SCORCHED_INGOT = ITEMS.register("scorched_ingot", () -> new ScorchedItem(new Item.Properties()));

    public static final DeferredItem<Item> CHARGED_AMETHYST_SHARD = ITEMS.register("charged_amethyst_shard", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EMPTY_TANK = ITEMS.register("empty_tank", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EMPTY_CORE = ITEMS.register("empty_core", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ENERGY_CORE = ITEMS.register("energy_core", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DEPLETED_ENERGY_CORE = ITEMS.register("depleted_energy_core", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLASMA_CORE = ITEMS.register("plasma_core", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHER_STAR_FRAGMENT = ITEMS.register("nether_star_fragment", () -> new NetherStarFragmentItem(new Item.Properties()));

    public static final DeferredItem<Item> EMPTY_BLASPHEMY = ITEMS.register("empty_blasphemy", () -> new EmptyBlasphemyItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> GUN_GRIP = ITEMS.register("gun_grip", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GUN_BARREL = ITEMS.register("gun_barrel", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HEAVY_GUN_BARREL = ITEMS.register("heavy_gun_barrel", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STONE_GUN_BARREL = ITEMS.register("stone_gun_barrel", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GUN_MAGAZINE = ITEMS.register("gun_magazine", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GUN_PARTS = ITEMS.register("gun_parts", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HEAVY_GUN_PARTS = ITEMS.register("heavy_gun_parts", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIRING_UNIT = ITEMS.register("firing_unit", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAPID_FIRING_UNIT = ITEMS.register("rapid_firing_unit", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_GUN_FRAME = ITEMS.register("copper_gun_frame", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCORCHED_GUN_FRAME = ITEMS.register("scorched_gun_frame", () -> new ScorchedItem(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_IRON_GUN_FRAME = ITEMS.register("treated_iron_gun_frame", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_GUN_FRAME = ITEMS.register("iron_gun_frame", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TREATED_BRASS_GUN_FRAME = ITEMS.register("treated_brass_gun_frame", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_STEEL_GUN_FRAME = ITEMS.register("diamond_steel_gun_frame", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLANK_MOLD = ITEMS.register("blank_mold", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_CASING_MOLD = ITEMS.register("small_casing_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> MEDIUM_CASING_MOLD = ITEMS.register("medium_casing_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> LARGE_CASING_MOLD = ITEMS.register("large_casing_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(128)));

    public static final DeferredItem<Item> BULLET_MOLD = ITEMS.register("bullet_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> DISC_MOLD = ITEMS.register("disc_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(64)));

    public static final DeferredItem<Item> GUN_PARTS_MOLD = ITEMS.register("gun_parts_mold", () -> new MoldItem(new Item.Properties().stacksTo(1).durability(32)));

    public static final DeferredItem<Item> COPPER_DISC = ITEMS.register("copper_disc", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_COPPER_CASING = ITEMS.register("small_copper_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MEDIUM_COPPER_CASING = ITEMS.register("medium_copper_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_IRON_CASING = ITEMS.register("small_iron_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LARGE_IRON_CASING = ITEMS.register("large_iron_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EMPTY_CELL = ITEMS.register("empty_cell", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHULKER_CASING = ITEMS.register("shulker_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_DIAMOND_STEEL_CASING = ITEMS.register("small_diamond_steel_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MEDIUM_DIAMOND_STEEL_CASING = ITEMS.register("medium_diamond_steel_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALL_BRASS_CASING = ITEMS.register("small_brass_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MEDIUM_BRASS_CASING = ITEMS.register("medium_brass_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LARGE_BRASS_CASING = ITEMS.register("large_brass_casing", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POWDER_AND_BALL = ITEMS.register("powder_and_ball", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> GRAPESHOT = ITEMS.register("grapeshot", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> COMPACT_COPPER_ROUND = ITEMS.register("compact_copper_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> HOG_ROUND = ITEMS.register("hog_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> STANDARD_COPPER_ROUND = ITEMS.register("standard_copper_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> COMPACT_ADVANCED_ROUND = ITEMS.register("compact_advanced_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> RAMROD_ROUND = ITEMS.register("ramrod_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> ADVANCED_ROUND = ITEMS.register("advanced_round",
            () -> new TooltipAmmo(new Item.Properties(), 2));

    public static final DeferredItem<Item> SHATTER_ROUND = ITEMS.register("shatter_round", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> KRAHG_ROUND = ITEMS.register("krahg_round",
            () -> new TooltipAmmo(new Item.Properties(), 4));

    public static final DeferredItem<Item> BEOWULF_ROUND = ITEMS.register("beowulf_round",
            () -> new TooltipAmmo(new Item.Properties(), 2));

    public static final DeferredItem<Item> GIBBS_ROUND = ITEMS.register("gibbs_round",
            () -> new TooltipAmmo(new Item.Properties(), 2));

    public static final DeferredItem<Item> SHOTGUN_SHELL = ITEMS.register("shotgun_shell", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> BEARPACK_SHELL = ITEMS.register("bearpack_shell", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> BLAZE_FUEL = ITEMS.register("blaze_fuel",
            () -> new FuelAmmoItem(
                    new Item.Properties(),
                    3200,
                    ModItems.EMPTY_TANK,
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0),
                    new MobEffectInstance(MobEffects.WEAKNESS, 100, 0)
            ));


    public static final DeferredItem<Item> SHOTBALL = ITEMS.register("shotball", () -> new ThrowableShotballItem(new Item.Properties()));

    public static final DeferredItem<Item> ENERGY_CELL = ITEMS.register("energy_cell", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> SCULK_CELL = ITEMS.register("sculk_cell",
            () -> new TooltipAmmo(new Item.Properties(), 6));

    public static final DeferredItem<Item> SHOCK_CELL = ITEMS.register("shock_cell",
            () -> new TooltipAmmo(new Item.Properties(), "tooltip.scguns.arcing"));

    public static final DeferredItem<Item> MICROJET = ITEMS.register("microjet", () -> new AmmoItem(new Item.Properties()));

    public static final DeferredItem<Item> SHULKSHOT = ITEMS.register("shulkshot",
            () -> new TooltipAmmo(new Item.Properties(), "tooltip.scguns.homing"));


    public static final DeferredItem<Item> UNFINISHED_COMPACT_COPPER_ROUND = ITEMS.register("unfinished_compact_copper_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_HOG_ROUND = ITEMS.register("unfinished_hog_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_STANDARD_COPPER_ROUND = ITEMS.register("unfinished_standard_copper_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_COMPACT_ADVANCED_ROUND = ITEMS.register("unfinished_compact_advanced_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_RAMROD_ROUND = ITEMS.register("unfinished_ramrod_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_ADVANCED_ROUND = ITEMS.register("unfinished_advanced_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_SHATTER_ROUND = ITEMS.register("unfinished_shatter_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_KRAHG_ROUND = ITEMS.register("unfinished_krahg_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_BEOWULF_ROUND = ITEMS.register("unfinished_beowulf_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_GIBBS_ROUND = ITEMS.register("unfinished_gibbs_round", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_SHOTGUN_SHELL = ITEMS.register("unfinished_shotgun_shell", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_BEARPACK_SHELL = ITEMS.register("unfinished_bearpack_shell", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_ENERGY_CELL = ITEMS.register("unfinished_energy_cell", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_SCULK_CELL = ITEMS.register("unfinished_sculk_cell", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_MICROJET = ITEMS.register("unfinished_microjet", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_SHULKSHOT = ITEMS.register("unfinished_shulkshot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_ROCKET = ITEMS.register("unfinished_rocket", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_GUN_PARTS = ITEMS.register("unfinished_gun_parts", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_HEAVY_GUN_PARTS = ITEMS.register("unfinished_heavy_gun_parts", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_PLASMA_CORE = ITEMS.register("unfinished_plasma_core", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFINISHED_OSBORNE_SLUG = ITEMS.register("unfinished_osborne_slug", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROCKET = ITEMS.register("rocket", () -> new AmmoItem(new Item.Properties().stacksTo(32)));

    public static final DeferredItem<Item> OSBORNE_SLUG = ITEMS.register("osborne_slug", () -> new AmmoItem(new Item.Properties().stacksTo(4)));

    public static final DeferredItem<Item> PEBBLES = ITEMS.register("pebbles", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_SCRAP_CHUNK = ITEMS.register("netherite_scrap_chunk", () -> new ScorchedItem(new Item.Properties()));


    public static final DeferredItem<Item> PLASMA = ITEMS.register("plasma", () -> new FuelItem(new Item.Properties(), 1800));

    public static final DeferredItem<Item> PLASMA_NUGGET = ITEMS.register("plasma_nugget", () -> new FuelItem(new Item.Properties(), 360));

    public static final DeferredItem<Item> PISTOL_AMMO_BOX = ITEMS.register("pistol_ammo_box", () -> new PistolAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> RIFLE_AMMO_BOX = ITEMS.register("rifle_ammo_box", () -> new RifleAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SHOTGUN_AMMO_BOX = ITEMS.register("shotgun_ammo_box", () -> new ShotgunAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> MAGNUM_AMMO_BOX = ITEMS.register("magnum_ammo_box", () -> new MagnumAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ENERGY_AMMO_BOX = ITEMS.register("energy_ammo_box", () -> new EnergyAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> EMPTY_CASING_POUCH = ITEMS.register("empty_casing_pouch", () -> new EmptyCasingPouchItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ROCKET_AMMO_BOX = ITEMS.register("rocket_ammo_box", () -> new RocketAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SPECIAL_AMMO_BOX = ITEMS.register("special_ammo_box", () -> new SpecialAmmoBoxItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CREATIVE_AMMO_BOX = ITEMS.register("creative_ammo_box", () -> new CreativeAmmoBoxItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> DISHES_POUCH = ITEMS.register("dishes_pouch", () -> new DishesPouch(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ROCK_POUCH = ITEMS.register("rock_pouch", () -> new RockPouch(new Item.Properties().stacksTo(1)));


    // Projectiles And Throwables
    public static final DeferredItem<Item> GRENADE = ITEMS.register("grenade", () -> new GrenadeItem(new Item.Properties().stacksTo(32), 10 * 3));

    public static final DeferredItem<Item> STUN_GRENADE = ITEMS.register("stun_grenade", () -> new StunGrenadeItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> MOLOTOV_COCKTAIL = ITEMS.register("molotov_cocktail", () -> new MolotovCocktailItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> CHOKE_BOMB = ITEMS.register("choke_bomb", () -> new ChokeBombItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> SWARM_BOMB = ITEMS.register("swarm_bomb", () -> new SwarmBombItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> NAIL_BOMB = ITEMS.register("nail_bomb", () -> new NailBombItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> GAS_GRENADE = ITEMS.register("gas_grenade", () -> new GasGrenadeItem(new Item.Properties().stacksTo(32), 72000));

    public static final DeferredItem<Item> BEACON_GRENADE = ITEMS.register("beacon_grenade", () -> new BeaconGrenadeItem(new Item.Properties().stacksTo(32), 72000));


    // Medical Items
    public static final DeferredItem<Item> BASIC_POULTICE = ITEMS.register("basic_poultice",
            () -> new HealingBandageItem(new Item.Properties().stacksTo(16), 4, (MobEffectInstance) null));


    public static final DeferredItem<Item> HONEY_SULFUR_POULTICE = ITEMS.register("honey_sulfur_poultice",
            () -> new HealingBandageItem(new Item.Properties().stacksTo(16), 8, new MobEffectInstance(MobEffects.REGENERATION, 100, 0)));


    public static final DeferredItem<Item> ENCHANTED_BANDAGE = ITEMS.register("enchanted_bandage", () -> new GlintedHealingBandageItem(new Item.Properties().stacksTo(16).rarity(Rarity.RARE), 12, new MobEffectInstance(MobEffects.REGENERATION, 100, 1), new MobEffectInstance(MobEffects.ABSORPTION, 400, 0)));


    public static final DeferredItem<Item> DRAGON_SALVE = ITEMS.register("dragon_salve", () -> new GlintedHealingBandageItem(new Item.Properties().stacksTo(16).rarity(Rarity.RARE), 16, new MobEffectInstance(MobEffects.REGENERATION, 200, 1), new MobEffectInstance(MobEffects.ABSORPTION, 700, 0)));


    public static final DeferredItem<Item> COLD_PACK = ITEMS.register("cold_pack", () -> new ColdPackItem(new Item.Properties().stacksTo(16)));


    // Scope Attachments
    public static final DeferredItem<Item> LASER_SIGHT = ITEMS.register("laser_sight", () -> new LaserSightItem(Attachments.LASER_SIGHT, new Item.Properties().stacksTo(1).durability(1300)));

    public static final DeferredItem<Item> LONG_SCOPE = ITEMS.register("long_scope", () -> new ScopeItem(Attachments.LONG_SCOPE, new Item.Properties().stacksTo(1).durability(1600)));

    public static final DeferredItem<Item> MEDIUM_SCOPE = ITEMS.register("medium_scope", () -> new ScopeItem(Attachments.MEDIUM_SCOPE, new Item.Properties().stacksTo(1).durability(1400)));

    public static final DeferredItem<Item> REFLEX_SIGHT = ITEMS.register("reflex_sight", () -> new ScopeItem(Attachments.REFLEX_SIGHT, new Item.Properties().stacksTo(1).durability(1300)));

    // Stock Attachments
    public static final DeferredItem<Item> LIGHT_STOCK = ITEMS.register("light_stock", () -> new StockItem(Stock.create(GunModifiers.LIGHT_STOCK_MODIFIER), new Item.Properties().stacksTo(1).durability(1300), false));

    public static final DeferredItem<Item> WEIGHTED_STOCK = ITEMS.register("weighted_stock", () -> new StockItem(Stock.create(GunModifiers.WEIGHTED_STOCK_MODIFIER), new Item.Properties().stacksTo(1).durability(1700)));

    public static final DeferredItem<Item> WOODEN_STOCK = ITEMS.register("wooden_stock", () -> new StockItem(Stock.create(GunModifiers.WOODEN_STOCK_MODIFIER), new Item.Properties().stacksTo(1).durability(1550), false));

    // Barrel Attachments
    public static final DeferredItem<Item> SILENCER = ITEMS.register("silencer", () -> new BarrelItem(Barrel.create(0.0F, GunModifiers.SILENCER_MODIFIER, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1).durability(550)));

    public static final DeferredItem<Item> ADVANCED_SILENCER = ITEMS.register("advanced_silencer", () -> new BarrelItem(Barrel.create(0.0F, GunModifiers.ADVANCED_SILENCER_MODIFIER, GunModifiers.SILENCED), new Item.Properties().stacksTo(1).durability(1200)));

    public static final DeferredItem<Item> MUZZLE_BRAKE = ITEMS.register("muzzle_brake", () -> new BarrelItem(Barrel.create(0.0F, GunModifiers.MUZZLE_BRAKE_MODIFIER), new Item.Properties().stacksTo(1).durability(1400)));

    public static final DeferredItem<Item> EXTENDED_BARREL = ITEMS.register("extended_barrel", () -> new ExtendedBarrelItem(Barrel.create(0.0F, GunModifiers.EXTENDED_BARREL_MODIFIER), new Item.Properties().stacksTo(1).durability(700)));


    // Under Barrel Attachments
    public static final DeferredItem<Item> LIGHT_GRIP = ITEMS.register("light_grip", () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.LIGHT_RECOIL), new Item.Properties().stacksTo(1).durability(1400)));

    public static final DeferredItem<Item> VERTICAL_GRIP = ITEMS.register("vertical_grip", () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.REDUCED_RECOIL), new Item.Properties().stacksTo(1).durability(1600)));


    public static final DeferredItem<Item> IRON_BAYONET = ITEMS.register("iron_bayonet", () -> new BayonetItem(UnderBarrel.create(GunModifiers.IRON_BAYONET_DAMAGE), new Item.Properties().stacksTo(1).durability(256), 1.5f, -3.0f));

    public static final DeferredItem<Item> ANTHRALITE_BAYONET = ITEMS.register("anthralite_bayonet", () -> new BayonetItem(UnderBarrel.create(GunModifiers.ANTHRALITE_BAYONET_DAMAGE), new Item.Properties().stacksTo(1).durability(512), 2.0f, -3.0f));

    public static final DeferredItem<Item> DIAMOND_BAYONET = ITEMS.register("diamond_bayonet", () -> new BayonetItem(UnderBarrel.create(GunModifiers.DIAMOND_BAYONET_DAMAGE), new Item.Properties().stacksTo(1).durability(1024), 3.0f, -3.0f));

    public static final DeferredItem<Item> NETHERITE_BAYONET = ITEMS.register("netherite_bayonet", () -> new BayonetItem(UnderBarrel.create(GunModifiers.NETHERITE_BAYONET_DAMAGE), new Item.Properties().stacksTo(1).durability(1550), 4.0f, -3.0f));


    //Magazines
    public static final DeferredItem<Item> EXTENDED_MAG = ITEMS.register("extended_mag", () -> new MagazineItem(Magazine.create(GunModifiers.EXTENDED_MAG_MODIFIER), new Item.Properties().stacksTo(1).durability(1700)));

    public static final DeferredItem<Item> SPEED_MAG = ITEMS.register("speed_mag", () -> new MagazineItem(Magazine.create(GunModifiers.SPEED_MAG_MODIFIER), new Item.Properties().stacksTo(1).durability(1550)));

    public static final DeferredItem<Item> PLUS_P_MAG = ITEMS.register("plus_p_mag", () -> new MagazineItem(Magazine.create(GunModifiers.INCREASED_DAMAGE, GunModifiers.PLUS_P_MAG), new Item.Properties().stacksTo(1).durability(1400)));

    //ITEMS
    public static final DeferredItem<Item> REPAIR_KIT = ITEMS.register("repair_kit", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCAMP_PACKAGE = ITEMS.register("scamp_package", () -> new ScampPackageItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> COG_LOCATOR = ITEMS.register("cog_locator", () -> new CogLocatorItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> THE_PACT = ITEMS.register("the_pact", () -> new ThePactItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    // Mobs
    public static final DeferredItem<Item> COG_MINION_SPAWN_EGG = ITEMS.register("cog_minion_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.COG_MINION, 0x76501f, 0x7f8080, new Item.Properties()));

    public static final DeferredItem<Item> COG_KNIGHT_SPAWN_EGG = ITEMS.register("cog_knight_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.COG_KNIGHT, 0xf7cb6c, 0xbf8e55, new Item.Properties()));

    public static final DeferredItem<Item> TRAUMA_UNIT_SPAWN_EGG = ITEMS.register("trauma_unit_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TRAUMA_UNIT, 0xf7cb6c, 0xF2ECEB, new Item.Properties()));

    public static final DeferredItem<Item> SKY_CARRIER_SPAWN_EGG = ITEMS.register("sky_carrier_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SKY_CARRIER, 0xffeb8c, 0x4f4f4f, new Item.Properties()));

    public static final DeferredItem<Item> SUPPLY_SCAMP_SPAWN_EGG = ITEMS.register("supply_scamp_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SUPPLY_SCAMP, 0xffeb8c, 0x9f9b93, new Item.Properties()));

    public static final DeferredItem<Item> REDCOAT_SPAWN_EGG = ITEMS.register("redcoat_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.REDCOAT, 0xa02727, 0x74913a, new Item.Properties()));

    public static final DeferredItem<Item> DISSIDENT_SPAWN_EGG = ITEMS.register("dissident_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DISSIDENT, 0x202428, 0xab6621, new Item.Properties()));

    public static final DeferredItem<Item> HIVE_SPAWN_EGG = ITEMS.register("hive_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HIVE, 0x9c9a9a, 0x474545, new Item.Properties()));

    public static final DeferredItem<Item> SWARM_SPAWN_EGG = ITEMS.register("swarm_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SWARM, 0x535050, 0x151515, new Item.Properties()));

    public static final DeferredItem<Item> HORNLIN_SPAWN_EGG = ITEMS.register("hornlin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HORNLIN, 0xa2593a, 0x9c3f69, new Item.Properties()));

    public static final DeferredItem<Item> ZOMBIFIED_HORNLIN_SPAWN_EGG = ITEMS.register("zombified_hornlin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.ZOMBIFIED_HORNLIN, 0xe67973, 0x9c3f69, new Item.Properties()));

    public static final DeferredItem<Item> BLUNDERER_SPAWN_EGG = ITEMS.register("blunderer_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.BLUNDERER, 0x32663c, 0x98a2a2, new Item.Properties()));

    public static final DeferredItem<Item> THE_MERCHANT_SPAWN_EGG = ITEMS.register("the_merchant_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.THE_MERCHANT, 0x202428, 0x8b5a2b, new Item.Properties()));

    public static final DeferredItem<Item> SIGNAL_BEACON_SPAWN_EGG = ITEMS.register("signal_beacon_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SIGNAL_BEACON, 0xf7cb6c, 0xED1127, new Item.Properties()));

    public static final DeferredItem<Item> SCAMP_TANK_SPAWN_EGG = ITEMS.register("scamp_tank_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SCAMP_TANK, 0xffeb8c, 0x4f4f4f, new Item.Properties()));

    public static final DeferredItem<Item> SCAMPLER_SPAWN_EGG = ITEMS.register("scampler_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SCAMPLER, 0xffeb8c, 0xa02727, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }


}
