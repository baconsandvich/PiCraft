package com.baconsandvich.picraft;

import com.baconsandvich.picraft.config.ConfigHandler;
import com.baconsandvich.picraft.proxy.IProxy;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.init.ModBlocks;
import com.baconsandvich.picraft.init.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class PiCraft {

    @Mod.Instance(Reference.MODID)
    public static PiCraft instance;

    @SidedProxy(clientSide = Reference.PROXY_FOLDER + ".ClientProxy", serverSide = Reference.PROXY_FOLDER + ".ServerProxy")
    public  static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        ConfigHandler.init(event.getSuggestedConfigurationFile());
        ModItems.init();
        ModBlocks.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
