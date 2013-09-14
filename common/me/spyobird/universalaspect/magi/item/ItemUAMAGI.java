package me.spyobird.universalaspect.magi.item;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.References;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUAMAGI extends Item 
{
    public ItemUAMAGI(int id)
    {
        super(id);
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspectmagi);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
    }
}
