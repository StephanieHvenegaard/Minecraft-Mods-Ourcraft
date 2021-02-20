package com.thenigths.ourcraft.immersivesteampunk.utils;

import com.thenigths.ourcraft.immersivesteampunk.Main;
import com.thenigths.ourcraft.immersivesteampunk.Tiers.ArmorTiers;
import com.thenigths.ourcraft.immersivesteampunk.Tiers.ToolTiers;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Main.MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SOUNDS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }


    public static final RegistryObject<Item> RUBY = ITEMS.register("dense_obsidian_dust", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

//    public static final RegistryObject<MusicDiscItem> MUSIC_DISC_P_A_T = ITEMS.register("music_disc_peace_and_tranquility", ()-> {
//        return new MusicDiscItem();
//    });


    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem((IItemTier) ToolTiers.RUBY, 7, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem((IItemTier) ToolTiers.RUBY, 8.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem((IItemTier) ToolTiers.RUBY, 4, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem((IItemTier) ToolTiers.RUBY, 6.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () ->
            new HoeItem((IItemTier) ToolTiers.RUBY, 0, 0.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));


    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
            new ArmorItem((IArmorMaterial) ArmorTiers.RUBY, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () ->
            new ArmorItem((IArmorMaterial) ArmorTiers.RUBY, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () ->
            new ArmorItem((IArmorMaterial) ArmorTiers.RUBY, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () ->
            new ArmorItem((IArmorMaterial) ArmorTiers.RUBY, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<HorseArmorItem> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor", () ->
            new HorseArmorItem(15, new ResourceLocation("ruby:textures/entity/horse/armor/horse_armor_ruby.png"), (new Item.Properties()).group(ItemGroup.COMBAT)));
//
//
//    public static final RegistryObject<Block> BLOCK_OF_RUBY = BLOCKS.register("ruby_block", com.pickleface.ruby.blocks.RubyBlock::new);
//    public static final RegistryObject<OreBlock> RUBY_ORE = BLOCKS.register("ruby_ore", com.pickleface.ruby.blocks.RubyOre::new);
//
//
//    public static final RegistryObject<Item> BLOCK_OF_RUBY_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase((Block)BLOCK_OF_RUBY.get()));
//    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase((Block)RUBY_ORE.get()));
//
//
//    public static final RegistryObject<SoundEvent> MUSIC_DISC_PEACE_AND_TRANQUILITY = SOUNDS.register("music_disc.peace_and_tranquility", () -> new SoundEvent(new ResourceLocation("ruby", "music_disc.peace_and_tranquility")));
//
//
//    public static final RegistryObject<ParticleType<BasicParticleType>> RUBY_SHINE = PARTICLES.register("ruby_shine", () -> new BasicParticleType(false));
}
