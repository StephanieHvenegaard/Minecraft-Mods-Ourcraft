/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenights.ourcraft.armory.item.material;

import com.thenights.ourcraft.armory.item.ArmoryItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

/**
 *
 * @author Stephanie
 */
public enum ArmoryRangedMaterial implements IItemTier {

    FLINTLOCK_MUSKET(20, 1, 5.0f, 2.3f, 80,5,  30,false, ArmoryItems.musketBarrelAssembly),
    FLINTLOCK_BLUNDERBUSS(20, 1, 2.0f, 15.0f,5, 80, 30,false, ArmoryItems.blunderBarrelAssembly),
    FLINTLOCK_PISTOL(10, 1, 1.5f, 3.0f, 80,5, 30,true, Items.IRON_INGOT);

    ArmoryRangedMaterial(float damage, int magazinCapasity, float projectileVelocity, float spread, int durability, int enchantability, int reloadtime, boolean duelWield, Item item) {

        this.magazinCapasity = magazinCapasity;
        this.durability = durability;
        this.reloadTime = reloadtime;
        this.projectileVelocity = projectileVelocity;
        this.spread = spread;
        this.oneHanded = duelWield;
        this.enchantability = enchantability;
        this.Damage = damage;
        this.repItem = item;
    }
    public final int durability, magazinCapasity;
    public final float projectileVelocity, spread, Damage;
    public final boolean oneHanded;
    private final int enchantability, reloadTime;
    private final Item repItem;

    @Override
    public int getMaxUses() {
        return durability;
    }
    @Override
    public float getEfficiency() {
        return 0;
    }
    @Override
    public float getAttackDamage() {
        return Damage;
    }
    @Override
    public int getHarvestLevel() {
        return 0;
    }
    @Override
    public int getEnchantability() {
        return enchantability;
    }
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repItem);
    }
    public int getSpeed() {
        return reloadTime;
    }
}
