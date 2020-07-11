package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

import static com.thenights.ourcraft.init.ModItems.ITEMS;

public class BasePickaxeItem  extends ItemPickaxe {
    public BasePickaxeItem(String name, Item.ToolMaterial material) {
        super(material);
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
        ITEMS.add(this);
    }

}
