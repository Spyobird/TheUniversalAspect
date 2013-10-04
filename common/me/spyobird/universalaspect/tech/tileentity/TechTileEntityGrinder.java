package me.spyobird.universalaspect.tech.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TechTileEntityGrinder extends TileEntity implements IInventory
{
    private ItemStack[] items;
    
    public TechTileEntityGrinder()
    {
        items = new ItemStack[3];
    }

    @Override
    public int getSizeInventory()
    {
        // TODO Auto-generated method stub
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        // TODO Auto-generated method stub
        return items[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public String getInvName()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInvNameLocalized()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        // TODO Auto-generated method stub
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        // TODO Auto-generated method stub
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
