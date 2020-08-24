package com.thenights.ourcraft.proxy;

import com.thenights.ourcraft.events.OverlayEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy  extends CommonProxy
{
    public static OverlayEventHandler overlayEventHandler = new OverlayEventHandler();

    public void PreInit(FMLPreInitializationEvent event) { super.PreInit(event); }
    public void Init(FMLInitializationEvent event) { super.Init(event); }
    public void PostInit(FMLPostInitializationEvent event) {
        super.PostInit(event);
        MinecraftForge.EVENT_BUS.register(overlayEventHandler);
    }
}
