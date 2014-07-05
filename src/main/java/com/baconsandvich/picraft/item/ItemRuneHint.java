package com.baconsandvich.picraft.item;

import com.baconsandvich.picraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRuneHint extends Item {

    public ItemRuneHint(){

        super();
        this.setUnlocalizedName("runeHintItem");
        this.setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.maxStackSize = 1;

    }

}
