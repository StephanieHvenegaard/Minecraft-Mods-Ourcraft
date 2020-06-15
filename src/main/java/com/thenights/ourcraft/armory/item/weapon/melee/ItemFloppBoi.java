package com.thenights.ourcraft.armory.item.weapon.melee;

import com.thenights.ourcraft.armory.item.material.ArmoryToolMaterial;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemFloppBoi extends SwordItem {
    public ItemFloppBoi(Item.Properties props) {
        super(ArmoryToolMaterial.Wood, -3, 2.4f, props);
    }

    //    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
//        super.onCreated(stack,worldIn,playerIn);
//    if(stack.isEnchanted() == false) {
//            stack.addEnchantment(, 2);
//        }
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        super.onLeftClickEntity(stack, player, entity);
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 4, false, true, false));
            // OurcraftCore.LOGGER.info("Casted the spell.");
        }
        return true;
    }

}

