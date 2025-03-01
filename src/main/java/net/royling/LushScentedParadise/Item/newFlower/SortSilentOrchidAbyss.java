package net.royling.LushScentedParadise.Item.newFlower;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.royling.LushScentedParadise.Registry.ModBlocks;

public class SortSilentOrchidAbyss extends FlowerBlock {


    public SortSilentOrchidAbyss(Properties properties) {
        super(MobEffects.NIGHT_VISION, 200,properties);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pLevel.isClientSide){
            int lightLevel = pLevel.getMaxLocalRawBrightness(pPos.above());
            BlockState belowState = pLevel.getBlockState(pPos.below());
            if(lightLevel <=4 && pRandom.nextFloat()<0.2f&&
                    (belowState.is(Blocks.STONE) || belowState.is(Blocks.DEEPSLATE) || belowState.is(Blocks.TUFF))&&
                    pLevel.isEmptyBlock(pPos.above())){
                pLevel.setBlock(pPos, ModFlowers.TALL_SILENT_ORCHID_ABYSS.get().defaultBlockState(),3);
            }
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState belowState = pLevel.getBlockState(pPos.below());
        return belowState.is(Blocks.STONE) || belowState.is(Blocks.DEEPSLATE)
                || belowState.is(Blocks.TUFF) || belowState.is(Blocks.CALCITE)
                || belowState.is(Blocks.ANDESITE) || belowState.is(Blocks.DIORITE)
                || belowState.is(Blocks.GRANITE) || belowState.is(Blocks.CLAY);
    }
}
