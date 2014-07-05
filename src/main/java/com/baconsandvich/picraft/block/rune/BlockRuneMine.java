package com.baconsandvich.picraft.block.rune;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRuneMine extends BlockRune{

    public BlockRuneMine() {
        this.setBlockName("runeBlockMine");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register){

        runeIcon = register.registerIcon("picraft:runeBlock");
        runeTypeIcon = register.registerIcon(Reference.MODID + ":rune/" + getUnlocalizedName().substring(5));
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

        LogHelper.info("[BlockRuneSun] " + world.getBlock(trueCoords[0], trueCoords[1] + 2, trueCoords[2]).getUnlocalizedName().substring(5));

        //Check and set trueCoords[]
        if (world.getBlock(x,y,z).getUnlocalizedName().substring(5).equals("runeBlockMine")){

            trueCoords[0] = x;
            trueCoords[1] = y;
            trueCoords[2] = z;

        }

        if (world.getBlock(trueCoords[0], trueCoords[1]+1, trueCoords[2]).getUnlocalizedName().substring(5).equals("air")){
            world.setBlock(trueCoords[0], trueCoords[1]+1, trueCoords[2], grabOre(world));
        }

    }

    private Block grabOre(World world){

        for (int iY = 0; iY < trueCoords[1]; iY++){
            for (int iX = -8; iX <= 8; iX++){
                for (int iZ = -8; iZ <= 8; iZ++){
                    Block block = world.getBlock(trueCoords[0] + iX,trueCoords[1] + iY,trueCoords[2] + iZ);
                    if (block instanceof BlockOre){
                        world.setBlock(trueCoords[0] + iX,trueCoords[1] + iY,trueCoords[2] + iZ, Block.getBlockFromName("stone"));
                        return block;
                    }
                }
            }
        }
        return Block.getBlockFromName("air");
    }

}
