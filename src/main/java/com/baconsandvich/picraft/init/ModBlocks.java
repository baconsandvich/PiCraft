package com.baconsandvich.picraft.init;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.utility.RegisterHelper;
import net.minecraft.block.Block;

public class ModBlocks {

    public static final Block runeBlock = new BlockRune();

    public static void init() {

        RegisterHelper.registerBlock(runeBlock);

    }

}
