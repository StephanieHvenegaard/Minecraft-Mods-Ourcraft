package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

import static com.thenights.ourcraft.init.ModItems.ITEMS;

public class BaseAxeItem extends ItemAxe {
    public BaseAxeItem(String name, Item.ToolMaterial material) {
        super(material,7.0F, -3.2F);
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
        ITEMS.add(this);
    }
}
