package com.thenigths.ourcraft.immersivesteampunk.enums.Tiers;

public enum ToolTier {
    RUBY(3, 9747, 10.0F, 0.0F);

    private final float attackDamage;
    private final float efficiency;
    private final int maxUses;
    private final int harvestLevel;

    ToolTier(int harvestLevel, int maxUses, float efficiency, float attackDamage) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;

    }
    public int getMaxUses() { return this.maxUses; }
    public float getEfficiency() { return this.efficiency; }
    public float getAttackDamage() { return this.attackDamage; }
    public int getHarvestLevel() { return this.harvestLevel; }
}
