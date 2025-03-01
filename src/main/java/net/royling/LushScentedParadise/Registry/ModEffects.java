package net.royling.LushScentedParadise.Registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.MobEffect.ColdResistanceEffect;
import net.royling.LushScentedParadise.MobEffect.SandWalkerEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LushScentedParadise.MODID);

    public static final RegistryObject<MobEffect> COLD_RESISTANCE = EFFECTS.register("cold_resistance",
            ()->new ColdResistanceEffect());
    public static final RegistryObject<MobEffect> SAND_WALKER = EFFECTS.register("sand_walker",
            ()->new SandWalkerEffect());

    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }
}
