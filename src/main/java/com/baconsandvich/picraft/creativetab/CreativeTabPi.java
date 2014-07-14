package com.baconsandvich.picraft.creativetab;

import com.baconsandvich.picraft.init.ModBlocks;
import com.baconsandvich.picraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabPi {

    public static final CreativeTabs PI_TAB = new CreativeTabs(Reference.MODID) {

        @Override
        public Item getTabIconItem() {

            return Item.getItemFromBlock(ModBlocks.runeBlockNumber);

        }

        public String getTranslatedTabLabel(){
            return Reference.NAME;
        }

    };

}
