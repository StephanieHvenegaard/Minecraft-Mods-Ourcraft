package com.thenights.ourcraft.util;

import com.thenights.ourcraft.Ourcraft;
import com.thenights.ourcraft.init.ModItems;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
    //	Vanilla durability.
    // Wood: 60 uses
    // Stone: 132 uses
    // Iron: 251 uses
    // Golden: 33 uses
    // Diamond: 1562 uses

    // enchanting
    // lether 15
    // Golden 25
    // Chain mail 12
    // Iron 9
    // turtle 9
    // Diamond 10

    // TOOLS
    // float dmg, float speed, float effiency, int durability, int harvestLVL, int enchantAbility, Item repItem
    // Obsidian(15.0f, 5.0f, 20.0f, 1562 * 10, 3, 18, ObsidianItems.ingot),
    // Emarald(10.0f, 3.0f, 15.0f, 1562 * 2, 3, 12, Items.EMERALD),
    // Diamond(5.0f, 1.0f, 1.0f, 1562, 3, 10, Items.DIAMOND),
    // Iron(4.0f, 1.0f, 1.0f, 251, 2, 9, Items.IRON_INGOT),
    // Golden(2.0f, 1.0f, 1.0f, 33, 1, 25, Items.GOLD_INGOT),
    // Bone(2.5f,1.0f,1.0f, 198, 1,18,Items.BONE ),
    // Stone(3.0f, 1.0f, 1.0f, 132, 1, 9, Items.COBBLESTONE),
    // Bamboo(2.2f,1.0f,1.0f,120,1,15,Items.BAMBOO),
    // Wood(2.0f, 1.0f, 1.0f, 60, 1, 15, null),;

    // ARMOR
    // String name, int durability, int enchantability, int dmgRedux_head, int dmgRedux_chest, int dmgRedux_legs, int dmgRedux_feet, float toughness, Item repItem
    // obsidian("obsidian",  200, 10, 10, 12, 9, 7, 3.0f, ObsidianItems.ingot),
    // Sapphire("sapphire",  200, 25, 10, 12, 9, 7, 3.0f, PinkSapphireItems.ingot),
    // blue_glass("blue_glass",  200, 25, 3, 7, 5, 3, 1.0f, BlueGlassItems.ingot),
    // bone("bone",  2, 18, 3, 3,3, 3, 2.0f, Items.BONE),
    // wood("wooden",  2, 2, 1, 1,1, 1, 1.0f, null),
    // bamboo("bamboo", 2,3,2,2,2,2,1.0f, Items.BAMBOO),
    // kelp("kelp", 1, 25,1, 1, 1, 1, 0.0f, Items.DRIED_KELP);


    public static final ItemArmor.ArmorMaterial OBSIDIAN_ARMOR = EnumHelper.addArmorMaterial( "obsidian", Ourcraft.RESOURCE_PREFIX+"obsidian", 330, new int[] { 8,10,12,7}, 3, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
    public static final Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("obsidian", 3, (int)(1562*3.5), 18.0F, 21.0F, 3).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
}
