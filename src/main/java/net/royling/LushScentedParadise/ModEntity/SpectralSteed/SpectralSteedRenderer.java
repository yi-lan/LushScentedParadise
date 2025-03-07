package net.royling.LushScentedParadise.ModEntity.SpectralSteed;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.royling.LushScentedParadise.LushScentedParadise;
import org.jetbrains.annotations.Nullable;

public class SpectralSteedRenderer extends MobRenderer<SpectralSteed,HorseModel<SpectralSteed>> {
    private static final ResourceLocation GHOST_HORSE_TEXTURE = new ResourceLocation(LushScentedParadise.MODID, "textures/entity/horse_ghost.png");


    public SpectralSteedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HorseModel<>(pContext.bakeLayer(ModelLayers.HORSE)),1);
    }

    @Override
    public ResourceLocation getTextureLocation(SpectralSteed spectralSteed) {
        return GHOST_HORSE_TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(SpectralSteed pLivingEntity, boolean pBodyVisible, boolean pTranslucent, boolean pGlowing) {
        return RenderType.entityTranslucent(GHOST_HORSE_TEXTURE);
    }
}
