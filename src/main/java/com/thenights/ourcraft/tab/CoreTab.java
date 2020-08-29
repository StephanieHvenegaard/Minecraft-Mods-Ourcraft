package com.thenights.ourcraft.tab;

import com.thenights.ourcraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CoreTab extends CreativeTabs {
    public CoreTab() {
        super("ourcraft_coretab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.OBSIDIAN_INGOT_ITEM);
    }
}