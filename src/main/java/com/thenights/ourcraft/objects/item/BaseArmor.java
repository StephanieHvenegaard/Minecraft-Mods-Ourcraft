package com.thenights.ourcraft.objects.item;

import com.thenights.ourcraft.Ourcraft;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import static com.thenights.ourcraft.init.ModItems.ITEMS;

public class BaseArmor  extends ItemArmor
{
    public BaseArmor(String name, ItemArmor.ArmorMaterial material, int renderIndex,EntityEquipmentSlot equipmentSlot) {
        super(material, renderIndex, equipmentSlot);
        setCreativeTab(Ourcraft.CORE_TAB);
        setRegistryName(Ourcraft.RESOURCE_PREFIX + name);
        setUnlocalizedName(this.getRegistryName().toString());
        ITEMS.add(this);
    }

    public boolean isRepairable() { return true; }
}
