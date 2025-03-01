package net.royling.LushScentedParadise.MobEffect;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;

public class ColdResistanceEffect extends MobEffect {
    public ColdResistanceEffect(){
        super(MobEffectCategory.BENEFICIAL,0x00BFFF);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide){
            BlockPos pos = pLivingEntity.blockPosition();
            if(pLivingEntity.level().getBlockState(pos).is(Blocks.POWDER_SNOW)){
                pLivingEntity.setTicksFrozen(0);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public int getColor() {
        return 0x00BFFF;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("effect.lushscentedparadise.cold_resistance");
    }
}
