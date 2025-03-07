package net.royling.LushScentedParadise.Item.coffee;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Item.Flowertea.ModFoods;
import net.royling.LushScentedParadise.Item.Flowertea.tea;
import net.royling.LushScentedParadise.LushScentedParadise;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModCoffee {
    public static final FoodProperties ESPRESSO_P = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0f)
            .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1800,0),1.0F)
            .effect(()->new MobEffectInstance(MobEffects.DIG_SPEED,1800,0),1F)
            .effect(()->new MobEffectInstance(MobEffects.HUNGER,400,0),1)
            .alwaysEat().build();
    public static final FoodProperties TRIESPRESSO_P = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0f)
            .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,4800,1),1.0F)
            .effect(()->new MobEffectInstance(MobEffects.DIG_SPEED,4800,1),1F)
            .effect(()->new MobEffectInstance(MobEffects.HUNGER,1200,1),1F)
            .alwaysEat().build();
    public static final FoodProperties AMERICANO_P = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F)
            .effect(()->new MobEffectInstance(MobEffects.DIG_SPEED,1200,0),1F)
            .effect(()->new MobEffectInstance(MobEffects.HUNGER,200,0),1)
            .alwaysEat().build();

    public static final FoodProperties LATTE_P = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties CAPPUCCINO_P = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties MOCHA_P = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0),1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties CARAMEL_MACCHIATO_P = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties ICED_AMERICANO_P = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties COLD_BREW_P = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
            .effect(()-> new MobEffectInstance(MobEffects.NIGHT_VISION,3600,0),1F)
            .alwaysEat().build();

    public static final FoodProperties JASMINE_COFFEE_P = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), 1.0F) // 50 秒回血
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0), 1.0F) // 2 分钟夜视
            .alwaysEat().build();

    public static final DeferredRegister<Item> COFFEES =
            DeferredRegister.create(ForgeRegistries.ITEMS, LushScentedParadise.MODID);

    public static final RegistryObject<Item> ESPRESSO = COFFEES.register("espresso", ()->new tea(new Item.Properties().food(ModCoffee.ESPRESSO_P).stacksTo(16),25)
    {
        @Override
        public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.espresso.text1").setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    });
    public static final RegistryObject<Item> TRIESPRESSO = COFFEES.register("triespresso", ()->new tea(new Item.Properties().food(ModCoffee.TRIESPRESSO_P).stacksTo(16),25)
    {
        @Override
        public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.triespresso.text1").setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    });
    public static final RegistryObject<Item> AMERICANO = COFFEES.register("americano",
            () -> new tea(new Item.Properties().food(ModCoffee.AMERICANO_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.americano.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> LATTE = COFFEES.register("latte",
            () -> new tea(new Item.Properties().food(ModCoffee.LATTE_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.latte.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> CAPPUCCINO = COFFEES.register("cappuccino",
            () -> new tea(new Item.Properties().food(ModCoffee.CAPPUCCINO_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.cappuccino.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> MOCHA = COFFEES.register("mocha",
            () -> new tea(new Item.Properties().food(ModCoffee.MOCHA_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.mocha.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> CARAMEL_MACCHIATO = COFFEES.register("caramel_macchiato",
            () -> new tea(new Item.Properties().food(ModCoffee.CARAMEL_MACCHIATO_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.caramel_macchiato.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> ICED_AMERICANO = COFFEES.register("iced_americano",
            () -> new tea(new Item.Properties().food(ModCoffee.ICED_AMERICANO_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.iced_americano.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> COLD_BREW = COFFEES.register("cold_brew",
            () -> new tea(new Item.Properties().food(ModCoffee.COLD_BREW_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.cold_brew.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    public static final RegistryObject<Item> JASMINE_COFFEE = COFFEES.register("jasmine_coffee",
            () -> new tea(new Item.Properties().food(ModCoffee.JASMINE_COFFEE_P).stacksTo(16), 25) {
                @Override
                public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel,
                                            @NotNull List<Component> pTooltipComponents,
                                            @NotNull TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.lushscentedparadise.jasmine_coffee.text1")
                            .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });
}
