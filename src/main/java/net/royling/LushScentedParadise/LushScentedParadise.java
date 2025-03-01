package net.royling.LushScentedParadise;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.royling.LushScentedParadise.Item.Flowertea.ModFoods;
import net.royling.LushScentedParadise.Item.StorageBagItem.StorageBagScreen;
import net.royling.LushScentedParadise.Registry.*;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotScreen;
import net.royling.LushScentedParadise.Item.newFlower.ModFlowers;
import net.royling.LushScentedParadise.villager.ModVillagers;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LushScentedParadise.MODID)
public class LushScentedParadise
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lushscentedparadise";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public LushScentedParadise()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModBlockEntities.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFlowers.register(modEventBus);
        ModItems.register(modEventBus);
        ModRecipeTypes.register(modEventBus);
        ModRecipeSerializers.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModFoods.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModEffects.register(modEventBus);
        //ModFlowers.register(modEventBus);
        // Register the commonSetup method for modloading

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()->{
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.VIOLET.getId(), ModFlowers.POTTED_VIOLET);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.HIBISCUS.getId(), ModFlowers.POTTED_HIBISCUS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.PEONY.getId(), ModFlowers.POTTED_PEONY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.JASMINE.getId(), ModFlowers.POTTED_JASMINE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.LAVENDER.getId(), ModFlowers.POTTED_LAVENDER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.LILY.getId(), ModFlowers.POTTED_LILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.SAFFLOWER.getId(), ModFlowers.POTTED_SAFFLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.SNOW_LOTUS.getId(), ModFlowers.POTTED_SNOW_LOTUS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.MARIGOLD.getId(), ModFlowers.POTTED_MARIGOLD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.OENOTHERA_LINDHEIMERI.getId(), ModFlowers.POTTED_OENOTHERA_LINDHEIMERI);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.PERILLA.getId(), ModFlowers.POTTED_PERILLA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModFlowers.HONEYSUCKLE.getId(), ModFlowers.POTTED_HONEYSUCKLE);

        });

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(()->{
                MenuScreens.register(ModMenuTypes.TEAPOT_MENU.get(), TeapotScreen::new);
                MenuScreens.register(ModMenuTypes.STORAGE_BAG_MENU.get(), StorageBagScreen::new);
            });
        }
    }
}
