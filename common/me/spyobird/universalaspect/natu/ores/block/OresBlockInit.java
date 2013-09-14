package me.spyobird.universalaspect.natu.ores.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.block.Block;

public class OresBlockInit
{
    public static Block CopperOre;
    
    public static void init()
    {
        CopperOre = new OreBlockCopperOre(Integers.ORE_COPPER_BLOCK_ID);
        
        GameRegistry.registerBlock(CopperOre, Strings.ORE_COPPER_BLOCK_UNLOCAL);
        
        LanguageRegistry.addName(CopperOre, Strings.ORE_COPPER_BLOCK_LOCAL);
    }
}
