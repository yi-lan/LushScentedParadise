package net.royling.LushScentedParadise.Botania.BotaniaTeapot;

import net.minecraft.core.BlockPos;
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
import net.royling.LushScentedParadise.Botania.Reg.BotaniaBlockEntities;
import org.jetbrains.annotations.Nullable;

public class ManaTeapotBlock extends Block implements EntityBlock {
    public ManaTeapotBlock(Properties properties){
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ManaTeapotBlockEntity(blockPos,blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> type) {
        return type== BotaniaBlockEntities.MANA_TEAPOT.get()
                ?(BlockEntityTicker<T>) (lvl,pos,st,be)->((ManaTeapotBlockEntity)be).tick():null;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof ManaTeapotBlockEntity manaTeapotBlock){
                if(pPlayer instanceof ServerPlayer serverPlayer){
                    NetworkHooks.openScreen(serverPlayer,manaTeapotBlock,pPos);
                }
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

}
