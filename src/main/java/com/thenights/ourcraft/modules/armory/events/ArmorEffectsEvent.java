package com.thenights.ourcraft.armory.events;

import com.thenights.ourcraft.armory.OurcraftArmory;
import com.thenights.ourcraft.armory.item.ArmoryItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OurcraftArmory.MODID)
public class ArmorEffectsEvent {
    @SubscribeEvent
    public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) {
        // Lead armor Effect.
        int slownessAmplification = -1;
        if (event.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ArmoryItems.leadhelmet) {
            slownessAmplification++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ArmoryItems.leadchestplate) {
            slownessAmplification++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ArmoryItems.leadleggings) {
            slownessAmplification++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ArmoryItems.leadboots) {
            slownessAmplification++;
        }
        if(slownessAmplification>=0)
            event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, (slownessAmplification/2), false, false, true));

//        OurcraftArmory.LOGGER.info("SLowness : " + slownessAmplification);
//        switch (slownessAmplification) {
//            case 0:
//                event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2, false, false, true));
//                break;
//            case 1:
//                event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 2, false, false, true));
//                break;
//            case 2:
//                event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 4, false, false, true));
//                break;
//            case 3:
//                event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 4, false, false, true));
//                break;
//            default:
//        }
    }
}
