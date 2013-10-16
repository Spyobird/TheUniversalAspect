package me.spyobird.universalaspect.tech.tileentity;

import me.spyobird.universalaspect.natu.ores.block.OresBlockInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TechTileEntityGrinder extends TileEntity implements IInventory
{
    private ItemStack[] items;
    
    public TechTileEntityGrinder()
    {
        items = new ItemStack[2];
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
        ItemStack itemstack = getStackInSlot(i);
        
        if (itemstack != null)
        {
            if(itemstack.stackSize <= j)
            {
                setInventorySlotContents(i, null);
            }
            else
            {
                itemstack = itemstack.splitStack(j);
                onInventoryChanged();
            }
        }
        return itemstack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        // TODO Auto-generated method stub
        ItemStack itemstack = getStackInSlot(i);
        setInventorySlotContents(i, null);
        return itemstack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        items[i] = itemstack;
        
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
        onInventoryChanged();
    }

    @Override
    public String getInvName()
    {
        // TODO Auto-generated method stub
        return "Grinder";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        // TODO Auto-generated method stub
        return true;
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
        return itemstack.itemID == OresBlockInit.CopperOre.blockID;
    }
}
