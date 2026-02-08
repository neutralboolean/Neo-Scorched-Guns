package top.ribs.scguns.client.render.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.item.animated.CogKnightArmorItem;

public class CogKnightArmorModel extends GeoModel<CogKnightArmorItem> {
    @Override
    public ResourceLocation getModelResource(CogKnightArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "geo/cog_knight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CogKnightArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "textures/armor/cog_knight_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CogKnightArmorItem animatable) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "animations/cog_knight_armor.animation.json");
    }
}