package com.thenigths.ourcraft.immersivesteampunk.enums.Tiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorTier{
    RUBY( 33, new int[] { 3, 6, 8, 3 }, 25, 1.5F,SoundEvents.ITEM_ARMOR_EQUIP_GENERIC);

    private final float knockbackResistance;
    private final float toughness;
    private final SoundEvent soundEvent;
    private final int[] damageReductionAmountArray;
    private final int maxDamageFactor;
    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };

    ArmorTier(int maxDamageFactor, int[] damageReductionAmountArray, float toughness, float knockbackResistance, SoundEvent soundEvent) {
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.soundEvent = soundEvent;
    }
    public int getDurability(EquipmentSlotType slotIn) { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) { return this.damageReductionAmountArray[slotIn.getIndex()]; }

    public SoundEvent getSoundEvent() { return  this.soundEvent;}

    public float getToughness() { return this.toughness; }

    public float getKnockbackResistance() { return this.knockbackResistance; }
}
