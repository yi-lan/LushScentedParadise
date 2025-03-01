package net.royling.LushScentedParadise.dataGen.WorldGenData;

import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;
import net.royling.LushScentedParadise.LushScentedParadise;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("removal")
public class ModDatagenProvider extends DatapackBuiltinEntriesProvider {
    public ModDatagenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, ModDatagenProvider::bootstrapConfiguredFeatures)
                        .add(Registries.PLACED_FEATURE, ModDatagenProvider::bootstrapPlacedFeatures)
                        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModDatagenProvider::bootstrapBiomeModifiers),
                Set.of(LushScentedParadise.MODID));
    }
    private static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
        List<FlowerFeatureData> flowers = List.of(
                /**
                 * 添加地物
                 */
                new FlowerFeatureData("violet", ModFlowers.VIOLET.get(), 16, 6, 3,"flower"),
                new FlowerFeatureData("hibiscus",ModFlowers.HIBISCUS.get(),16,6,3,"flower"),
                new FlowerFeatureData("jasmine",ModFlowers.JASMINE.get(),16,6,3,"flower"),
                new FlowerFeatureData("lily",ModFlowers.LILY.get(),16,6,3,"flower"),
                new FlowerFeatureData("lavender",ModFlowers.LAVENDER.get(),16,6,3,"flower"),
                new FlowerFeatureData("marigold",ModFlowers.MARIGOLD.get(),16,6,3,"flower"),
                new FlowerFeatureData("oenothera_lindheimeri",ModFlowers.OENOTHERA_LINDHEIMERI.get(),16,6,3,"flower"),
                new FlowerFeatureData("herbaceous_penoy",ModFlowers.PEONY.get(),16,6,3,"flower"),
                new FlowerFeatureData("perilla",ModFlowers.PERILLA.get(),16,6,3,"flower"),
                new FlowerFeatureData("safflower",ModFlowers.SAFFLOWER.get(),16,6,3,"flower"),
                new FlowerFeatureData("snow_lotus",ModFlowers.SNOW_LOTUS.get(),6,2,2,"flower"),
                new FlowerFeatureData("honeysuckle",ModFlowers.HONEYSUCKLE.get(),16,6,3,"flower"),

                new FlowerFeatureData("wild_tea",ModFlowers.WILD_TEA.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_mint",ModFlowers.WILD_MINT.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_licorice",ModFlowers.WILD_LICORICE.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_astragalus",ModFlowers.WILD_ASTRAGALUS.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_verbena",ModFlowers.WILD_VERBENA.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_ginger",ModFlowers.WILD_GINGER.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_burdock",ModFlowers.WILD_BURDOCK.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_kudzu",ModFlowers.WILD_KUDZU.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_poria",ModFlowers.WILD_PORIA.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_flax",ModFlowers.WILD_FLAX.get(),12,4,3,"flower")

        );
        for (FlowerFeatureData flower : flowers) {
            if(flower.rule == "flower"){
            ResourceKey<ConfiguredFeature<?, ?>> key = ResourceKey.create(
                    Registries.CONFIGURED_FEATURE, new ResourceLocation(LushScentedParadise.MODID, flower.name)
            );
            context.register(key, new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(
                    flower.tries, flower.xzSpread, flower.ySpread, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(flower.block.defaultBlockState()))))

            ));
        }
            else if(flower.rule == "cave"){
                ResourceKey<ConfiguredFeature<?, ?>> key = ResourceKey.create(
                        Registries.CONFIGURED_FEATURE, new ResourceLocation(LushScentedParadise.MODID, flower.name)
                );
                context.register(key, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,new SimpleBlockConfiguration(
                        BlockStateProvider.simple(flower.block.defaultBlockState())
                )));
            }
        }
    }
    private static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> context) {
        List<FlowerFeatureData> flowers = List.of(
                /**
                 *添加生成条件区域
                 */
                new FlowerFeatureData("violet", ModFlowers.VIOLET.get(), 16, 6, 3,"flower"),
                new FlowerFeatureData("hibiscus",ModFlowers.HIBISCUS.get(),16,6,3,"flower"),
                new FlowerFeatureData("jasmine",ModFlowers.JASMINE.get(),16,6,3,"flower"),
                new FlowerFeatureData("lily",ModFlowers.LILY.get(),16,6,3,"flower"),
                new FlowerFeatureData("lavender",ModFlowers.LAVENDER.get(),16,6,3,"flower"),
                new FlowerFeatureData("marigold",ModFlowers.MARIGOLD.get(),16,6,3,"flower"),
                new FlowerFeatureData("oenothera_lindheimeri",ModFlowers.OENOTHERA_LINDHEIMERI.get(),16,6,3,"flower"),
                new FlowerFeatureData("herbaceous_penoy",ModFlowers.PEONY.get(),16,6,3,"flower"),
                new FlowerFeatureData("perilla",ModFlowers.PERILLA.get(),16,6,3,"flower"),
                new FlowerFeatureData("safflower",ModFlowers.SAFFLOWER.get(),16,6,3,"flower"),
                new FlowerFeatureData("snow_lotus",ModFlowers.SNOW_LOTUS.get(),6,2,2,"flower"),
                new FlowerFeatureData("honeysuckle",ModFlowers.HONEYSUCKLE.get(),16,6,3,"flower"),

                new FlowerFeatureData("wild_tea",ModFlowers.WILD_TEA.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_mint",ModFlowers.WILD_MINT.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_licorice",ModFlowers.WILD_LICORICE.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_astragalus",ModFlowers.WILD_ASTRAGALUS.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_verbena",ModFlowers.WILD_VERBENA.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_ginger",ModFlowers.WILD_GINGER.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_burdock",ModFlowers.WILD_BURDOCK.get(),12,4,3,"flower"),
                new FlowerFeatureData("wild_kudzu",ModFlowers.WILD_KUDZU.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_poria",ModFlowers.WILD_PORIA.get(),12,4,2,"flower"),
                new FlowerFeatureData("wild_flax",ModFlowers.WILD_FLAX.get(),12,4,3,"flower")
        );
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        for (FlowerFeatureData flower : flowers) {
            if(Objects.equals(flower.rule, "flower")){
            ResourceKey<PlacedFeature> key = ResourceKey.create(
                    Registries.PLACED_FEATURE, new ResourceLocation(LushScentedParadise.MODID, flower.name)
            );
            context.register(key, new PlacedFeature(
                    configuredFeatures.getOrThrow(ResourceKey.create(
                                    Registries.CONFIGURED_FEATURE,
                                    new ResourceLocation(LushScentedParadise.MODID, flower.name)
                            )
                    ), List.of(
                                    NoiseThresholdCountPlacement.of(-0.8f, 4, 15),
                                    RarityFilter.onAverageOnceEvery(72),
                                    InSquarePlacement.spread(),
                                    PlacementUtils.HEIGHTMAP,
                                    BiomeFilter.biome()
                            ))
                );
            }
            if(Objects.equals(flower.rule, "cave")){
                ResourceKey<PlacedFeature> key = ResourceKey.create(
                        Registries.PLACED_FEATURE, new ResourceLocation(LushScentedParadise.MODID, flower.name)
                );
                context.register(key, new PlacedFeature(
                                configuredFeatures.getOrThrow(ResourceKey.create(
                                                Registries.CONFIGURED_FEATURE,
                                                new ResourceLocation(LushScentedParadise.MODID, flower.name)
                                        )
                                ), List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        RarityFilter.onAverageOnceEvery(72),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(30)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(
                                List.of(Blocks.STONE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.ANDESITE,Blocks.CLAY)),
                                BlockPredicate.hasSturdyFace(Direction.UP))),
                        BiomeFilter.biome()
                        ))
                );
            }
            }
        }
    private static void bootstrapBiomeModifiers(BootstapContext<BiomeModifier> context) {
        List<BiomeFeatureData> flowers = List.of(
                /**
                 * 添加群系修改模块
                 */
                new BiomeFeatureData("violet", "violet", List.of(Biomes.PLAINS,Biomes.FLOWER_FOREST,Biomes.MEADOW),"flower"),
                new BiomeFeatureData("hibiscus", "hibiscus", List.of(Biomes.SAVANNA,Biomes.SAVANNA_PLATEAU,Biomes.WINDSWEPT_SAVANNA,Biomes.DESERT,Biomes.BADLANDS,Biomes.WOODED_BADLANDS,Biomes.ERODED_BADLANDS),"flower"),
                new BiomeFeatureData("jasmine", "jasmine", List.of(Biomes.SWAMP,Biomes.MANGROVE_SWAMP,Biomes.RIVER,Biomes.BEACH),"flower"),
                new BiomeFeatureData("lily", "lily", List.of(Biomes.PLAINS,Biomes.FLOWER_FOREST,Biomes.MEADOW,Biomes.RIVER,Biomes.BEACH),"flower"),
                new BiomeFeatureData("lavender", "lavender", List.of(Biomes.MEADOW,Biomes.SNOWY_SLOPES,Biomes.JAGGED_PEAKS,Biomes.STONY_PEAKS,Biomes.WINDSWEPT_HILLS,Biomes.WINDSWEPT_FOREST,Biomes.WINDSWEPT_GRAVELLY_HILLS),"flower"),
                new BiomeFeatureData("marigold", "marigold", List.of(Biomes.SWAMP,Biomes.MANGROVE_SWAMP,Biomes.RIVER,Biomes.BEACH,Biomes.FLOWER_FOREST,Biomes.MEADOW,Biomes.SAVANNA,Biomes.SAVANNA_PLATEAU,Biomes.WINDSWEPT_SAVANNA),"flower"),
                new BiomeFeatureData("oenothera_lindheimeri", "oenothera_lindheimeri", List.of(Biomes.MEADOW,Biomes.SNOWY_SLOPES,Biomes.JAGGED_PEAKS,Biomes.STONY_PEAKS,Biomes.WINDSWEPT_HILLS,Biomes.WINDSWEPT_FOREST,Biomes.WINDSWEPT_GRAVELLY_HILLS),"flower"),
                new BiomeFeatureData("herbaceous_penoy", "herbaceous_penoy", List.of(Biomes.FLOWER_FOREST,Biomes.MEADOW,Biomes.FOREST,Biomes.BIRCH_FOREST,Biomes.DARK_FOREST),"flower"),
                new BiomeFeatureData("perilla", "perilla", List.of(Biomes.SAVANNA,Biomes.SAVANNA_PLATEAU,Biomes.WINDSWEPT_SAVANNA,Biomes.DESERT,Biomes.BADLANDS,Biomes.WOODED_BADLANDS,Biomes.ERODED_BADLANDS,Biomes.PLAINS,Biomes.FLOWER_FOREST,Biomes.MEADOW),"flower"),
                new BiomeFeatureData("safflower", "safflower", List.of(Biomes.SWAMP,Biomes.MANGROVE_SWAMP,Biomes.RIVER,Biomes.BEACH,Biomes.SAVANNA,Biomes.SAVANNA_PLATEAU,Biomes.WINDSWEPT_SAVANNA,Biomes.DESERT,Biomes.BADLANDS,Biomes.WOODED_BADLANDS,Biomes.ERODED_BADLANDS),"flower"),
                new BiomeFeatureData("snow_lotus", "snow_lotus", List.of(Biomes.SNOWY_SLOPES,Biomes.SNOWY_TAIGA,Biomes.FROZEN_PEAKS),"flower"),
                new BiomeFeatureData("honeysuckle", "honeysuckle", List.of(Biomes.MEADOW,Biomes.SNOWY_SLOPES,Biomes.JAGGED_PEAKS,Biomes.STONY_PEAKS,Biomes.WINDSWEPT_HILLS,Biomes.WINDSWEPT_FOREST,Biomes.WINDSWEPT_GRAVELLY_HILLS),"flower"),

                new BiomeFeatureData("wild_tea","wild_tea",List.of(Biomes.PLAINS,Biomes.MEADOW),"flower"),
                new BiomeFeatureData("wild_mint","wild_mint",List.of(Biomes.SWAMP,Biomes.MANGROVE_SWAMP),"flower"),
                new BiomeFeatureData("wild_licorice","wild_licorice",List.of(Biomes.SAVANNA,Biomes.DESERT),"flower"),
                new BiomeFeatureData("wild_astragalus","wild_astragalus",List.of(Biomes.SNOWY_PLAINS),"flower"),
                new BiomeFeatureData("wild_verbena","wild_verbena",List.of(Biomes.WINDSWEPT_HILLS,Biomes.RIVER,Biomes.BEACH),"flower"),
                new BiomeFeatureData("wild_ginger","wild_ginger",List.of(Biomes.SAVANNA,Biomes.DESERT),"flower"),
                new BiomeFeatureData("wild_burdock","wild_burdock",List.of(Biomes.PLAINS,Biomes.MEADOW),"flower"),
                new BiomeFeatureData("wild_kudzu","wild_kudzu",List.of(Biomes.PLAINS,Biomes.MEADOW,Biomes.SAVANNA),"flower"),
                new BiomeFeatureData("wild_poria","wild_poria",List.of(Biomes.FOREST,Biomes.FLOWER_FOREST,Biomes.BIRCH_FOREST),"flower"),
                new BiomeFeatureData("wild_flax","wild_flax",List.of(Biomes.SAVANNA),"flower")
        );
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        for (BiomeFeatureData flower : flowers) {
            ResourceKey<BiomeModifier> key = ResourceKey.create(
                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(LushScentedParadise.MODID, flower.featureId + "_modifier")
            );
            HolderSet<Biome> biomeHolder = HolderSet.direct(flower.biomes.stream()
                            .map(biomes::getOrThrow).toList());
            HolderSet<PlacedFeature> featureHolder = HolderSet.direct(
                    placedFeatures.getOrThrow(ResourceKey.create(
                            Registries.PLACED_FEATURE,
                            new ResourceLocation(LushScentedParadise.MODID,flower.featureId))
                    ));
            if(flower.rule=="flower"){
            context.register(key, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomeHolder, featureHolder, GenerationStep.Decoration.VEGETAL_DECORATION)

                );
            }
            else if(flower.rule=="cave"){
                context.register(key, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomeHolder, featureHolder, GenerationStep.Decoration.UNDERGROUND_ORES)

                );
            }
        }
    }
    private static class FlowerFeatureData {
        String name;
        Block block;
        int tries;
        int xzSpread;
        int ySpread;
        String rule;

        FlowerFeatureData(String name, Block block, int tries, int xzSpread, int ySpread,String rule) {
            this.name = name;
            this.block = block;
            this.tries = tries;
            this.xzSpread = xzSpread;
            this.ySpread = ySpread;
            this.rule = rule;
        }
    }

    private static class BiomeFeatureData {
        String name;
        String featureId;
        List<ResourceKey<Biome>> biomes;
        String rule;

        BiomeFeatureData(String name, String featureId, List<ResourceKey<Biome>> biomes,String rule) {
            this.name = name;
            this.featureId = featureId;
            this.biomes = biomes;
            this.rule = rule;
        }
    }
}

