package top.ribs.scguns.init;

import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.enchantment.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Author: MrCrayfish
 */
public class ModEnchantments
{
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NeoScorchedGunsMain.MODID);

    public static final RegistryObject<Enchantment> QUICK_HANDS = ENCHANTMENTS.register("quick_hands", QuickHandsEnchantment::new);
    public static final RegistryObject<Enchantment> TRIGGER_FINGER = ENCHANTMENTS.register("trigger_finger", TriggerFingerEnchantment::new);
    public static final RegistryObject<Enchantment> LIGHTWEIGHT = ENCHANTMENTS.register("lightweight", LightweightEnchantment::new);
    public static final RegistryObject<Enchantment> COLLATERAL = ENCHANTMENTS.register("collateral", CollateralEnchantment::new);
    public static final RegistryObject<Enchantment> RECLAIMED = ENCHANTMENTS.register("reclaimed", ReclaimedEnchantment::new);
    public static final RegistryObject<Enchantment> ACCELERATOR = ENCHANTMENTS.register("accelerator", AcceleratorEnchantment::new);
    public static final RegistryObject<Enchantment> PUNCTURING = ENCHANTMENTS.register("puncturing", PuncturingEnchantment::new);
    public static final RegistryObject<Enchantment> SHELL_CATCHER = ENCHANTMENTS.register("shell_catcher", ShellCatcherEnchantment::new);
    public static final RegistryObject<Enchantment> BANZAI = ENCHANTMENTS.register("banzai", BanzaiEnchantment::new);
    public static final RegistryObject<Enchantment> HEAVY_SHOT = ENCHANTMENTS.register("heavy_shot", HeavyShotEnchantment::new);
    public static final RegistryObject<Enchantment> ELEMENTAL_POP = ENCHANTMENTS.register("elemental_pop", ElementalPopEnchantment::new);
    public static final RegistryObject<Enchantment> WATER_PROOF = ENCHANTMENTS.register("waterproof", WaterProofEnchantment::new);
    public static final RegistryObject<Enchantment> HOT_BARREL = ENCHANTMENTS.register("hot_barrel", HotBarrelEnchantment::new);
    public static final RegistryObject<Enchantment> GUN_RUST = ENCHANTMENTS.register("gun_rust", GunRustEnchantment::new);
    public static final RegistryObject<Enchantment> CORRODED = ENCHANTMENTS.register("corroded", CorrodedEnchantment::new);
}
