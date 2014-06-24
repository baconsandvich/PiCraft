package com.baconsandvich.picraft.block;

import com.baconsandvich.picraft.help.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockRune extends Block {

    public BlockRune() {
        super(Material.rock);
        setBlockName("runeBlock");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(CreativeTabs.tabBlock);
        setStepSound(soundTypeStone);
        setHardness(4.0f);
        setResistance(5.0f);
        setLightLevel(0.5f);
        setHarvestLevel("pickaxe", 3);
    }

}
