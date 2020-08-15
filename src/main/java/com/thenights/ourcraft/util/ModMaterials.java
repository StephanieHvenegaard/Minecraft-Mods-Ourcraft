package com.thenights.ourcraft.util;

import com.thenights.ourcraft.Ourcraft;
import com.thenights.ourcraft.init.ModItems;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
    public static final ItemArmor.ArmorMaterial OBSIDIAN_ARMOR = EnumHelper.addArmorMaterial( "obsidian", Ourcraft.RESOURCE_PREFIX+"obsidian", 33, new int[] { 4, 4, 4, 4 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0F).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
    public static final ItemArmor.ArmorMaterial TEMPERED_COPPER_ARMOR = EnumHelper.addArmorMaterial( "tempered_copper", Ourcraft.RESOURCE_PREFIX+"tempered_copper", 33, new int[] { 4, 4, 4, 4 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0F).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
    public static final ItemArmor.ArmorMaterial COPPER_ARMOR = EnumHelper.addArmorMaterial( "copper", Ourcraft.RESOURCE_PREFIX+"copper", 33, new int[] { 4, 4, 4, 4 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0F).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
    public static final Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("obsidian", 3, 1861, 8.0F, 3.0F, 3).setRepairItem(new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM));
}
