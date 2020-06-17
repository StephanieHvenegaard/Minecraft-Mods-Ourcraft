//package com.thenights.ourcraft.witchery.core;
//
//import java.util.stream.Collectors;
//import net.minecraft.block.Block;
//import net.minecraft.item.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.InterModComms;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
//import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//
//// The value here should match an entry in the META-INF/mods.toml file
//@Mod(OurcraftWitchery.MODID)
//public class OurcraftWitchery {
//
//    public static OurcraftWitchery INSTANCE;                                                // public instance of the main mod class
//    public static final String MODID = "ourcraft-witchery";                                 // Mod id
//    public static final ItemGroup OURCRAFT_GROUP = new OurcraftWitcheryTap();               // creative tap
//    // Directly reference a log4j logger.
//    public static final Logger LOGGER = LogManager.getLogger(MODID);                    // Logger
//
//    public OurcraftWitchery() {
//        INSTANCE = this;
//        // Register the setup method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistry);
//
//        // Register ourselves for server and other game events we are interested in
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    // Setup of the mod.
//    private void setup(final FMLCommonSetupEvent event) {
//        // some preinit code
//
//        // OreGeneration.setupOregeneration();
//        LOGGER.info("Setup registred");
//    }
//
//    // Client Side code
//    private void clientRegistry(final FMLClientSetupEvent event) {
//        // do something that can only be done on the client
//        LOGGER.info("Client registred");
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = OurcraftWitchery.MODID)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void registerItems(final RegistryEvent.Register<Item> event) {
//            // register a new item here
//            event.getRegistry().registerAll(
//                    // ------------------------------------------------------------------------------
//                    // OurcraftBlocks
//                    // Wood
//                    // OurcraftItems.greenOakWoodItem =  new BlockItem(OurcraftBlocks.GreenOakPlankBlock,new Item.Properties().group(OURCRAFT_GROUP)).setRegistryName(OurcraftBlocks.GreenOakPlankBlock.getRegistryName()),
//
//            );
//            LOGGER.info("All Items Registered.");
//        }
//
//        @SubscribeEvent
//        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
//            // register a new item here
//            event.getRegistry().registerAll(
//                    // Wood
//                    // OurcraftBlocks.GreenOakPlankBlock = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f, 15.0f).harvestLevel(0).sound(SoundType.WOOD)).setRegistryName(getLocation("greenoak_planks_block")),
//            );
//            LOGGER.info("All Blocks Registered.");
//        }
//
//        //        @SubscribeEvent
////        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
////            // register a new block here
////            LOGGER.info("HELLO from Register Block");
////        }
//        private static ResourceLocation getLocation(String name) {
//            return new ResourceLocation(MODID, name);
//        }
//    }
//
//    private void enqueueIMC(final InterModEnqueueEvent event) {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> {
//            LOGGER.info("Hello world from the MDK");
//            return "Hello world";
//        });
//    }
//
//    private void processIMC(final InterModProcessEvent event) {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m -> m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//}
