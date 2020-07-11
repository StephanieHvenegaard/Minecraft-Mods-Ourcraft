package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class BaseSwordItem  extends ItemSword {
    public BaseSwordItem(String name, Item.ToolMaterial material) {
        super(material);
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
    }

}
