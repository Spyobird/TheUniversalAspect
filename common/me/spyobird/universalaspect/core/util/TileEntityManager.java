package me.spyobird.universalaspect.core.util;

import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.tech.tileentity.TechTileEntityGrinder;
import me.spyobird.universalaspect.tech.tileentity.TechTileEntitySonicTNT;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TechTileEntityGrinder.class, Strings.GRINDER_TILE_NAME);
        GameRegistry.registerTileEntity(TechTileEntitySonicTNT.class, Strings.SONIC_TNT_TILE_NAME);
    }
}
