package com.baconsandvich.picraft.client.gui;

import com.baconsandvich.picraft.handler.ConfigHandler;
import com.baconsandvich.picraft.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

public class ModGuiConfig extends GuiConfig{


    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,

                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MODID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString())

                );
    }
}
