package me.spyobird.universalaspect.tech.block.machine;

import java.util.Random;

import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.tech.block.BlockUATECH;
import me.spyobird.universalaspect.tech.block.TechBlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TechBlockMachineGrinder extends BlockUATECH
{
    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    
    @SideOnly(Side.CLIENT)
    private Icon bottomIcon;
    
    @SideOnly(Side.CLIENT)
    private Icon sideIcon;
    
    @SideOnly(Side.CLIENT)
    private Icon disableIcon;
    
    private final boolean powered;
    
    public TechBlockMachineGrinder(int id, boolean power)
    {
        super(id, Material.iron);
        // TODO Auto-generated constructor stub
        this.setHardness(2F);
        this.setStepSound(Block.soundMetalFootstep);
        this.powered = power;
        
        if (power)
        {
            this.setLightValue(0.1F);
        }
    }
    
    private boolean isDisabled(int meta)
    {
        return meta == 1;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        topIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), this.getUnlocalizedName().substring(5)));
        bottomIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), Strings.MACHINE_GRINDER_BLOCK_UNLOCAL) + "_bottom");
        sideIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), Strings.MACHINE_GRINDER_BLOCK_UNLOCAL) + "_side");
        disableIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), Strings.MACHINE_GRINDER_BLOCK_UNLOCAL) + "_disabled");
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
            return isDisabled(meta) ? disableIcon : topIcon;
        }
        else
        {
            return sideIcon;
        }
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int id)
    {
        if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z)))
        {
            if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z))
            {
                world.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.powered && world.isBlockIndirectlyGettingPowered(x, y, z))
            {
                world.setBlock(x, y, z, TechBlockInit.GrinderMachineActive.blockID, 0, 2);
            }
        }
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            int m = world.getBlockMetadata(x, y, z) == 0 ? 1 : 0;
            world.setBlock(x, y, z, TechBlockInit.GrinderMachine.blockID, 0, 2);
            world.setBlockMetadataWithNotify(x, y, z, m, 3);
        }  
        return true;
    }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z)))
        {
            if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z))
            {
                world.scheduleBlockUpdate(x, y, z, this.blockID, 4);
            }
            else if (!this.powered && world.isBlockIndirectlyGettingPowered(x, y, z))
            {
                world.setBlock(x, y, z, TechBlockInit.GrinderMachineActive.blockID, 0, 2);
            }
        }
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random Random)
    {
        if (!world.isRemote && this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z))
        {
            world.setBlock(x, y, z, TechBlockInit.GrinderMachine.blockID, 0, 2);
        }
    }
    
    @Override
    public int idDropped(int par1, Random Random, int par3)
    {
        return TechBlockInit.GrinderMachine.blockID;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int idPicked(World world, int par1, int par2, int par3)
    {
        return TechBlockInit.GrinderMachine.blockID;
    }
}