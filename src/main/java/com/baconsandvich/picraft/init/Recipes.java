package com.baconsandvich.picraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {

    public static void init(){

        //Vanilla Recipies
        //GameRegistry.addRecipe(new ItemStack(ModItems.runeHintItem), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        //GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.runeBlockMine), new ItemStack(ModItems.runeHintItem), new ItemStack(ModItems.runeHintItem));

        //OreDictionary Recipies
        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.runeHintItem), " s ", "sss", " s ", 's', "stickWood"));
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.runeBlockMine), new ItemStack(ModItems.runeHintItem), new ItemStack(ModItems.runeHintItem)));

    }

}
