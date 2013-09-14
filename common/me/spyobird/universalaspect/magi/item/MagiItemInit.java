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
    
    public static void init()
    {
        ArcaneLevitationWand = new MagiWandArcaneLevitation(Integers.ARCANE_LEVITATION_WAND_ID);
        
        GameRegistry.registerItem(ArcaneLevitationWand, Strings.ARCANE_LEVITATION_WAND_UNLOCAL);
        
        LanguageRegistry.addName(ArcaneLevitationWand, Strings.ARCANE_LEVITATION_WAND_LOCAL);
        LanguageRegistry.addName(new ItemStack(ArcaneLevitationWand, 1, 50), Strings.ARCANE_LEVITATION_WAND_LOCAL + Strings.WAND_CHARGED);
    }
}
