package me.spyobird.universalaspect.tech.block;

import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.tech.tileentity.TechTileEntitySonicTNT;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TechBlockSonicTNT extends BlockUATECH
{
    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    
    @SideOnly(Side.CLIENT)
    private Icon bottomIcon;
    
    @SideOnly(Side.CLIENT)
    private Icon sideIcon;
    
    public TechBlockSonicTNT(int id)
    {
        super(id, Material.tnt);
        // TODO Auto-generated constructor stub
        this.setUnlocalizedName(Strings.SONIC_TNT_BLOCK_UNLOCAL);
        this.setHardness(2F);
        this.setStepSound(Block.soundMetalFootstep);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        topIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), this.getUnlocalizedName().substring(5)) + "_top");
        bottomIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), this.getUnlocalizedName().substring(5)) + "_bottom");
        sideIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), this.getUnlocalizedName().substring(5)) + "_side");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        if (side == 0)
        {
            return bottomIcon;
        }
        else if (side == 1)
        {
            return topIcon;
        }
        else
        {
            return sideIcon;
        }
    }
    
    @Override
    public boolean canDropFromExplosion(Explosion par1Explosion)
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TechTileEntitySonicTNT();
    }
}
