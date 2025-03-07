package net.royling.LushScentedParadise.Botania.BotaniaFood;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExpOrbSpawnerTask {
    private static final Map<UUID, Integer> activeTasks = new HashMap<>();
    public static void startExpOrbSpawning(ServerPlayer player, ServerLevel level){
        UUID playerID = player.getUUID();
        if(activeTasks.containsKey(playerID)){
            return;
        }
        activeTasks.put(playerID,300);
        MinecraftForge.EVENT_BUS.register(new Object(){
            @SubscribeEvent
            public void onServerTick(TickEvent.ServerTickEvent event){
                if(event.phase==TickEvent.Phase.END){
                    int remainingTicks = activeTasks.getOrDefault(playerID,0);
                    if(remainingTicks>0){
                        spawnExpOrb(level,player);
                        spawnExpOrb(level,player);
                        activeTasks.put(playerID,remainingTicks-1);
                    }else {
                        activeTasks.remove(playerID);
                        MinecraftForge.EVENT_BUS.unregister(this);
                    }
                }
            }
        });
    }
    private static void spawnExpOrb(ServerLevel level, Player player) {
        double x = player.getX() + (level.random.nextDouble() * 4 - 2);
        double y = player.getY() + (level.random.nextDouble() * 2);
        double z = player.getZ() + (level.random.nextDouble() * 4 - 2);
        ExperienceOrb orb = new ExperienceOrb(level, x, y, z, 1);
        level.addFreshEntity(orb);
    }
}
