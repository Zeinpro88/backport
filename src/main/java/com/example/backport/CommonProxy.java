package com.example.backport;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModBlocks.register();
        ModItems.register();
        MinecraftForge.EVENT_BUS.register(new DropHandler());
    }

    public void init(FMLInitializationEvent e) {
        ModRecipes.register();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
