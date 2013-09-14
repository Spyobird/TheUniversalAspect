package me.spyobird.universalaspect.desi.block;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.desi.tileentity.TileUADESI;
import net.minecraft.block.BlockStep;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStepUADESI extends BlockStep
{
    public BlockStepUADESI(int par1, boolean par2)
    {
        super(par1, par2);
        // TODO Auto-generated constructor stub
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspectdesi);
    }
    
    @SideOnly(Side.CLIENT)
    private Icon theIcon;
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("SandstoneBrick");
        this.theIcon = par1IconRegister.registerIcon(this.getCleanUnlocalizedName(this.getUnlocalizedName()) + "_side");
    }
    
    protected String getCleanUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entityLiving, ItemStack itemStack)
    {
        int direction = 0;
        int facing = MathHelper
                .floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        
        if (facing == 0)
        {
            direction = ForgeDirection.NORTH.ordinal();
        } else if (facing == 1)
        {
            direction = ForgeDirection.EAST.ordinal();
        } else if (facing == 2)
        {
            direction = ForgeDirection.SOUTH.ordinal();
        } else if (facing == 3)
        {
            direction = ForgeDirection.WEST.ordinal();
        }
        world.setBlockMetadataWithNotify(x, y, z, direction, 3);
        
        if (itemStack.hasDisplayName())
        {
            ((TileUADESI) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }
        ((TileUADESI) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
}
