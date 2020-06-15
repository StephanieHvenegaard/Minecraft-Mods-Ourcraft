package com.thenights.ourcraft.armory;

import com.thenights.ourcraft.armory.client.ClientHelper;
import com.thenights.ourcraft.armory.core.Configs;
import com.thenights.ourcraft.armory.proxy.ArmoryClientProxy;
import com.thenights.ourcraft.armory.proxy.ArmoryCommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OurcraftArmory.MODID)
public class OurcraftArmory {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "ourcraft-armory";

    public static ArmoryCommonProxy proxy = DistExecutor.runForDist(() -> ArmoryClientProxy::new, () -> ArmoryCommonProxy::new);

    public OurcraftArmory() {
        LOGGER.info("Constructing Mod: Ourcraft Armory");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSteup);// Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);// Register the doClientStuff method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);// Register the enqueueIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);// Register the processIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bakeConfigs);// Register the bakeConfigs method for modloading

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onSteup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setting up ourcraft armory!");
        LOGGER.info("running post Init");
        proxy.postInit(event);

    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Setting up ourcraft armory! Client Side");
        LOGGER.info("register renderes.");
        ClientHelper.registerEntityRenders();
        ClientHelper.registerItemRenders();
    }


    /* ========================================================
Other Crap
======================================================== */
    @SubscribeEvent
    public void bakeConfigs(ModConfig.ModConfigEvent event) {
        if (event.getConfig().getSpec() == Configs.CLIENT_SPEC) {
            Configs.bake();
        }
    }

    public static class ConfigChange {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            //Only process events for this mod
            if (event.getModID().equals(MODID)) {
                proxy.onConfigChanged(event);
            }
        }
    }
}
