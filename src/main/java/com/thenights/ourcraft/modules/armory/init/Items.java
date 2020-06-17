//package com.thenights.ourcraft.armory.init;
//
//import com.thenights.ourcraft.armory.OurcraftArmory;
//import com.thenights.ourcraft.armory.core.ArmoryGroup;
//import com.thenights.ourcraft.armory.item.ArmoryItems;
//import com.thenights.ourcraft.armory.item.FirearmItem;
//import com.thenights.ourcraft.armory.item.material.ArmoryArmorMaterial;
//import com.thenights.ourcraft.armory.item.material.ArmoryRangedMaterial;
//import com.thenights.ourcraft.armory.item.material.ArmoryToolMaterial;
//import com.thenights.ourcraft.armory.item.tool.ItemAxe;
//import com.thenights.ourcraft.armory.item.tool.ItemHoe;
//import com.thenights.ourcraft.armory.item.tool.ItemPickAxe;
//import com.thenights.ourcraft.armory.item.tool.ItemShovel;
//import com.thenights.ourcraft.armory.item.weapon.melee.ItemFloppBoi;
//import com.thenights.ourcraft.armory.item.weapon.melee.ItemKatana;
//import com.thenights.ourcraft.armory.item.weapon.melee.ItemSword;
//import net.minecraft.block.Block;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.Item;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//// Event bus for receiving Registry Events)
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//public class Items {
//
//    @SubscribeEvent
//    public static void registerItems(final RegistryEvent.Register<Item> event) {
//        // register a new item here
//        event.getRegistry().registerAll(
//                // -----------------------------
//                // Weapons
//                // Wood
//                ArmoryItems.WOOD_KATANA = new ItemKatana(ArmoryToolMaterial.Wood, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_katana")),
//                // Stone
//                ArmoryItems.stonekatana = new ItemKatana(ArmoryToolMaterial.Stone, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("stone_katana")),
//                // Bamboo
//                ArmoryItems.bamboosword = new ItemSword(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_sword")),
//                ArmoryItems.bambookatana = new ItemKatana(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_katana")),
//                // Bone
//                ArmoryItems.BONE_SWORD = new ItemSword(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_sword")),
//                ArmoryItems.BONE_KATANA = new ItemKatana(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_katana")),
//                // Iron
//                ArmoryItems.Ironkatana = new ItemKatana(ArmoryToolMaterial.Iron, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("iron_katana")),
//                // Gold
//                ArmoryItems.goldkatana = new ItemKatana(ArmoryToolMaterial.Golden, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("gold_katana")),
//                // Emerald
//                ArmoryItems.emeraldsword = new ItemSword(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emarald_sword")),
//                ArmoryItems.emeraldkatana = new ItemKatana(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emarald_katana")),
//                // Diamond
//                ArmoryItems.diamondkatana = new ItemKatana(ArmoryToolMaterial.Diamond, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("diamond_katana")),
//                // Obsidian
//                ArmoryItems.obsidiansword = new ItemSword(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_sword")),
//                ArmoryItems.obsidiankatana = new ItemKatana(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_katana")),
//
//                // -----------------------------
//                // ARMOR
//                // Cloth
//                ArmoryItems.clothwhiteboots = new ArmorItem(ArmoryArmorMaterial.CLOTH, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("cloth_white_boots")),
//                ArmoryItems.clothwhiteleggings = new ArmorItem(ArmoryArmorMaterial.CLOTH, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("cloth_white_leggings")),
//                ArmoryItems.clothwhitechestplate = new ArmorItem(ArmoryArmorMaterial.CLOTH, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("cloth_white_chest")),
//                ArmoryItems.clothwhitehelmet = new ArmorItem(ArmoryArmorMaterial.CLOTH, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("cloth_white_helmet")),
//                // Wood
//                ArmoryItems.WOOD_HELMET = new ArmorItem(ArmoryArmorMaterial.WOOD, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_helmet")),
//                ArmoryItems.WOOD_CHEST = new ArmorItem(ArmoryArmorMaterial.WOOD, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_chest")),
//                ArmoryItems.WOOD_LEGS = new ArmorItem(ArmoryArmorMaterial.WOOD, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_leggings")),
//                ArmoryItems.WOOD_BOOTS = new ArmorItem(ArmoryArmorMaterial.WOOD, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_boots")),
//                // Turtle
//                ArmoryItems.turtlechestplate = new ArmorItem(ArmoryArmorMaterial.TURTLE, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("turtle_chest")),
//                ArmoryItems.turtleleggings = new ArmorItem(ArmoryArmorMaterial.TURTLE, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("turtle_leggings")),
//                ArmoryItems.turtleboots = new ArmorItem(ArmoryArmorMaterial.TURTLE, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("turtle_boots")),
//                // Bamboo
//                ArmoryItems.bamboohelmet = new ArmorItem(ArmoryArmorMaterial.BAMBOO, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_helmet")),
//                ArmoryItems.bamboochestplate = new ArmorItem(ArmoryArmorMaterial.BAMBOO, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_chest")),
//                ArmoryItems.bambooleggings = new ArmorItem(ArmoryArmorMaterial.BAMBOO, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_leggings")),
//                ArmoryItems.bambooboots = new ArmorItem(ArmoryArmorMaterial.BAMBOO, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bamboo_boots")),
//                // Lead
//                ArmoryItems.leadhelmet = new ArmorItem(ArmoryArmorMaterial.LEAD, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("lead_helmet")),
//                ArmoryItems.leadchestplate = new ArmorItem(ArmoryArmorMaterial.LEAD, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("lead_chest")),
//                ArmoryItems.leadleggings = new ArmorItem(ArmoryArmorMaterial.LEAD, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("lead_leggings")),
//                ArmoryItems.leadboots = new ArmorItem(ArmoryArmorMaterial.LEAD, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("lead_boots")),
//                // Bone
//                ArmoryItems.BONE_HELMET = new ArmorItem(ArmoryArmorMaterial.BONE, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_helmet")),
//                ArmoryItems.BONE_CHEST = new ArmorItem(ArmoryArmorMaterial.BONE, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_chest")),
//                ArmoryItems.BONE_LEGS = new ArmorItem(ArmoryArmorMaterial.BONE, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_leggings")),
//                ArmoryItems.BONE_BOOTS = new ArmorItem(ArmoryArmorMaterial.BONE, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bone_boots")),
//                // Emerald
//                ArmoryItems.emeraldhelmet = new ArmorItem(ArmoryArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emerald_helmet")),
//                ArmoryItems.emeraldchestplate = new ArmorItem(ArmoryArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emerald_chest")),
//                ArmoryItems.emeraldleggings = new ArmorItem(ArmoryArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emerald_leggings")),
//                ArmoryItems.emeraldboots = new ArmorItem(ArmoryArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emerald_boots")),
//                // Obsidian
//                ArmoryItems.obsidianhelmet = new ArmorItem(ArmoryArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_helmet")),
//                ArmoryItems.obsidianchestplate = new ArmorItem(ArmoryArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_chest")),
//                ArmoryItems.obsidianleggings = new ArmorItem(ArmoryArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_leggings")),
//                ArmoryItems.obsidianboots = new ArmorItem(ArmoryArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_boots")),
//                // -----------------------------
//                //TOOLS
//                // Bamboo
//                ArmoryItems.bambooaxe = new ItemAxe(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bamboo_axe")),
//                ArmoryItems.bamboohoe = new ItemHoe(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bamboo_hoe")),
//                ArmoryItems.bamboospade = new ItemShovel(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bamboo_spade")),
//                ArmoryItems.bamboopickaxe = new ItemPickAxe(ArmoryToolMaterial.Bamboo, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bamboo_pickaxe")),
//                // Bone
//                ArmoryItems.BONE_AXE = new ItemAxe(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bone_axe")),
//                ArmoryItems.BONE_HOE = new ItemHoe(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bone_hoe")),
//                ArmoryItems.BONE_SHOVEL = new ItemShovel(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bone_spade")),
//                ArmoryItems.BONE_PICKAXE = new ItemPickAxe(ArmoryToolMaterial.Bone, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("bone_pickaxe")),
//                // Emerald
//                ArmoryItems.emeraldaxe = new ItemAxe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_axe")),
//                ArmoryItems.emeraldhoe = new ItemHoe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_hoe")),
//                ArmoryItems.emeraldspade = new ItemShovel(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_spade")),
//                ArmoryItems.emeraldpickaxe = new ItemPickAxe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_pickaxe")),
//                // Obsidian
//                ArmoryItems.obsidianaxe = new ItemAxe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_axe")),
//                ArmoryItems.obsidianhoe = new ItemHoe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_hoe")),
//                ArmoryItems.obsidianspade = new ItemShovel(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_spade")),
//                ArmoryItems.obsidianpickaxe = new ItemPickAxe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_pickaxe")),
//                // -----------------------------
//                //POWERUPS
//                ArmoryItems.bunnyBoots = new ArmorItem(ArmoryArmorMaterial.POWERUP_SLIPPERS, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("powerup_slippers")),
//                ArmoryItems.floppyBoi = new ItemFloppBoi(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("powerup_floppyboi")),
//                // -----------------------------
//                // FIREARMS
//                ArmoryItems.musket = new FirearmItem("flintlock_musket",ArmoryGroup.COMBAT, ArmoryRangedMaterial.FLINTLOCK_MUSKET),
//                // ArmoryItems.musket = new OLDItemBaseFireArm(ArmoryRangedMaterial.FLINTLOCK_MUSKET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_musket")),
//                // ArmoryItems.blunderbuss = new OLDItemBaseFireArm(ArmoryRangedMaterial.FLINTLOCK_BLUNDERBUSS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_blunderbuss")),
//                // ArmoryItems.pistol = new OLDItemBaseFireArm(ArmoryRangedMaterial.FLINTLOCK_PISTOL, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_pistol")),
//
//                // OurcraftArmoryItems.bullet = new ArrowItem(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("bullet")),
//
//                ArmoryItems.blunderAmmo = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blunderbuss_ammo")),
//                ArmoryItems.flintlockAmmo = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_ammo")),
//                ArmoryItems.blunderBarrelAssembly = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_blunderbuss_barrelassembly")),
//                ArmoryItems.musketBarrelAssembly = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_musket_barrelassembly")),
//                ArmoryItems.gunstock = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("gunstock"))
//        );
//    }
//
//    @SubscribeEvent
//    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//        // register a new block here
//        OurcraftArmory.LOGGER.info("HELLO from Register Block");
//    }
//
//    private static ResourceLocation getLocation(String name) {
//        return new ResourceLocation(OurcraftArmory.MODID, name);
//    }
//}
//
//
