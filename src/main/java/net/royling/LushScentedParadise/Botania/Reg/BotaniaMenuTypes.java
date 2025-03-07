package net.royling.LushScentedParadise.Botania.Reg;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaTeapot.ManaTeapotMenu;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.TeapotBlock.TeapotMenu;

public class BotaniaMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, LushScentedParadise.MODID);

    public static final RegistryObject<MenuType<ManaTeapotMenu>> MANA_TEAPOT_MENU =
            MENUS.register("mana_teapot_menu",
                    () -> IForgeMenuType.create(ManaTeapotMenu::new));
}

