package me.spyobird.universalaspect.desi.block;

import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DesiBlockInit
{
    public static Block FancyBrickBase;
    
    public static void init()
    {
        FancyBrickBase = new DesiBlockFancyBrick(Integers.FANCY_BRICK_BLOCK_ID);
        
        GameRegistry.registerBlock(FancyBrickBase, DesiItemBlockFancyBrick.class, Strings.FANCY_BRICK_BLOCK_UNLOCAL);
    }
    
    public static void names()
    {
        for (int i = 0; i < DesiItemBlockFancyBrick.blocktypes.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(FancyBrickBase, 1, i), Strings.FANCY_BRICK_BLOCK_LOCAL[i]);
        }
    }
}
