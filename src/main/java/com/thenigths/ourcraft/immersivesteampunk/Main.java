package com.thenigths.ourcraft.immersivesteampunk;


import com.thenigths.ourcraft.immersivesteampunk.utils.RegistryHandler;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID= "immersivesteampunk";
    public static final String MOD_NAME= "Immersive Steampunk";


    public Main() {

    // Register the setup method for modloading
    //    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
//        // Register ourselves for server and other game events we are interested in
        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

//    private void setup(final FMLCommonSetupEvent event)
//    {
//
//    }
//
//    private void doClientStuff(final FMLClientSetupEvent event) {
//
//    }
//
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//
//    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//
//        }
//    }
}
