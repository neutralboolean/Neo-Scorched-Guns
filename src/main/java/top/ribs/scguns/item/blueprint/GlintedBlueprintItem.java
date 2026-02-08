package top.ribs.scguns.item.blueprint;

import net.minecraft.world.item.ItemStack;

public class GlintedBlueprintItem extends BlueprintItem {
    public GlintedBlueprintItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
    @Override
    public boolean isFireResistant() {
        return true;
    }

}


