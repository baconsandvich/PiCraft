package com.baconsandvich.picraft.init;

import com.baconsandvich.picraft.help.RegisterHelper;
import com.baconsandvich.picraft.item.ItemRuneHint;
import net.minecraft.item.Item;

public class ModItems {

    public static final Item runeHintItem = new ItemRuneHint();

    public static void init() {

        RegisterHelper.RegisterItem(runeHintItem);

    }

}
