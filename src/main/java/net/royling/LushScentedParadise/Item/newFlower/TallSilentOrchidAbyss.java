package net.royling.LushScentedParadise.Item.newFlower;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.common.Tags;
import net.royling.LushScentedParadise.Registry.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class TallSilentOrchidAbyss extends TallFlowerBlock {

    public TallSilentOrchidAbyss(Properties properties) {
        super(properties);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if(!pLevel.isClientSide&&pPlayer.getMainHandItem().is(Items.SHEARS)){
            int dropCount = 2+pLevel.random.nextInt(3);
            popResource(pLevel,pPos,new ItemStack(ModFlowers.SORT_SILENT_ORCHID_ABYSS.get(),dropCount));
        }
        super.playerWillDestroy(pLevel,pPos,pState,pPlayer);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        if(!pLevel.isClientSide&&pState.getValue(HALF)==DoubleBlockHalf.LOWER) {
            BlockPos above = pPos.above();
            if (!pLevel.isClientSide && pLevel.isEmptyBlock(above)) {
                pLevel.setBlock(above, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
            }
        }
    }
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        if (pState.getValue(HALF) != DoubleBlockHalf.UPPER){
        BlockState belowState = pLevel.getBlockState(pPos.below());
        return belowState.is(Blocks.STONE) || belowState.is(Blocks.DEEPSLATE)
                || belowState.is(Blocks.TUFF) || belowState.is(Blocks.CALCITE)
                || belowState.is(Blocks.ANDESITE) || belowState.is(Blocks.DIORITE)
                || belowState.is(Blocks.GRANITE)||belowState.is(Blocks.CLAY);
        }
        else {
            BlockState belowState = pLevel.getBlockState(pPos.below());
            return belowState.is(ModFlowers.TALL_SILENT_ORCHID_ABYSS.get());
        }
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
        if(!pPlayer.getMainHandItem().is(Items.SHEARS)){
            super.playerDestroy(pLevel,pPlayer,pPos,pState,pTe,pStack);
        }
    }
}
