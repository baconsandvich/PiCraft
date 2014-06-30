package com.baconsandvich.picraft.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static void init(File configFile){

        Configuration configuration = new Configuration(configFile);

        try{
            configuration.load();
        }
        catch (Exception e){

        }
        finally {
            configuration.save();
        }

    }

}
