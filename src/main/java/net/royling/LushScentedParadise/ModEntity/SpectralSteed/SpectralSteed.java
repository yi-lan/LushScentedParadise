package net.royling.LushScentedParadise.ModEntity.SpectralSteed;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class SpectralSteed extends AbstractHorse {
    private static final double MIN_SPEED = 0.312;
    private static final double MAX_SPEED = 0.352;
    private static final double JUMP_STRENGTH = 0.92;

    public SpectralSteed(EntityType<? extends AbstractHorse> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return AbstractHorse.createBaseHorseAttributes()
                .add(Attributes.MAX_HEALTH, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.33)
                .add(Attributes.JUMP_STRENGTH, 0.92);
    }
    @Override
    protected void randomizeAttributes(RandomSource random) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(MIN_SPEED + random.nextDouble() * (MAX_SPEED - MIN_SPEED));
        this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(JUMP_STRENGTH);
    }
    @Override
    public boolean isTamed() {
        return super.isTamed();
    }
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.POPPY); // 使用虞美人驯服
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.level().isClientSide) {
            for (int i = 0; i < 2; i++) {
                double offsetX = (this.random.nextDouble() - 0.5) * this.getBbWidth();
                double offsetY = 0.1;
                double offsetZ = (this.random.nextDouble() - 0.5) * this.getBbWidth();
                this.level().addParticle(net.minecraft.core.particles.ParticleTypes.SOUL, this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ, 0, 0.02, 0);
            }
        }
        if (!this.level().isClientSide && this.isAlive() && this.getHealth() < this.getMaxHealth()) {
            BlockPos pos = this.blockPosition();
            if (this.level().getBlockState(pos.below()).is(Blocks.POPPY)) { // 靠近虞美人方块恢复生命
                this.heal(0.5f);
            }
        }
    }

    @Override
    public boolean canWearArmor() {
        return false;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }
}
