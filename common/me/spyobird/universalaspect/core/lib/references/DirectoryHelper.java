package me.spyobird.universalaspect.core.lib.references;

import net.minecraft.util.ResourceLocation;

public class DirectoryHelper
{
    public static ResourceLocation getResourceLocation(String modid, String path)
    {
        return new ResourceLocation(modid, path);
    }
    
    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(References.MOD_ID.toLowerCase(), path);
    }
}
