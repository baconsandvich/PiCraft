package com.baconsandvich.picraft;

import com.baconsandvich.picraft.handler.ConfigHandler;
import com.baconsandvich.picraft.init.Recipes;
import com.baconsandvich.picraft.proxy.IProxy;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.init.ModBlocks;
import com.baconsandvich.picraft.init.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.CLIENT_FOLDER + ".gui.GuiFactory")
public class PiCraft {

    @Mod.Instance(Reference.MODID)
    public static PiCraft instance;

    @SidedProxy(clientSide = Reference.PROXY_FOLDER + ".ClientProxy", serverSide = Reference.PROXY_FOLDER + ".ServerProxy")
    public  static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        ModItems.init();
        ModBlocks.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        Recipes.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
