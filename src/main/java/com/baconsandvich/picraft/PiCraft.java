package com.baconsandvich.picraft;

import com.baconsandvich.picraft.help.Reference;
import com.baconsandvich.picraft.init.ModBlocks;
import com.baconsandvich.picraft.init.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class PiCraft {

    @Mod.Instance
    public static PiCraft instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

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
