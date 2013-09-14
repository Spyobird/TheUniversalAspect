package me.spyobird.universalaspect.desi.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class DesiItemBlockFancyBrick extends ItemBlock
{
    public DesiItemBlockFancyBrick(int par1)
    {
        super(par1);
        // TODO Auto-generated constructor stub
        this.setHasSubtypes(true);
    }
    
    public int getMetadata(int par1)
    {
        return par1;
    }
}
