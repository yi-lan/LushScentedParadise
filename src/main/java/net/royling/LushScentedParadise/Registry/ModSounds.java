package net.royling.LushScentedParadise.Registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.royling.LushScentedParadise.LushScentedParadise;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS=
            DeferredRegister.create(Registries.SOUND_EVENT, LushScentedParadise.MODID);
    public static final RegistryObject<SoundEvent> MUSIC_DISC =
            SOUND_EVENTS.register("lush_scented_paradise",
                    ()->SoundEvent.createVariableRangeEvent(new ResourceLocation(LushScentedParadise.MODID,"lush_scented_paradise")));
    public void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
