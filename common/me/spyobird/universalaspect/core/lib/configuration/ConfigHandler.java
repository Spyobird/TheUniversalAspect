package me.spyobird.universalaspect.core.lib.configuration;

import java.io.File;

import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Keys;
import net.minecraftforge.common.Configuration;

public class ConfigHandler
{
    private static final String CATAGORY_MISC = "catagory.misc";
    private static final String CATAGORY_TECH = "catagory.tech";
    private static final String CATAGORY_MAGI = "catagory.magi";
    private static final String CATAGORY_NATU = "catagory.natu";
    private static final String CATAGORY_DESI = "catagory.desi";
    
    public static void init(File file)
    {
        Configuration config = new Configuration(file);
        
        config.load();
        
        Integers.ORE_COPPER_BLOCK_ID = config.getBlock(CATAGORY_NATU, Keys.ORE_COPPER_BLOCK_KEY, Integers.ORE_COPPER_BLOCK_ID_DEFAULT).getInt();
        Integers.FANCY_BRICK_BLOCK_ID = config.getBlock(CATAGORY_DESI, Keys.FANCY_BRICK_BLOCK_KEY, Integers.FANCY_BRICK_BLOCK_ID_DEFAULT).getInt();
        
        Integers.ARCANE_LEVITATION_WAND_ID = config.getItem(CATAGORY_MAGI, Keys.ARCANE_LEVITATION_WAND_KEY, Integers.ARCANE_LEVITATION_WAND_ID_DEFAULT).getInt() - 256;
        
        config.save();
    }
}
