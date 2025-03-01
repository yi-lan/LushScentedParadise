package net.royling.LushScentedParadise.ModBlock.TeapotBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.royling.LushScentedParadise.Registry.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class TeapotBlock extends Block implements EntityBlock {

    public TeapotBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TeapotBlockEntity(pPos, pState);
    }
    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == ModBlockEntities.TEAPOT.get()
                ? (BlockEntityTicker<T>) (lvl, pos, st, be) -> ((TeapotBlockEntity) be).tick()
                : null;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof TeapotBlockEntity teapot){
                if(teapot.isHeated()){
                    if(pPlayer instanceof ServerPlayer serverPlayer){
                        NetworkHooks.openScreen(serverPlayer,teapot,pPos);
                    }

                }else {
                    pPlayer.displayClientMessage(Component.translatable("lushscentedparadise.no_heated.text"),true);
                }
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(!pLevel.isClientSide){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof TeapotBlockEntity teapot){
                boolean previousState = teapot.isHeated();
                teapot.updateHeatingState();
                if(previousState != teapot.isHeated()){
                    teapot.setChanged();
                }
            }
        }
    }
}
