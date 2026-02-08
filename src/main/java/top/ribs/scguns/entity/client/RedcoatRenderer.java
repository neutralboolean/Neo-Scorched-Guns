package top.ribs.scguns.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.entity.monster.RedcoatEntity;

public class RedcoatRenderer extends MobRenderer<RedcoatEntity, RedcoatModel<RedcoatEntity>> {
    public RedcoatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedcoatModel<>(pContext.bakeLayer(ModModelLayers.REDCOAT_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedcoatEntity pEntity) {
        return new ResourceLocation(NeoScorchedGunsMain.MODID, "textures/entity/redcoat.png");
    }

    @Override
    public void render(RedcoatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}






