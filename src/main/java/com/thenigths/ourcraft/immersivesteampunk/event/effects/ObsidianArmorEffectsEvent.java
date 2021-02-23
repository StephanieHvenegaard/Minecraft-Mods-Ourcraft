package com.thenigths.ourcraft.immersivesteampunk.event.effects;

import com.thenigths.ourcraft.immersivesteampunk.Main;
import com.thenigths.ourcraft.immersivesteampunk.utils.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ObsidianArmorEffectsEvent {
    @SubscribeEvent
    public static void onTickPlayerEvent(TickEvent.PlayerTickEvent event) {
        // Lead armor Effect.
        int effect = -1;
        if (event.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == RegistryHandler.OBSIDIAN_HELMET.get()) {
            effect++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == RegistryHandler.OBSIDIAN_HELMET.get()) {
            effect++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == RegistryHandler.OBSIDIAN_HELMET.get()) {
            effect++;
        }
        if (event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == RegistryHandler.OBSIDIAN_HELMET.get()) {
            effect++;
        }
        if (effect >= 0)
            event.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20, (effect / 3), false, false, true));
    }
}
