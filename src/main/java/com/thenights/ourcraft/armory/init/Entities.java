//package com.thenights.ourcraft.armory.init;
//
//
//import com.thenights.ourcraft.armory.OurcraftArmory;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.IForgeRegistry;
//import net.minecraftforge.registries.IForgeRegistryEntry;
//import org.jline.utils.Log;
//
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//public class Entities {
//    public static final EntityType<ArrowBaseEntity> ARROW_SW = EntityType.Builder.create(ArrowBaseEntity::new, EntityClassification.MISC).setShouldReceiveVelocityUpdates(true).size(0.5F, 0.5F)
//        .setCustomClientFactory(ArrowBaseEntity::new).func_206830_a("arrow_sw").setRegistryName(OurcraftArmory.MODID, "arrow");
//
//    @SubscribeEvent
//    public static void register(RegistryEvent.Register<EntityType<?>> ev) {
//        Log.info("Registering Entities");
//        IForgeRegistry<EntityType<?>> reg = ev.getRegistry();
//
//        reg.registerAll((IForgeRegistryEntry[])new EntityType[] {ARROW_SW});
//    }
//}
