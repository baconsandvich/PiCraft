package com.baconsandvich.picraft.handler;

import com.baconsandvich.picraft.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration configuration;

    public static boolean testValue = false;

    public static void init(File configFile){

        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfig();
        }

    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MODID)){

            loadConfig();

        }
    }

    private static void loadConfig(){

        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example config value");

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
