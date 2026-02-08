package top.ribs.scguns.item.ammo.impl.ammo_boxes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import top.ribs.scguns.NeoScorchedGunsMain;

public class DishesPouch extends AmmoBoxItem {
    private static final int CASING_MAX_ITEM_COUNT = 512;
    private static final int CASING_BAR_COLOR = Mth.color(0.4F, 0.4F, 0.7F);

    public DishesPouch(Properties properties) {
        super(properties);
    }

    @Override
    protected ResourceLocation getAmmoTag() {
        return ResourceLocation.fromNamespaceAndPath(NeoScorchedGunsMain.MODID, "dishes");
    }



    @Override
    public int getBarColor(ItemStack stack) {
        return CASING_BAR_COLOR;
    }

    @Override
    protected int getBaseMaxItemCount() {
        return CASING_MAX_ITEM_COUNT;
    }

}
