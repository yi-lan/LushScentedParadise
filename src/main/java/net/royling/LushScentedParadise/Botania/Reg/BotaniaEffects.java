package net.royling.LushScentedParadise.Botania.Reg;


import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.Botania.BotaniaEffect.NatureResonanceEffect;
import net.royling.LushScentedParadise.LushScentedParadise;

@Mod.EventBusSubscriber(modid = LushScentedParadise.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BotaniaEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LushScentedParadise.MODID);

    public static final RegistryObject<MobEffect> NATURE_RESONANCE =
            EFFECTS.register("nature_resonance", NatureResonanceEffect::new);

    public static void register() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
