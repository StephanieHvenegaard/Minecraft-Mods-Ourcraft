package com.thenights.ourcraft.armory.item.weapon.melee;

import com.thenights.ourcraft.armory.item.weapon.ItemBaseMeleeWeapon;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ItemBaseScythe extends ItemBaseMeleeWeapon {
    public ItemBaseScythe(IItemTier itemTier, Item.Properties props) {
        super(itemTier, -2, -3.6f, props);
    }
    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(BlockState blockIn) {
        return blockIn.getBlock() == Blocks.HAY_BLOCK;
    }
}