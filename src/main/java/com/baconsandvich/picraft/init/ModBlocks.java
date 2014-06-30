package com.baconsandvich.picraft.init;

import com.baconsandvich.picraft.blocks.BlockRune;
import com.baconsandvich.picraft.blocks.runes.BlockRuneNumber;
import com.baconsandvich.picraft.blocks.runes.BlockRuneSun;
import com.baconsandvich.picraft.utility.RegisterHelper;
import net.minecraft.block.Block;

public class ModBlocks {

    public static final Block runeBlock = new BlockRune();
    public static final BlockRune runeBlockSun = new BlockRuneSun();
    public static final BlockRune runeBlockNumber = new BlockRuneNumber();

    public static void init() {

        RegisterHelper.registerBlock(runeBlock);
        RegisterHelper.registerBlock(runeBlockSun);
        RegisterHelper.registerBlock(runeBlockNumber);

    }

}
