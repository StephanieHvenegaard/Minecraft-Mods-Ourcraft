package com.thenights.ourcraft.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CoreTab extends CreativeTabs {
    public CoreTab() {
        super("ourcraft_coretab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.ACACIA_BOAT);
    }
}