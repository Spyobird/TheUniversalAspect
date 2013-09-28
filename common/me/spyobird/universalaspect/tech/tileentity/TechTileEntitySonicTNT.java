package me.spyobird.universalaspect.tech.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TechTileEntitySonicTNT extends TileEntity
{   
    
    public TechTileEntitySonicTNT()
    {
        
    }
   
    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote)
        {
            
        } 
    }
    
    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
    }
}
