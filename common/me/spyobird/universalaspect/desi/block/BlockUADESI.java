package me.spyobird.universalaspect.desi.block;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUADESI extends Block
{
    public BlockUADESI(int id, Material material)
    {
        super(id, material);
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspectdesi);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), getCleanUnlocalizedName(this.getUnlocalizedName())));
    }
    
    protected String getCleanUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}