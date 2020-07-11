package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.item.Item;

public class BaseItem extends Item
{
    public BaseItem(String name) {
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
    }
}