package com.thenights.ourcraft.armory.events;


import com.thenights.ourcraft.armory.OurcraftArmory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OurcraftArmory.MODID)
public class LootTablesEvent {
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if (event.getName().equals(new ResourceLocation("minecraft","simple_dungeon"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(OurcraftArmory.MODID,"powerup_treasure"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","shipwreck_treasure"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(OurcraftArmory.MODID,"powerup_treasure"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","shipwreck_treasure"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(OurcraftArmory.MODID,"powerup_treasure"))).build());
        }
        if (event.getName().equals(new ResourceLocation("minecraft","shipwreck_treasure"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(OurcraftArmory.MODID,"powerup_treasure"))).build());
        }
    }
}
