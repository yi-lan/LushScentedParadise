package net.royling.LushScentedParadise.dataGen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;
import net.royling.LushScentedParadise.Registry.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TEAPOT.get());
        this.dropSelf(ModBlocks.FLOWER_TABLE.get());
        this.dropSelf(ModBlocks.DRYING_RACK.get());

        this.dropSelf(ModFlowers.SORT_SILENT_ORCHID_ABYSS.get());
        this.dropSelf(ModFlowers.TALL_SILENT_ORCHID_ABYSS.get());

        this.dropSelf(ModFlowers.VIOLET.get());
        this.dropSelf(ModFlowers.HIBISCUS.get());
        this.dropSelf(ModFlowers.PEONY.get());
        this.dropSelf(ModFlowers.JASMINE.get());
        this.dropSelf(ModFlowers.LAVENDER.get());
        this.dropSelf(ModFlowers.LILY.get());
        this.dropSelf(ModFlowers.SAFFLOWER.get());
        this.dropSelf(ModFlowers.SNOW_LOTUS.get());
        this.dropSelf(ModFlowers.MARIGOLD.get());
        this.dropSelf(ModFlowers.OENOTHERA_LINDHEIMERI.get());
        this.dropSelf(ModFlowers.PERILLA.get());
        this.dropSelf(ModFlowers.HONEYSUCKLE.get());

        this.dropSelf(ModFlowers.POTTED_VIOLET.get());
        this.dropSelf(ModFlowers.POTTED_HIBISCUS.get());
        this.dropSelf(ModFlowers.POTTED_PEONY.get());
        this.dropSelf(ModFlowers.POTTED_JASMINE.get());
        this.dropSelf(ModFlowers.POTTED_LAVENDER.get());
        this.dropSelf(ModFlowers.POTTED_LILY.get());
        this.dropSelf(ModFlowers.POTTED_SAFFLOWER.get());
        this.dropSelf(ModFlowers.POTTED_SNOW_LOTUS.get());
        this.dropSelf(ModFlowers.POTTED_MARIGOLD.get());
        this.dropSelf(ModFlowers.POTTED_OENOTHERA_LINDHEIMERI.get());
        this.dropSelf(ModFlowers.POTTED_PERILLA.get());
        this.dropSelf(ModFlowers.POTTED_HONEYSUCKLE.get());
        dropWildCrops(ModFlowers.WILD_TEA.get(),ModFlowers.GREEN_TEA_SEED.get(),30,ModFlowers.BLACK_TEA_SEED.get(),25,ModFlowers.WHITE_TEA_SEED.get(),20,ModFlowers.PUER_TEA_SEED.get(),10,ModFlowers.OOLONG_TEA_SEED.get(),8);
        dropWildCrop(ModFlowers.WILD_MINT.get(),ModFlowers.MINT_SEED.get());
        dropWildCrop(ModFlowers.WILD_LICORICE.get(), ModFlowers.LICORICE_SEED.get());
        dropWildCrop(ModFlowers.WILD_ASTRAGALUS.get(), ModFlowers.ASTRAGALUS_SEED.get());
        dropWildCrop(ModFlowers.WILD_VERBENA.get(), ModFlowers.VERBENA_SEED.get());
        dropWildCrop(ModFlowers.WILD_GINGER.get(), ModFlowers.GINGER_ITEM.get());
        dropWildCrop(ModFlowers.WILD_BURDOCK.get(), ModFlowers.BURDOCK_ITEM.get());
        dropWildCrop(ModFlowers.WILD_KUDZU.get(), ModFlowers.KUDZU_ITEM.get());
        dropWildCrop(ModFlowers.WILD_PORIA.get(), ModFlowers.PORIA_ITEM.get());
        dropWildCrop(ModFlowers.WILD_FLAX.get(), ModFlowers.FLAX_ITEM.get());




        LootItemCondition.Builder greentea$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.GREEN_TEA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.GREEN_TEA.get(),newCreateCropDrops(ModFlowers.GREEN_TEA.get(),ModFlowers.GREEN_TEA_LEAVE.get(),
                ModFlowers.GREEN_TEA_SEED.get(),greentea$builder));

        LootItemCondition.Builder blacktea$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.BLACK_TEA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.BLACK_TEA.get(), newCreateCropDrops(ModFlowers.BLACK_TEA.get(), ModFlowers.BLACK_TEA_LEAVE.get(),
                ModFlowers.BLACK_TEA_SEED.get(), blacktea$builder));

        LootItemCondition.Builder ginger$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.GINGER.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.GINGER.get(), createCropDrops(ModFlowers.GINGER.get(), ModFlowers.GINGER_ITEM.get(),
                ModFlowers.GINGER_ITEM.get(), ginger$builder));

        LootItemCondition.Builder whitetea$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.WHITE_TEA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.WHITE_TEA.get(), newCreateCropDrops(ModFlowers.WHITE_TEA.get(), ModFlowers.WHITE_TEA_LEAVE.get(),
                ModFlowers.WHITE_TEA_SEED.get(), whitetea$builder));

        LootItemCondition.Builder oolongtea$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.OOLONG_TEA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.OOLONG_TEA.get(), newCreateCropDrops(ModFlowers.OOLONG_TEA.get(), ModFlowers.OOLONG_TEA_LEAVE.get(),
                ModFlowers.OOLONG_TEA_SEED.get(), oolongtea$builder));

        LootItemCondition.Builder puertea$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.PUER_TEA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.PUER_TEA.get(), newCreateCropDrops(ModFlowers.PUER_TEA.get(), ModFlowers.PUER_TEA_LEAVE.get(),
                ModFlowers.PUER_TEA_SEED.get(), puertea$builder));

        LootItemCondition.Builder mint$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.MINT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.MINT.get(), newCreateCropDrops(ModFlowers.MINT.get(), ModFlowers.MINT_LEAVE.get(),
                ModFlowers.MINT_SEED.get(), mint$builder));

        LootItemCondition.Builder licorice$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.LICORICE.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.LICORICE.get(), createCropDrops(ModFlowers.LICORICE.get(), ModFlowers.LICORICE_ROOT.get(),
                ModFlowers.LICORICE_SEED.get(), licorice$builder));

        LootItemCondition.Builder astragalus$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.ASTRAGALUS.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.ASTRAGALUS.get(), createCropDrops(ModFlowers.ASTRAGALUS.get(), ModFlowers.ASTRAGALUS_ROOT.get(),
                ModFlowers.ASTRAGALUS_SEED.get(), astragalus$builder));

        LootItemCondition.Builder verbena$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.VERBENA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.VERBENA.get(), createCropDrops(ModFlowers.VERBENA.get(), ModFlowers.VERBENA_ITEM.get(),
                ModFlowers.VERBENA_SEED.get(), verbena$builder));

        LootItemCondition.Builder burdock$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.BURDOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.BURDOCK.get(), createCropDrops(ModFlowers.BURDOCK.get(), ModFlowers.BURDOCK_ITEM.get(),
                ModFlowers.BURDOCK_ITEM.get(), burdock$builder));

        LootItemCondition.Builder kudzu$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.KUDZU.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.KUDZU.get(), createCropDrops(ModFlowers.KUDZU.get(), ModFlowers.KUDZU_ITEM.get(),
                ModFlowers.KUDZU_ITEM.get(), kudzu$builder));

        LootItemCondition.Builder poria$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.PORIA.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.PORIA.get(), createCropDrops(ModFlowers.PORIA.get(), ModFlowers.PORIA_ITEM.get(),
                ModFlowers.PORIA_ITEM.get(), poria$builder));

        LootItemCondition.Builder flax$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModFlowers.FLAX.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE,7));

        this.add(ModFlowers.FLAX.get(), createCropDrops(ModFlowers.FLAX.get(), ModFlowers.FLAX_ITEM.get(),
                ModFlowers.FLAX_ITEM.get(), flax$builder));
    }
    @Override
    protected @NotNull Iterable<Block> getKnownBlocks(){
        return Stream.concat(ModBlocks.BLOCKS.getEntries().stream(),ModFlowers.FLOWERS.getEntries().stream())
                .map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder newCreateCropDrops(Block pCropBlock, Item pGrowenCropItem,Item pSeedItem,LootItemCondition.Builder pDropGrowenCropCondition){
        LootPool.Builder cropDropPool = LootPool.lootPool()
                .add(LootItem.lootTableItem(pGrowenCropItem).when(pDropGrowenCropCondition)
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE,0.5714286F,3))
                        //.apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)))
                        .otherwise(LootItem.lootTableItem(pSeedItem)));

        LootPool.Builder seedDropPool = LootPool.lootPool()
                .add(LootItem.lootTableItem(pSeedItem).when(pDropGrowenCropCondition)
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE,0.5714286f,3)));
        return this.applyExplosionDecay(pCropBlock,LootTable.lootTable().withPool(cropDropPool).withPool(seedDropPool));
    }

    protected void dropWildCrop(Block block,Item seed){
        add(block,LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(seed))));
    }
    protected void dropWildCrops(Block block,Object... drops){
        LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1));
        for(int i =0;i<drops.length;i+=2){
            if(drops[i]instanceof Item item&&drops[i+1]instanceof Integer weight){
                pool.add(LootItem.lootTableItem(item).setWeight(weight));
            }
        }
        add(block,LootTable.lootTable().withPool(pool));
    }
}
