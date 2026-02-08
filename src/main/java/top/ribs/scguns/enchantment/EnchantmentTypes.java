package top.ribs.scguns.enchantment;

import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.common.FireMode;
import top.ribs.scguns.init.ModTags;
import top.ribs.scguns.item.attachment.impl.BayonetItem;
import top.ribs.scguns.item.gun.GunItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * Author: MrCrayfish
 */
public class EnchantmentTypes {
    public static final EnchantmentCategory GUN = EnchantmentCategory.create(NeoScorchedGunsMain.MODID + ":gun", item -> item instanceof GunItem);
    public static final EnchantmentCategory SEMI_AUTO_GUN = EnchantmentCategory.create(NeoScorchedGunsMain.MODID + ":semi_auto_gun", item -> item instanceof GunItem && ((GunItem) item).getGun().getGeneral().getFireMode() != FireMode.AUTOMATIC);
    public static final EnchantmentCategory BAYONET = EnchantmentCategory.create(NeoScorchedGunsMain.MODID + ":bayonet", item -> item instanceof BayonetItem);

    public static final EnchantmentCategory TRIGGER_FINGER_COMPATIBLE = EnchantmentCategory.create(
            NeoScorchedGunsMain.MODID + ":trigger_finger_compatible",
            item -> item instanceof GunItem && !item.builtInRegistryHolder().is(ModTags.Items.SINGLE_SHOT)
    );


    public static final EnchantmentCategory WATER_PROOF_COMPATIBLE = EnchantmentCategory.create(
            NeoScorchedGunsMain.MODID + ":water_proof_compatible",
            item -> item instanceof GunItem
    );

    // Shell catcher compatible
    public static final EnchantmentCategory SHELL_CATCHER_COMPATIBLE = EnchantmentCategory.create(
            NeoScorchedGunsMain.MODID + ":shell_catcher_compatible",
            item -> item instanceof GunItem && !item.builtInRegistryHolder().is(ModTags.Items.DOES_NOT_EJECT_CASINGS)
    );

    // Collateral compatible
    public static final EnchantmentCategory COLLATERAL_COMPATIBLE = EnchantmentCategory.create(
            NeoScorchedGunsMain.MODID + ":collateral_compatible",
            item -> item instanceof GunItem && !item.builtInRegistryHolder().is(ModTags.Items.NON_COLLATERAL)
    );
}