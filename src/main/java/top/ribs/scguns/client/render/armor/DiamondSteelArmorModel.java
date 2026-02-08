package top.ribs.scguns.client.render.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.item.animated.DiamondSteelArmorItem;

public class DiamondSteelArmorModel extends GeoModel<DiamondSteelArmorItem> {
    @Override
    public ResourceLocation getModelResource(DiamondSteelArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "geo/diamond_steel_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondSteelArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "textures/armor/diamond_steel_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondSteelArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "animations/diamond_steel_armor.animation.json");
    }
}