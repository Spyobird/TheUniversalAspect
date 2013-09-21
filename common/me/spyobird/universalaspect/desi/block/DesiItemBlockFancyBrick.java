package me.spyobird.universalaspect.desi.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class DesiItemBlockFancyBrick extends ItemBlock
{
    @SideOnly(Side.CLIENT)
    public static final String[] blocktypes = new String[] { "sandstone", "coal", "quartz", "iron", "gold", "redstone", "lapis", "diamond", "emerald", "obsidian", "endstone" };
    
    public DesiItemBlockFancyBrick(int id)
    {
        super(id);
        // TODO Auto-generated constructor stub
        this.setHasSubtypes(true);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 11);
        return super.getUnlocalizedName() + blocktypes[meta];
    }
    
    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}
