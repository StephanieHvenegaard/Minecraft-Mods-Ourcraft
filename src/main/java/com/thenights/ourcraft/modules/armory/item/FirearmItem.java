package com.thenights.ourcraft.armory.item;

import com.google.common.collect.Lists;
import com.thenights.ourcraft.armory.OurcraftArmory;
import com.thenights.ourcraft.armory.item.material.ArmoryRangedMaterial;
import com.thenights.ourcraft.armory.item.material.ArmoryToolMaterial;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class FirearmItem extends ShootableItem {

    protected ArmoryRangedMaterial MATERIAL;
    public static final String NBT_CHARGED = "Charged";
    public static final String NBT_PROJECTILE = "Projectile";


    public static final Predicate<ItemStack> AMMUNITION_MUSKET = stack -> stack.getItem().isIn(ItemTags.getCollection().get(new ResourceLocation(OurcraftArmory.MODID, "flintlock_ammo")));
    public static final Predicate<ItemStack> AMMUNITION_BLUNDERBUSS  = stack -> stack.getItem().isIn(ItemTags.getCollection().get(new ResourceLocation(OurcraftArmory.MODID, "blunderbuss_ammo")));
    public static final Predicate<ItemStack> AMMUNITION_RIFLESHELLS  = stack -> stack.getItem().isIn(ItemTags.getCollection().get(new ResourceLocation(OurcraftArmory.MODID, "blunderbuss_ammo")));
    public static final Predicate<ItemStack> AMMUNITION_PISTOLSHELLS  = stack -> stack.getItem().isIn(ItemTags.getCollection().get(new ResourceLocation(OurcraftArmory.MODID, "blunderbuss_ammo")));
    public static final Predicate<ItemStack> AMMUNITION_SHOOTGUNSHEELS  = stack -> stack.getItem().isIn(ItemTags.getCollection().get(new ResourceLocation(OurcraftArmory.MODID, "blunderbuss_ammo")));

    public FirearmItem(String unlocName, ItemGroup group, ArmoryRangedMaterial material ) {
        super((new Item.Properties()).group(group).maxStackSize(1).maxDamage((int) (material.getMaxUses())));
        setRegistryName(OurcraftArmory.MODID, unlocName);
        MATERIAL = material;
        //AddPropertyOverides();
    }
//    private void AddPropertyOverides() {
//        this.addPropertyOverride(new ResourceLocation("pull"), (p_220022_1_, p_220022_2_, p_220022_3_) -> {
//            if (p_220022_3_ != null && p_220022_1_.getItem() == this) {
//                return isCharged(p_220022_1_) ? 0.0F : (float) (p_220022_1_.getUseDuration() - p_220022_3_.getItemInUseCount()) / (float) getChargeTime(p_220022_1_);
//            } else {
//                return 0.0F;
//            }
//        });
//        this.addPropertyOverride(new ResourceLocation("pulling"), (p_220033_0_, p_220033_1_, p_220033_2_) -> {
//            return p_220033_2_ != null && p_220033_2_.isHandActive() && p_220033_2_.getActiveItemStack() == p_220033_0_ && !isCharged(p_220033_0_) ? 1.0F : 0.0F;
//        });
//        this.addPropertyOverride(new ResourceLocation("charged"), (p_220030_0_, p_220030_1_, p_220030_2_) -> {
//            return p_220030_2_ != null && isCharged(p_220030_0_) ? 1.0F : 0.0F;
//        });
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        List<ItemStack> list = getChargedProjectiles(stack);
//        if (isCharged(stack) && !list.isEmpty()) {
//            ItemStack itemstack = list.get(0);
//            tooltip.add((new TranslationTextComponent("item.ourcraft.crossbow.projectile")).appendText(" ").appendSibling(itemstack.getTextComponent()));
//            if (flagIn.isAdvanced() && itemstack.getItem() == Items.FIREWORK_ROCKET) {
//                List<ITextComponent> list1 = Lists.newArrayList();
//                Items.FIREWORK_ROCKET.addInformation(itemstack, worldIn, list1, flagIn);
//                if (!list1.isEmpty()) {
//                    for(int i = 0; i < list1.size(); ++i) {
//                        list1.set(i, (new StringTextComponent("  ")).appendSibling(list1.get(i)).applyTextStyle(TextFormatting.GRAY));
//                    }
////        List<ITextComponent> list1 = Lists.newArrayList();
////        list1.add(new StringTextComponent(""));
////        list1.add(new StringTextComponent("When in hands:").applyTextStyle(TextFormatting.GRAY));
////        list1.add(new StringTextComponent(" " + specs.spread + "  Spread.").applyTextStyle(TextFormatting.DARK_GREEN));
////        list1.add(new StringTextComponent(" " + specs.magazinCapasity + "  Magazin Capasity").applyTextStyle(TextFormatting.DARK_GREEN));
////        list1.add(new StringTextComponent(" " + this.getChargeTime(stack) + "  ReloadSpeed").applyTextStyle(TextFormatting.DARK_GREEN));
////        list1.add(new StringTextComponent(" " + specs.ammoType.projectilesPerBullet * specs.ammoType.dmg + "  Attack Damage").applyTextStyle(TextFormatting.DARK_GREEN));
////
//
//                    tooltip.addAll(list1);
//                }
//            }
//
//        }
//    }
//
    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return AMMUNITION_MUSKET;
    }
//    public int getUseDuration(ItemStack stack) {
//        return MATERIAL.getSpeed();
//    }
//    public UseAction getUseAction(ItemStack stack) {
//        return UseAction.CROSSBOW;
//    }
}




