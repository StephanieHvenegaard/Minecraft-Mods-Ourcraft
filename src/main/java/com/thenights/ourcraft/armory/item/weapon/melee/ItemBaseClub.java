package com.thenights.ourcraft.armory.item.weapon.melee;

import com.thenights.ourcraft.armory.item.weapon.ItemBaseMeleeWeapon;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ItemBaseClub extends ItemBaseMeleeWeapon {
    public ItemBaseClub(IItemTier itemTier, Item.Properties props) {
        super(itemTier, -2, -3.6f, props);
    }
}
