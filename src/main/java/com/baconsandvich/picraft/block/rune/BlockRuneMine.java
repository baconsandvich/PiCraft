package com.baconsandvich.picraft.block.rune;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.WorldHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRuneMine extends BlockRune{

    public BlockRuneMine() {
        this.setBlockName("runeBlockMine");
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register){

        runeIcon = register.registerIcon("picraft:runeBlock");
        runeTypeIcon = register.registerIcon(Reference.MODID + ":rune/" + getUnlocalizedName().substring(5));
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

        if (!world.isRemote){

            if (world.isBlockIndirectlyGettingPowered(x, y, z)) {

            }

            if (WorldHelper.getName(world.getBlock(x, y + 1, z)).equals("stone")){

                for (int iY = y-1; iY > 0; iY--){
                    for (int iX = -8; iX <= 8; iX++){
                        for (int iZ = -8; iZ <= 8; iZ++){

                            Block blockOre = world.getBlock(x + iX, iY,z + iZ);
                            if (blockOre instanceof BlockOre | blockOre instanceof BlockRedstoneOre){

                                world.setBlock(x + iX, iY,z + iZ, Block.getBlockFromName("stone"));
                                world.setBlock(x, y+1, z, blockOre);
                                return;

                            }
                        }
                    }
                }
            }
        }

    }

}
