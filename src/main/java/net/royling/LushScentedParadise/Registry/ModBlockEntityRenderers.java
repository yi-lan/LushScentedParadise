package net.royling.LushScentedParadise.Registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.royling.LushScentedParadise.LushScentedParadise;
import net.royling.LushScentedParadise.ModBlock.DryingRack.DryingRackRender;


@Mod.EventBusSubscriber(modid = LushScentedParadise.MODID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)

public class ModBlockEntityRenderers {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.DRYING_RACK.get(), DryingRackRender::new);
    }
}
