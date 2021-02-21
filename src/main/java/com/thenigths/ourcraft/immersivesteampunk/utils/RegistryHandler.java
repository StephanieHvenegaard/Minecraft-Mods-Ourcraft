package com.thenigths.ourcraft.immersivesteampunk.utils;

import com.thenigths.ourcraft.immersivesteampunk.Main;
import com.thenigths.ourcraft.immersivesteampunk.enums.Tiers.Tier;
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
    public static final RegistryObject<Item> OBSIDIAN_INGOT = createItem("obsidian_ingot");
    public static final RegistryObject<Item> OBSIDIAN_DUST = createItem("obsidian_dust");

    public static final RegistryObject<AxeItem> OBSIDIAN_AXE = createAxe(Tier.OBSIDIAN);
    public static final RegistryObject<PickaxeItem> OBSIDIAN_PICK = createPickAxe(Tier.OBSIDIAN);
    public static final RegistryObject<ShovelItem> OBSIDIAN_SHOWEL = createShowel(Tier.OBSIDIAN);
    public static final RegistryObject<HoeItem> OBSIDIAN_Hoe = createHoe(Tier.OBSIDIAN);

    public static final RegistryObject<ArmorItem> OBSIDIAN_HELMET = createArmorHelmet(Tier.OBSIDIAN);
    public static final RegistryObject<ArmorItem> OBSIDIAN_CHESTPLATE= createArmorChest(Tier.OBSIDIAN);
    public static final RegistryObject<ArmorItem> OBSIDIAN_LEGGINS = createArmorLeggings(Tier.OBSIDIAN);
    public static final RegistryObject<ArmorItem> OBSIDIAN_BOOTS = createArmorBoots(Tier.OBSIDIAN);

    private static RegistryObject<Item> createItem(String name){
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    }
    private static RegistryObject<AxeItem> createAxe(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_axe", () ->
                new AxeItem((IItemTier) itemTier, 8.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    }
    private static  RegistryObject<PickaxeItem> createPickAxe(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_pickaxe", () ->
                new PickaxeItem((IItemTier)itemTier, 4, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    }
    private static  RegistryObject<ShovelItem> createShowel(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_shovel", () ->
                new ShovelItem((IItemTier) itemTier, 6.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    }
    private static  RegistryObject<HoeItem> createHoe(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_hoe", () ->
                new HoeItem((IItemTier) itemTier, 0, 0.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    }
    private static  RegistryObject<SwordItem> createSword(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_sword", () ->
                new SwordItem( itemTier, 7, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<HorseArmorItem> createArmorHorse(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_horse_armor", () ->
                new HorseArmorItem(
                        itemTier.getDamageReductionAmount(EquipmentSlotType.CHEST)+5,
                        new ResourceLocation(Main.MOD_ID+":textures/entity/horse/armor/"+ itemTier.getTierName()+"_horse_armor.png"),
                        (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<ArmorItem> createArmorHelmet(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_helmet", () ->
                new ArmorItem( itemTier, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<ArmorItem> createArmorChest(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_chestplate", () ->
                new ArmorItem((IArmorMaterial) itemTier, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<ArmorItem> createArmorLeggings(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_leggings", () ->
                new ArmorItem((IArmorMaterial) itemTier, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<ArmorItem> createArmorBoots(Tier itemTier) {
        return ITEMS.register(itemTier.getTierName()+"_boots", () ->
                new ArmorItem((IArmorMaterial) itemTier, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)));
    }
    private static  RegistryObject<Item> createMusicDisc(Tier itemTier) {
        return null;
    }

//    public static final RegistryObject<MusicDiscItem> MUSIC_DISC_P_A_T = ITEMS.register("music_disc_peace_and_tranquility", ()-> {
//        return new MusicDiscItem();
//    });
//    public static final RegistryObject<Block> BLOCK_OF_RUBY = BLOCKS.register("ruby_block", com.pickleface.ruby.blocks.RubyBlock::new);
//    public static final RegistryObject<OreBlock> RUBY_ORE = BLOCKS.register("ruby_ore", com.pickleface.ruby.blocks.RubyOre::new);
//    public static final RegistryObject<Item> BLOCK_OF_RUBY_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase((Block)BLOCK_OF_RUBY.get()));
//    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase((Block)RUBY_ORE.get()));
//    public static final RegistryObject<SoundEvent> MUSIC_DISC_PEACE_AND_TRANQUILITY = SOUNDS.register("music_disc.peace_and_tranquility", () -> new SoundEvent(new ResourceLocation("ruby", "music_disc.peace_and_tranquility")));
//    public static final RegistryObject<ParticleType<BasicParticleType>> RUBY_SHINE = PARTICLES.register("ruby_shine", () -> new BasicParticleType(false));
}
