package me.spyobird.universalaspect.magi.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.magi.item.wands.MagiWandArcaneLevitation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagiItemInit
{
    public static Item ArcaneLevitationWand;
    public static Item Card;
    
    public static void init()
    {
        ArcaneLevitationWand = new MagiWandArcaneLevitation(Integers.ARCANE_LEVITATION_WAND_ID);
        Card = new MagiItemCard(Integers.CARD_ID);
        
        GameRegistry.registerItem(ArcaneLevitationWand, Strings.ARCANE_LEVITATION_WAND_UNLOCAL);
        GameRegistry.registerItem(Card, Strings.CARD_UNLOCAL);
    }
    
    public static void names()
    {
        LanguageRegistry.addName(ArcaneLevitationWand, Strings.ARCANE_LEVITATION_WAND_LOCAL);
        
        for (int i = 0; i < MagiItemCard.itemtypes.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Card, 1, i), Strings.CARD_LOCAL[i]);
        }
    }
}
