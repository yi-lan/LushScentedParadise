package net.royling.LushScentedParadise.Botania;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.Reg.BotaniaBlocks;
import net.royling.LushScentedParadise.LushScentedParadise;

public class LSPBotaniaItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LushScentedParadise.MODID);

    public static final RegistryObject<Item> DRIED_RED_PETAL = ITEMS.register("dried_red_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_ORANGE_PETAL = ITEMS.register("dried_orange_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_YELLOW_PETAL = ITEMS.register("dried_yellow_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_GREEN_PETAL = ITEMS.register("dried_green_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_LIGHT_BLUE_PETAL = ITEMS.register("dried_light_blue_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_BLUE_PETAL = ITEMS.register("dried_blue_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_PURPLE_PETAL = ITEMS.register("dried_purple_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_MAGENTA_PETAL = ITEMS.register("dried_magenta_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_PINK_PETAL = ITEMS.register("dried_pink_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_BLACK_PETAL = ITEMS.register("dried_black_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_WHITE_PETAL = ITEMS.register("dried_white_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_GRAY_PETAL = ITEMS.register("dried_gray_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_LIGHT_GRAY_PETAL = ITEMS.register("dried_light_gray_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_CYAN_PETAL = ITEMS.register("dried_cyan_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_BROWN_PETAL = ITEMS.register("dried_brown_petal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_LIME_PETAL = ITEMS.register("dried_lime_petal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MANA_WATER = ITEMS.register("mana_water",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANA_TEAPOT = ITEMS.register("mana_teapot",
            ()->new BlockItem(BotaniaBlocks.MANA_TEAPOT.get(),new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
