package com.baconsandvich.picraft.block;

import com.baconsandvich.picraft.creativetab.CreativeTabPi;
import com.baconsandvich.picraft.reference.Reference;
import com.baconsandvich.picraft.utility.TextureHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRune extends Block {

    public BlockRune() {
        super(Material.rock);
        this.setStepSound(soundTypeStone);
        this.setHardness(4f);
        this.setResistance(5f);
        this.setLightLevel(0.5f);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(CreativeTabPi.PI_TAB);
    }

    protected int activeBlockSide = 0;

    @SideOnly(Side.CLIENT)
    protected IIcon runeIcon;

    @SideOnly(Side.CLIENT)
    protected IIcon runeTypeIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        runeIcon = register.registerIcon("picraft:runeBlock");
        runeTypeIcon = register.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "Test");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {

        if (side == meta){
            return runeTypeIcon;
        }else{
            return runeIcon;
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){

        activeBlockSide = TextureHelper.getBlockSideFacingEntity(x, y, z, entity);
        world.setBlockMetadataWithNotify(x, y, z, activeBlockSide, 2);


    }

    public void onBlockAdded(World world, int x, int y, int z) {

        activeBlockSide = world.rand.nextInt(3) + 2;
        world.setBlockMetadataWithNotify(x,y,z,activeBlockSide,2);

    }

}
