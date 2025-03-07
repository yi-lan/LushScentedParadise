package net.royling.LushScentedParadise.ModBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.royling.LushScentedParadise.Registry.ModItems;

public class CoffeeTreeBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age",0,6);

    public CoffeeTreeBlock() {
        super(Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks().noCollission().instabreak().sound(SoundType.CROP));
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE,0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return blockState.getValue(AGE) < 6;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        int age = blockState.getValue(AGE);
        if(age < 6 ){
            serverLevel.setBlock(blockPos,blockState.setValue(AGE,age+1),2);
        }
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextInt(5)==0){
            int age = pState.getValue(AGE);
            if (age<6){
                pLevel.setBlock(pPos,pState.setValue(AGE,age+1),2);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pState.getValue(AGE)==6){
            int count = 3 + pLevel.random.nextInt(3);
            // 掉落咖啡果实
            Block.popResource(pLevel, pPos, new ItemStack(ModItems.COFFEE_FRUIT.get(), count));
            pLevel.setBlock(pPos,pState.setValue(AGE,4),2);
            return InteractionResult.SUCCESS;
        }
        return super.use(pState,pLevel,pPos,pPlayer,pHand,pHit);
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK) ||
                world.getBlockState(pos.below()).is(Blocks.DIRT) ||
                world.getBlockState(pos.below()).is(Blocks.PODZOL) ||
                world.getBlockState(pos.below()).is(Blocks.COARSE_DIRT);
    }
}
