package me.spyobird.universalaspect.tech.block;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.References;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUATECH extends BlockContainer
{
    public BlockUATECH(int id, Material material)
    {
        super(id, material);
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspecttech);
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

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
