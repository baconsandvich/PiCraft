package com.baconsandvich.picraft.block.rune;

import com.baconsandvich.picraft.block.BlockRune;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.WorldHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRuneNumber extends BlockRune{

    public BlockRuneNumber() {
        this.setBlockName("runeBlockNumber");
    }

    @SideOnly(Side.CLIENT)
    private IIcon runeNumberIcon[] = new IIcon[16];

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register){

        runeIcon = register.registerIcon("picraft:runeBlock");
        runeTypeIcon = register.registerIcon(Reference.MODID + ":rune/" + getUnlocalizedName().substring(5));
        for (int i = 1; i <= 15; i++){
            runeNumberIcon[i] = register.registerIcon(Reference.MODID + ":rune/" + getUnlocalizedName().substring(5) + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {

        if (side == 0 | side == 1){
            return runeIcon;
        }else if (meta == 0){
            return runeTypeIcon;
        }else{
            return runeNumberIcon[meta];
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        //Overrides default RuneBlock meta generation

    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote){
            int newMeta = world.getBlockMetadata(x,y,z) + 1;

            if (newMeta == 16 && WorldHelper.getName(world.getBlock(x,y+1,z)).equals("runeBlockNumber")){

                int neighborMeta = world.getBlockMetadata(x,y+1,z) + 1;
                world.setBlockMetadataWithNotify(x,y+1,z,neighborMeta,3);

            }

            world.setBlockMetadataWithNotify(x,y,z,newMeta,3);
        }
        isActive = true;

        return true;
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess block, int x, int y, int z, int side)
    {
        return block.getBlockMetadata(x,y,z);
    }

}
