package com.baconsandvich.picraft.init;

import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.RegisterHelper;
import com.baconsandvich.picraft.item.ItemRuneHint;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {

    public static final Item runeHintItem = new ItemRuneHint();

    public static void init() {

        RegisterHelper.RegisterItem(runeHintItem);

    }

}
