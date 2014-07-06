package com.baconsandvich.picraft.utility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class WorldHelper {

    public static String getName(Block block){

        if (block != null){
            return block.getUnlocalizedName().substring(5);
        }else return "";

    }

    public static String getName(Item item){

        if (item != null){
            return item.getUnlocalizedName().substring(5);
        }else return "";

    }

}
