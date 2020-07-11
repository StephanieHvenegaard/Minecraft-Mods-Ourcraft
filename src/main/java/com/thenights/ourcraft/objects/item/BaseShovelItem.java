package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

import static com.thenights.ourcraft.init.ModItems.ITEMS;

public class BaseShovelItem   extends ItemSpade {
    public BaseShovelItem(String name, Item.ToolMaterial material) {
        super(material);
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
        ITEMS.add(this);
    }

}
