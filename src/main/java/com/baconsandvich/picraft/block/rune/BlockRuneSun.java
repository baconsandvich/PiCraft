package com.baconsandvich.picraft.block.rune;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.reference.TimeRef;
import com.baconsandvich.picraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRuneSun extends BlockRune{

    public BlockRuneSun() {
        this.setBlockName("runeBlockSun");
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
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){

        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x,y,z)){

            activeBlockSide = world.getBlockMetadata(x,y,z);
            boolean[] glowstoneDetected = new boolean[9];
            String detectedBlock;
            int k = 0;

            if (activeBlockSide == 3 | activeBlockSide == 4){
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){

                        if (activeBlockSide == 3){

                            detectedBlock = world.getBlock(x + i, y + j, z).getUnlocalizedName().substring(5);

                            if (detectedBlock.equals("lightgem")){

                                glowstoneDetected[k] = true;

                            }else {
                                glowstoneDetected[k] = false;
                            }
                            k++;

                        }
                        else if (activeBlockSide == 4){

                            detectedBlock = world.getBlock(x, y + j, z + i).getUnlocalizedName().substring(5);

                            if (detectedBlock.equals("lightgem")){

                                glowstoneDetected[k] = true;

                            }else {
                                glowstoneDetected[k] = false;
                            }
                            k++;

                        }
                    }
                }
            }
            else if (activeBlockSide == 2 | activeBlockSide == 5){
                for (int i = 1; i >= -1; i--){
                    for (int j = -1; j <= 1; j++){

                        if (activeBlockSide == 2){

                            detectedBlock = world.getBlock(x + i, y + j, z).getUnlocalizedName().substring(5);

                            if (detectedBlock.equals("lightgem")){

                                glowstoneDetected[k] = true;

                            }else {
                                glowstoneDetected[k] = false;
                            }
                            k++;

                        }
                        else if (activeBlockSide == 5){

                            detectedBlock = world.getBlock(x, y + j, z + i).getUnlocalizedName().substring(5);

                            if (detectedBlock.equals("lightgem")){

                                glowstoneDetected[k] = true;

                            }else {
                                glowstoneDetected[k] = false;
                            }
                            k++;

                        }
                    }
                }
            }

            if(onlyOneGlowstone(glowstoneDetected)){
                if(glowstoneDetected[0]){
                    world.setWorldTime(TimeRef.LATENIGHT);
                }
                else if(glowstoneDetected[1]){
                    world.setWorldTime(TimeRef.DAWN);
                }
                else if(glowstoneDetected[2]){
                    world.setWorldTime(TimeRef.MORNING);
                }
                else if(glowstoneDetected[3]){
                    world.setWorldTime(TimeRef.MIDNIGHT);
                }
                else if(glowstoneDetected[5]){
                    world.setWorldTime(TimeRef.NOON);
                }
                else if(glowstoneDetected[6]){
                    world.setWorldTime(TimeRef.NIGHT);
                }
                else if(glowstoneDetected[7]){
                    world.setWorldTime(TimeRef.DUSK);
                }
                else if(glowstoneDetected[8]){
                    world.setWorldTime(TimeRef.AFTERNOON);
                }

            }

        }

    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

        int time = (int)world.getWorldTime()/100;
        int formattedTime = time/16;
        int modTime = time%16;

        LogHelper.info("[BlockRuneSun] " + world.getBlock(trueCoords[0],trueCoords[1]+2,trueCoords[2]).getUnlocalizedName().substring(5));

        //Check and set trueCoords[]
        if (world.getBlock(x,y+2,z).getUnlocalizedName().substring(5).equals("runeBlockNumber")){

            trueCoords[0] = x;
            trueCoords[1] = y;
            trueCoords[2] = z;

        }

        if (world.getBlock(trueCoords[0],trueCoords[1]+2,trueCoords[2]).getUnlocalizedName().substring(5).equals("runeBlockNumber")){

            world.setBlockMetadataWithNotify(trueCoords[0],trueCoords[1]+2,trueCoords[2],modTime,3);

        }
        if (world.getBlock(trueCoords[0],trueCoords[1]+3,trueCoords[2]).getUnlocalizedName().substring(5).equals("runeBlockNumber")){

            world.setBlockMetadataWithNotify(trueCoords[0],trueCoords[1]+3,trueCoords[2],formattedTime,3);

        }

    }

    private boolean onlyOneGlowstone(boolean[] detected){

        boolean found = false;
        for (int i = 0; i < 9; i++){
            if (detected[i]){
                if(found){
                    return false;
                }
                found = true;
            }
        }
        return found;

    }

}
