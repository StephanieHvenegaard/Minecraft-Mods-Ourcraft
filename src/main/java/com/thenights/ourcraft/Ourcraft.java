package com.thenights.ourcraft;

import com.thenights.ourcraft.proxy.ClientProxy;
import com.thenights.ourcraft.proxy.CommonProxy;
import com.thenights.ourcraft.tab.CoreTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Ourcraft.MODID, name = Ourcraft.NAME, version = Ourcraft.VERSION, acceptedMinecraftVersions = "[1.12,1.12.2]")
public class Ourcraft
{


    public static final String MODID = "ourcraft";
    public static final String NAME = "Ourcraft Mod";
    public static final String VERSION = "1.12.2-1.0.0";
    public static final String RESOURCE_PREFIX = MODID+":";
    public static final String CLIENT_PROXY = "com.thenights.ourcraft.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.thenights.ourcraft.proxy.ServerProxy";

    private static Logger logger;

    @Mod.Instance
    public static Ourcraft INSTANCE;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;
    public static final CreativeTabs CORE_TAB = (CreativeTabs)new CoreTab();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.PreInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.Init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.PostInit(event);
    }
}
