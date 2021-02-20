package com.thenigths.ourcraft.immersivesteampunk.Tiers;

import com.thenigths.ourcraft.immersivesteampunk.utils.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolTiers implements IItemTier {
    RUBY(3, 9747, 10.0F, 0.0F, 15, RegistryHandler.RUBY.get());

    private final Item repairMaterial;
    private final int enchantability;
    private final float attackDamage;
    private final float efficiency;
    private final int maxUses;
    private final int harvestLevel;

    ToolTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Item repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }
    public int getMaxUses() { return this.maxUses; }
    public float getEfficiency() { return this.efficiency; }
    public float getAttackDamage() { return this.attackDamage; }
    public int getHarvestLevel() { return this.harvestLevel; }
    public int getEnchantability() { return this.enchantability; }
    public Ingredient getRepairMaterial() { return Ingredient.fromItems(this.repairMaterial); }
}
