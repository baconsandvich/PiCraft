package com.baconsandvich.picraft.utility;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class TextureHelper {

    public static int getBlockSideFacingEntity(int x, int y, int z, EntityLivingBase entity){

        int sidePlaced = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (sidePlaced == 0)
        {
            return 2;
        }

        if (sidePlaced == 1)
        {
            return 5;
        }

        if (sidePlaced == 2)
        {
            return 3;
        }

        if (sidePlaced == 3)
        {
            return 4;
        }
        LogHelper.warn("TextureHelper could not find proper side via entity rotation, defaulting to side 2!");
        return 2;
    }

}
