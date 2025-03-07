package net.royling.LushScentedParadise.Item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FlowerFertilizer extends Item {
    public FlowerFertilizer(Properties properties){
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if(!(level instanceof ServerLevel serverLevel)) return InteractionResult.PASS;
        BlockPos clickedPos = pContext.getClickedPos();
        RandomSource random = serverLevel.getRandom();
        ResourceKey<Biome> biomekey = serverLevel.getBiome(clickedPos).unwrapKey().orElse(null);
        if(biomekey==null) return InteractionResult.FAIL;

        List<BlockState> possiblePlants = getPlantsForBiome(biomekey);
        if(possiblePlants.isEmpty()) return InteractionResult.FAIL;

        List<BlockPos> validPosi = getValidSoilPos(serverLevel, clickedPos);
        for (int i = validPosi.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            BlockPos temp = validPosi.get(i);
            validPosi.set(i, validPosi.get(j));
            validPosi.set(j, temp);
        }

        float prob = 0.7f;
        int plantCount = 0;
        int attempts = 0;

        for(BlockPos pos : validPosi){
            if(plantCount >=7 || attempts >=7) break; // 最多尝试7次
            if(isValidSoil(serverLevel, pos)) {
                if(random.nextFloat() <= prob) {
                    BlockState plant = possiblePlants.get(random.nextInt(possiblePlants.size()));
                    serverLevel.setBlockAndUpdate(pos.above(), plant);
                    plantCount++;
                }
                prob -= 0.1f; // 每次尝试后递减概率
                attempts++;
            }
        }

        if(plantCount > 0){
            pContext.getItemInHand().shrink(1);
            serverLevel.playSound(null,clickedPos.above(), SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS,1.0F,0.8F);
            serverLevel.sendParticles(
                    ParticleTypes.HAPPY_VILLAGER,
                    clickedPos.above().getX() + 0.5,
                    clickedPos.above().getY() + 0.5,
                    clickedPos.above().getZ() + 0.5,
                    25, 0.5, 0.5, 0.5, 0.0
            );
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    private static final Map<ResourceKey<Biome>, List<BlockState>> BIOME_TO_PLANTS = Map.of(
            Biomes.PLAINS, List.of(
                    ModFlowers.VIOLET.get().defaultBlockState(),
                    ModFlowers.LILY.get().defaultBlockState(),
                    ModFlowers.PERILLA.get().defaultBlockState()
            ),
            Biomes.FOREST, List.of(
                    ModFlowers.VIOLET.get().defaultBlockState(),
                    ModFlowers.PEONY.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.LILY.get().defaultBlockState()
            ),
            Biomes.MEADOW, List.of(
                    ModFlowers.VIOLET.get().defaultBlockState(),
                    ModFlowers.LILY.get().defaultBlockState(),
                    ModFlowers.LAVENDER.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.OENOTHERA_LINDHEIMERI.get().defaultBlockState(),
                    ModFlowers.PEONY.get().defaultBlockState(),
                    ModFlowers.HONEYSUCKLE.get().defaultBlockState()
            ),
            Biomes.SWAMP,List.of(
                    ModFlowers.JASMINE.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.SAFFLOWER.get().defaultBlockState()
            ),
            Biomes.SAVANNA,List.of(
                    ModFlowers.HIBISCUS.get().defaultBlockState(),
                    ModFlowers.PERILLA.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.SAFFLOWER.get().defaultBlockState()
            ),
            Biomes.DESERT,List.of(
                    ModFlowers.HIBISCUS.get().defaultBlockState(),
                    ModFlowers.PERILLA.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.SAFFLOWER.get().defaultBlockState()
            ),
            Biomes.SAVANNA_PLATEAU,List.of(
                    ModFlowers.HIBISCUS.get().defaultBlockState(),
                    ModFlowers.PERILLA.get().defaultBlockState(),
                    ModFlowers.MARIGOLD.get().defaultBlockState(),
                    ModFlowers.SAFFLOWER.get().defaultBlockState()
            )
    );


    private List<BlockState> getPlantsForBiome(ResourceKey<Biome> biomeKey){
        return BIOME_TO_PLANTS.getOrDefault(biomeKey, new ArrayList<>());
    }


    private List<BlockPos> getValidSoilPos(ServerLevel level, BlockPos centerPos){
        List<BlockPos> validPositions = new ArrayList<>();
        AABB box = new AABB(centerPos).inflate(3, 1, 3);

        BlockPos.betweenClosedStream(box)
                .map(BlockPos::immutable)
                .filter(pos -> isValidSoil(level, pos))
                .forEach(validPositions::add);

        return validPositions;
    }


    private boolean isValidSoil(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockState aboveState = level.getBlockState(pos.above());
        // 检查所有土壤类型，且上方为空气或可替换方块
        return (state.is(Blocks.GRASS_BLOCK) ||
                state.is(Blocks.DIRT) ||
                state.is(Blocks.PODZOL) ||
                state.is(Blocks.FARMLAND) ||
                state.is(Blocks.MYCELIUM))
                && (aboveState.isAir());
    }
}

