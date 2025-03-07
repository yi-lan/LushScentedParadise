package net.royling.LushScentedParadise.Botania.BotaniaEffect;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaEffects;
import net.royling.LushScentedParadise.LushScentedParadise;
import org.checkerframework.checker.optional.qual.OptionalBottom;


@Mod.EventBusSubscriber(modid = LushScentedParadise.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NatureResonanceEffect extends MobEffect {
    public NatureResonanceEffect(){
        super(MobEffectCategory.BENEFICIAL,0x00FF00);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide&&pLivingEntity instanceof Player player) {
            Level world = player.level();
            int flowerCount = countFlowersAround(player,7);
            if(flowerCount>=8){
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,240,flowerCount>=32?1:0,true,true));
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration%120==0;
    }

    @Override
    public int getColor() {
        return 0x00FF00;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("effect.lushscentedparadise.nature_resonance");
    }

    private int countFlowersAround(LivingEntity entity, int radius) {
        Level world = entity.level();
        BlockPos center = entity.blockPosition();
        int count = 0;

        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-radius, -1, -radius), center.offset(radius, 1, radius))) {
            BlockState state = world.getBlockState(pos);
            if (state.is(BlockTags.FLOWERS)) {
                count++;
            }
        }
        return count;
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (ModList.get().isLoaded("botania")) {
            System.out.println("破坏方块");
            if (event.getPlayer().hasEffect(BotaniaEffects.NATURE_RESONANCE.get())) {
                BlockState state = event.getState();
                Level world = (Level) event.getLevel();
                BlockPos pos = event.getPos();
                Player player = event.getPlayer();

                Block livingwood = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("botania", "livingwood_log"));
                Block livingrock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("botania", "livingrock"));
                System.out.println("Block:" + livingwood);
                if (!world.isClientSide) {
                    if (state.is(BlockTags.LOGS) && livingwood != null && !player.isCreative()) {
                        event.setCanceled(true); // 取消原本掉落
                        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                        Block.popResource(world, pos, new ItemStack(livingwood));
                    } else if (state.is(Blocks.STONE) && livingrock != null && !player.isCreative()) {
                        event.setCanceled(true); // 取消原本掉落
                        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                        Block.popResource(world, pos, new ItemStack(livingrock));
                    }
                }
            }
        }
    }


}
