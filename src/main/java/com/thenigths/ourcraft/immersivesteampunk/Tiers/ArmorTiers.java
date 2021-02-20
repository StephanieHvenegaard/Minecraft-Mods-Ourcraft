package com.thenigths.ourcraft.immersivesteampunk.Tiers;
import com.thenigths.ourcraft.immersivesteampunk.utils.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ArmorTiers implements IArmorMaterial {
    RUBY("ruby:ruby", 33, new int[] { 3, 6, 8, 3 }, 25, 1.5F,RegistryHandler.RUBY.get(), 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC);
    static  {
        MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    }
    private final float knockbackResistance;
    private final Item repairMaterial;
    private final float toughness;
    private final SoundEvent soundEvent;
    private final int enchantability;
    private final int[] damageReductionAmountArray;
    private final int maxDamageFactor;
    private final String name;
    private static final int[] MAX_DAMAGE_ARRAY;

    ArmorTiers(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, float toughness, Item repairMaterial, float knockbackResistance, SoundEvent soundEvent) {
        this.name = name;
        this.maxDamageFactor = 33;
        this.damageReductionAmountArray = new int[] { 3, 6, 8, 3 };
        this.enchantability = 25;
        this.toughness = 1.5F;
        this.repairMaterial = RegistryHandler.RUBY.get();
        this.knockbackResistance = 0.0F;
        this.soundEvent = soundEvent;
    }
    public int getDurability(EquipmentSlotType slotIn) { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) { return this.damageReductionAmountArray[slotIn.getIndex()]; }

    public int getEnchantability() { return this.enchantability; }

    public SoundEvent getSoundEvent() { return  this.soundEvent;}

    public Ingredient getRepairMaterial() { return Ingredient.fromItems(repairMaterial);}

    @OnlyIn(Dist.CLIENT)
    public String getName() { return this.name; }

    public float getToughness() { return this.toughness; }

    public float getKnockbackResistance() { return this.knockbackResistance; }
}
