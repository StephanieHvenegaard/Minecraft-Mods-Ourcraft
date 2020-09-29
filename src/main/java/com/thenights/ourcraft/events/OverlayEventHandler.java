//package com.thenights.ourcraft.events;
//import com.thenights.ourcraft.render.ArmorBarRenderer;
//import com.thenights.ourcraft.render.HealthBarRenderer;
//import net.minecraftforge.client.event.RenderGameOverlayEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//public class OverlayEventHandler {
//    private HealthBarRenderer healthBarRenderer = new HealthBarRenderer();
//    private ArmorBarRenderer armorBarRenderer = new ArmorBarRenderer();
//
//    @SubscribeEvent(receiveCanceled = true)
//    public void onRenderGameOverlayEventPre(RenderGameOverlayEvent.Pre event) {
//        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
//            int scaledWidth = event.getResolution().getScaledWidth();
//            int scaledHeight = event.getResolution().getScaledHeight();
//            this.healthBarRenderer.renderHealthBar(scaledWidth, scaledHeight);
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent(receiveCanceled = true)
//    public void onRenderGameOverlayEventPre(RenderGameOverlayEvent event) {
//        if (event.getType() == RenderGameOverlayEvent.ElementType.ARMOR) {
//            int scaledWidth = event.getResolution().getScaledWidth();
//            int scaledHeight = event.getResolution().getScaledHeight();
//            armorBarRenderer.renderArmorBar(scaledWidth, scaledHeight);
//            event.setCanceled(true);
//        }
//    }
//}
//
