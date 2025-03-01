package net.royling.LushScentedParadise.MobEffect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.UUID;

public class SandWalkerEffect extends MobEffect {
    private static final UUID SAND_WALKER_UUID = UUID.fromString("b1bb7d59-9e1f-499a-9e58-0e194dbb189c");
    private static final AttributeModifier SPEED_MODIFIER = new AttributeModifier(
            SAND_WALKER_UUID,"SandWalkerSpeedBoost",0.2,AttributeModifier.Operation.MULTIPLY_TOTAL
    );
    public SandWalkerEffect() {
        super(MobEffectCategory.BENEFICIAL,0xD6A522);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity instanceof Player player){
            if(player.level().getBiome(player.blockPosition()).is(Tags.Biomes.IS_DESERT)){
                if(player.getHealth()<player.getMaxHealth()){
                    player.heal(0.01f);
                }
            }
            BlockState blockunderfoot = player.level().getBlockState(player.blockPosition().below());
            if(blockunderfoot.is(BlockTags.create(new ResourceLocation("minecraft","sand_block")))){
                if(!player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).hasModifier(SPEED_MODIFIER)){
                player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).addTransientModifier(SPEED_MODIFIER);
                }
            }
            else {player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER);}
        }
    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
