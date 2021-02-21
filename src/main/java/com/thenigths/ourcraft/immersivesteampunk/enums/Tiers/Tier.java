package com.thenigths.ourcraft.immersivesteampunk.enums.Tiers;

import com.thenigths.ourcraft.immersivesteampunk.Main;
import com.thenigths.ourcraft.immersivesteampunk.utils.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum Tier implements IArmorMaterial, IItemTier {
    OBSIDIAN("obsidian",25,ArmorTier.OBSIDIAN,ToolTier.OBSIDIAN,() -> Ingredient.fromItems((IItemProvider)RegistryHandler.OBSIDIAN_INGOT.get()));

    private final String name;
    private final Supplier<Ingredient> repairMaterial;
    private final int enchantability;
    private final ToolTier toolTier;
    private final ArmorTier armorTier;

    Tier(String name, int enchantability, ArmorTier armorTier, ToolTier toolTier, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.enchantability = enchantability;
        this.repairMaterial =repairMaterial;
        this.armorTier = armorTier;
        this.toolTier = toolTier;
    }
    public int getDurability(EquipmentSlotType slotIn) { return this.armorTier.getDurability(slotIn);}
    public int getDamageReductionAmount(EquipmentSlotType slotIn) { return this.armorTier.getDamageReductionAmount(slotIn); }
    public int getEnchantability() { return this.enchantability; }
    public SoundEvent getSoundEvent() { return  this.armorTier.getSoundEvent();}
    public Ingredient getRepairMaterial() { return this.repairMaterial.get();}
    @OnlyIn(Dist.CLIENT)
    public String getName() { return Main.MOD_ID+":"+this.name; }
    public String getTierName(){return this.name;}
    public float getToughness() { return this.armorTier.getToughness(); }
    public float getKnockbackResistance() { return this.armorTier.getKnockbackResistance(); }
    public int getMaxUses() { return this.toolTier.getMaxUses(); }
    public float getEfficiency() { return this.toolTier.getEfficiency(); }
    public float getAttackDamage() { return this.toolTier.getAttackDamage(); }
    public int getHarvestLevel() { return this.toolTier.getHarvestLevel(); }

}
