package com.thenights.ourcraft.init;

import com.thenights.ourcraft.Ourcraft;
import com.thenights.ourcraft.objects.item.*;
import com.thenights.ourcraft.util.ModMaterials;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;

public class ModItems {
    public static Item OBSIDIAN_INGOT_ITEM;
    public static Item OBSIDIAN_SWORD_ITEM;
    public static Item OBSIDIAN_SHOVEL_ITEM;
    public static Item OBSIDIAN_PICKAXE_ITEM;
    public static Item OBSIDIAN_AXE_ITEM;
    public static Item OBSIDIAN_HOE_ITEM;
    public static ArrayList<Item> ITEMS = new ArrayList<>();

    public static void PreInit() {
        OBSIDIAN_INGOT_ITEM =  new BaseItem("ingot_obsidian");
        OBSIDIAN_PICKAXE_ITEM = new BasePickaxeItem("pickaxe_obsidian", ModMaterials.OBSIDIAN);
        OBSIDIAN_SHOVEL_ITEM = new BaseShovelItem("shovel_obsidian",ModMaterials.OBSIDIAN);
        OBSIDIAN_AXE_ITEM = new BaseAxeItem("axe_obsidian", ModMaterials.OBSIDIAN);
        OBSIDIAN_HOE_ITEM = new BaseHoeItem("hoe_obsidian",ModMaterials.OBSIDIAN);
        OBSIDIAN_SWORD_ITEM = new BaseSwordItem("sword_obsidian",ModMaterials.OBSIDIAN);
    }

    public static void Init() {
        GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(OBSIDIAN_INGOT_ITEM), 3.0F);
        //GameRegistry.addSmelting((Block)ModBlocks.vulcaniteOre, new ItemStack(vulcaniteNuggetItem), 1.0F);

        OreDictionary.registerOre("ingotObsidian", OBSIDIAN_INGOT_ITEM);
    }
}