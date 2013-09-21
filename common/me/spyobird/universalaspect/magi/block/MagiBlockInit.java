package me.spyobird.universalaspect.magi.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.block.Block;

public class MagiBlockInit
{
    public static Block CardReader;
    
    public static void init()
    {
        CardReader = new MagiBlockCardReader(Integers.CARD_READER_BLOCK_ID);
        
        GameRegistry.registerBlock(CardReader, Strings.CARD_READER_BLOCK_UNLOCAL);

    }
    
    public static void names()
    {
        LanguageRegistry.addName(CardReader, Strings.CARD_READER_BLOCK_LOCAL);
    }
}
