package com.baconsandvich.picraft.item;

import com.baconsandvich.picraft.help.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRuneHint extends Item {

    public ItemRuneHint(){

        super();
        setUnlocalizedName("runeHintItem");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(CreativeTabs.tabMisc);

    }

}
