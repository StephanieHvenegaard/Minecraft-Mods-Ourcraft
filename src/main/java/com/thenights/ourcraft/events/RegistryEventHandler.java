package com.thenights.ourcraft.events;

import com.thenights.ourcraft.Ourcraft;
import com.thenights.ourcraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = Ourcraft.MODID)
public class RegistryEventHandler {
    @SubscribeEvent
    public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
        //for (Block block : ModBlocks.BLOCKS)
        //    event.getRegistry().register((IForgeRegistryEntry)block);
    }

    @SubscribeEvent
    public static void RegisterItems(RegistryEvent.Register<Item> event) {
        for (Item item : ModItems.ITEMS) {
            event.getRegistry().register(item);
        }
        //for (Block block : ModBlocks.BLOCKS)
        //    event.getRegistry().register((new ItemBlock(block)).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void RegisterModels(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        //for (Block block : ModBlocks.BLOCKS) {
        //    Item item = Item.func_150898_a(block);
        //    ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        //}
    }
}
