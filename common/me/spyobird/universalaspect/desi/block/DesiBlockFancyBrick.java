package me.spyobird.universalaspect.desi.block;

import java.util.List;

import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DesiBlockFancyBrick extends BlockUADESI
{
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public DesiBlockFancyBrick(int id)
    {
        super(id, Material.rock);
        // TODO Auto-generated constructor stub
        this.setUnlocalizedName(Strings.FANCY_BRICK_BLOCK_UNLOCAL);
        this.setHardness(0.8F);
    } 
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        if (meta < 0 || meta >= this.icons.length)
        {
            meta = 0;
        }
        return this.icons[meta];
    }

    public int damageDropped(int meta)
    {
        return meta;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs creativeTab, List par3List)
    {           
        for (int var4 = 0; var4 < 11; ++var4)
        {
            par3List.add(new ItemStack(id, 1, var4));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.icons = new Icon[DesiItemBlockFancyBrick.blocktypes.length];
        
        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "_" + DesiItemBlockFancyBrick.blocktypes[i]);
        }
    }
}
