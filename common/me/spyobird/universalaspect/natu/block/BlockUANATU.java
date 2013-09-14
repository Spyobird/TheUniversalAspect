package me.spyobird.universalaspect.natu.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockUANATU extends Block
{
    public BlockUANATU(int id, Material material)
    {
        super(id, material);
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspectnatu);
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
