package me.spyobird.universalaspect.core.lib.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabUA extends CreativeTabs
{
    public CreativeTabUA(int par1, String par2Str)
    {
        super(par1, par2Str);
        // TODO Auto-generated constructor stub
    }
        
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack()
    {
        return null;
    }
}
