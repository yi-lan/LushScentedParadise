package net.royling.LushScentedParadise.ModBlock.DryingRack;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.royling.LushScentedParadise.Registry.ModRecipeTypes;
import org.joml.Matrix4f;

public class DryingRackRender implements BlockEntityRenderer<DryingRackBlockEntity> {
    private static final float ITEM_SCALE = 0.3F;
    private static final float GRID_SIZE = 0.3F;
    private static final float ITEM_HEIGHT = 1.0125F;
    private static final int PROGRESS_COLOR = 0XFF00FF;

    private final ItemRenderer itemRenderer;

    public DryingRackRender(BlockEntityRendererProvider.Context context){
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(DryingRackBlockEntity pBlockEntity, float pPartialTick,
                       PoseStack pPoseStack, MultiBufferSource pBuffer,
                       int pPackedLight, int pPackedOverlay) {
        for(int slot =0;slot<DryingRackBlockEntity.SLOT_COUNT;slot++){
            ItemStack stack = pBlockEntity.items.get(slot);
            if(!stack.isEmpty()){
                renderItem(pBlockEntity,pPoseStack,pBuffer,pPackedLight,pPackedOverlay,stack,slot);
                //renderProgressBar(pBlockEntity,pPoseStack,pBuffer,slot);
            }
        }
    }
    private void renderItem(DryingRackBlockEntity be,PoseStack poseStack, MultiBufferSource buffer,
                            int light, int overlay, ItemStack stack, int slot) {
        poseStack.pushPose();
        int row =slot/3;
        int col =slot%3;
        float offsetX = (col - 1) * GRID_SIZE;
        float offsetZ = (row - 1) * GRID_SIZE;
        Level level = be.getLevel();
        BlockPos pos = be.getBlockPos().above();
        int skyLight = level.getBrightness(LightLayer.SKY,pos);
        int blockLight = level.getBrightness(LightLayer.BLOCK,pos);
        System.out.println("SkyLight:"+skyLight+" BlockLight:"+blockLight);

        poseStack.translate(offsetX+0.5, ITEM_HEIGHT, offsetZ+0.5);

        poseStack.mulPose(Axis.XP.rotationDegrees(90));

        float randomRotation = (float) (Math.random() * 360);
        //poseStack.mulPose(Axis.ZP.rotationDegrees(randomRotation));
        poseStack.scale(ITEM_SCALE,ITEM_SCALE,ITEM_SCALE);
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED,
                LightTexture.pack(blockLight,skyLight), overlay,poseStack,buffer,
                be.getLevel(),0);
        poseStack.popPose();
    }
    private void renderProgressBar(DryingRackBlockEntity be, PoseStack poseStack,
                                MultiBufferSource buffer, int slot) {
        int progress = be.dryingProgress[slot];
        int totalTime = be.getLevel().getRecipeManager()
                .getRecipeFor(ModRecipeTypes.DRYING_RECIPE.get(), new SimpleContainer(be.items.get(slot)), be.getLevel())
                .map(DryingRecipe::getDryingTime)
                .orElse(200);

        if (totalTime <= 0 || progress >= totalTime) return;

        float progressPercent = (float) progress / totalTime;

        int row = slot / 3;
        int col = slot % 3;
        float xPos = (col - 1) * GRID_SIZE;
        float zPos = (row - 1) * GRID_SIZE;

        drawProgressBar(poseStack, buffer, xPos, zPos, 0.3f, 0.02f, 0x80000000);
        drawProgressBar(poseStack, buffer, xPos, zPos, progressPercent * 0.3f, 0.02f, PROGRESS_COLOR);

    }

    private void drawProgressBar(PoseStack poseStack, MultiBufferSource buffer, float x, float z,
                                 float width, float height, int color) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.gui());

        poseStack.pushPose();
        poseStack.translate(x+0.5, ITEM_HEIGHT + 0.2f, z+0.5);
        poseStack.mulPose(Axis.XP.rotationDegrees(270));
        Matrix4f matrix = poseStack.last().pose();

        float a = (color >> 24 & 0xFF) / 255.0f;
        float r = (color >> 16 & 0xFF) / 255.0f;
        float g = (color >> 8 & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;
        vertexConsumer.vertex(matrix, 0, 0, 0).color(r, g, b, a).endVertex();
        vertexConsumer.vertex(matrix, width, 0, 0).color(r, g, b, a).endVertex();
        vertexConsumer.vertex(matrix, width, height, 0).color(r, g, b, a).endVertex();
        vertexConsumer.vertex(matrix, 0, height, 0).color(r, g, b, a).endVertex();

        poseStack.popPose();
    }
}
