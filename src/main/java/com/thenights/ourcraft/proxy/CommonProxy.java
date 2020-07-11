package com.thenights.ourcraft.proxy;

import com.thenights.ourcraft.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void PreInit(FMLPreInitializationEvent event) {
        ModItems.PreInit();
        //ModBlocks.PreInit();

        //PacketHandler.Init();
    }

    public void Init(FMLInitializationEvent event) {
        ModItems.Init();
        //ModBlocks.Init();
    }

    public void PostInit(FMLPostInitializationEvent event) {}
}

