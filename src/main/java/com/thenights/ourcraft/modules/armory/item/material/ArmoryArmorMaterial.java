///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thenights.ourcraft.armory.item.material;
//
//import com.thenights.ourcraft.armory.OurcraftArmory;
//import com.thenights.ourcraft.core.item.OurCraftCoreItems;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.IArmorMaterial;
//import net.minecraft.item.Item;
//import net.minecraft.item.Items;
//import net.minecraft.item.crafting.Ingredient;
//import net.minecraft.util.SoundEvent;
//import net.minecraft.util.SoundEvents;
//import org.lwjgl.system.CallbackI;
//
///**
// *
// * @author Stephanie
// */
//public enum ArmoryArmorMaterial implements IArmorMaterial {
//    POWERUP_SLIPPERS("powerup_slippers", SoundEvents.BLOCK_WOOD_BREAK ,4 , 0, 0, 0, 0, 1, 0.0f, Items.RABBIT_HIDE),
//    OBSIDIAN("obsidian",SoundEvents.ITEM_ARMOR_EQUIP_CHAIN , 45, 2, 6, 10, 9, 5, 2.0f, OurCraftCoreItems.obsidianIngotItem),
//    EMERALD("emerald", SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 9, 25, 2, 7, 5, 3, 0.0f, Items.EMERALD),
//    BONE("bone", SoundEvents.BLOCK_STONE_PLACE,  13, 18, 2, 5,3, 1, 0.0f, Items.BONE),
//    TURTLE("turtle", SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,25, 9, 2, 6, 5, 2 , 0.0F, Items.SCUTE),
//    BAMBOO("bamboo",SoundEvents.BLOCK_WOOD_BREAK, 6,11,2,3,3,2,0.0f, Items.BAMBOO),
//    LEAD("lead",SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2,20,2,3,3,2,0.0f, OurCraftCoreItems.leadIngotItem),
//    WOOD("wooden",  SoundEvents.BLOCK_WOOD_BREAK,4, 9, 1, 2,1, 1, 1.0f, null),
//    CLOTH("cloth_white",SoundEvents.BLOCK_WOOD_BREAK, 2,10,1,1,1,1,0.0f, Items.STRING);
//
//    private static final int[] MAX_DAMAGE = new int[]{13, 15, 16, 11};
//    private final String name;
//    private final SoundEvent soundEvent;
//    private final int durability;
//    private final int enchantability;
//    private final int[] dmgReduction;
//    private final float toughness;
//    private final Item repairItem;
//
//
//    private ArmoryArmorMaterial(String name,SoundEvent sound, int durability, int enchantability, int dmgRedux_head, int dmgRedux_chest, int dmgRedux_legs, int dmgRedux_feet, float toughness, Item repItem) {
//        this.name = name;
//        this.soundEvent = sound;
//        this.durability = durability;
//        this.enchantability = enchantability;
//        this.dmgReduction = new int[]{dmgRedux_feet,dmgRedux_legs, dmgRedux_chest, dmgRedux_head };
//        this.toughness = toughness;
//        this.repairItem = repItem;
//    }
//
//    @Override
//    public int getDurability(EquipmentSlotType slot) {
//        return MAX_DAMAGE[slot.getIndex()] * this.durability;
//    }
//
//    @Override
//    public int getDamageReductionAmount(EquipmentSlotType slot) {
//        return dmgReduction[slot.getIndex()];
//    }
//
//    @Override
//    public int getEnchantability() {
//        return this.enchantability;
//    }
//
//    @Override
//    public SoundEvent getSoundEvent() {
//        return soundEvent;
//    }
//
//    @Override
//    public Ingredient getRepairMaterial() {
//        return Ingredient.fromItems(this.repairItem);
//    }
//
//    @Override
//    public String getName() {
//        return OurcraftArmory.MODID + ":" + this.name;
//    }
//
//    @Override
//    public float getToughness() {
//        return this.toughness;
//    }
//
//}
