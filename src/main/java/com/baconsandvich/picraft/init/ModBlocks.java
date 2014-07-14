package com.baconsandvich.picraft.init;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.block.rune.BlockRuneMine;
import com.baconsandvich.picraft.block.rune.BlockRuneNumber;
import com.baconsandvich.picraft.block.rune.BlockRuneSun;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.RegisterHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {

    public static final BlockRune runeBlockSun = new BlockRuneSun();
    public static final BlockRune runeBlockNumber = new BlockRuneNumber();
    public static final BlockRune runeBlockMine = new BlockRuneMine();

    public static void init() {

        RegisterHelper.registerBlock(runeBlockSun);
        RegisterHelper.registerBlock(runeBlockNumber);
        RegisterHelper.registerBlock(runeBlockMine);

    }

}
