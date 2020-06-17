//package com.thenights.ourcraft.armory.events;
//
//
//import com.thenights.ourcraft.armory.OurcraftArmory;
//import com.thenights.ourcraft.armory.item.ArmoryItems;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.potion.Effects;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = OurcraftArmory.MODID)
//public class PowerUpsBunnyEvent
//{
//    @SubscribeEvent
//    public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) {
//        if (event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ArmoryItems.bunnyBoots) {
//            event.player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, 4, false,false, true));
//        }
//    }
//}
