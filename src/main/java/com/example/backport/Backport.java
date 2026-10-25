package com.example.backport;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Backport.MODID, name = Backport.NAME, version = Backport.VERSION)
public class Backport {

    public static final String MODID = "backport";
    public static final String NAME = "Backport";
    public static final String VERSION = "0.1.0";

    @Mod.Instance(MODID)
    public static Backport instance;

    @SidedProxy(
        clientSide = "com.example.backport.ClientProxy",
        serverSide = "com.example.backport.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
