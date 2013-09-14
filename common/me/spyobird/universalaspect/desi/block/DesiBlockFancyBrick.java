package me.spyobird.universalaspect.desi.block;

import java.util.List;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
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
    public static final String[] blocktypes = new String[] { "sandstone", "coal", "quartz", "iron", "gold", "redstone", "lapis", "diamond", "emerald", "obsidian", "endstone"};
    
    @SideOnly(Side.CLIENT)
    public static final String[] blocknames = new String[] { "Sandstone", "Coal", "Quartz", "Iron", "Gold", "Redstone", "Lapis", "Diamond", "Emerald", "Obsidian", "Endstone"};
    
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
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= this.icons.length)
        {
            par2 = 0;
        }
        return this.icons[par2];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
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
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons = new Icon[blocktypes.length];
        
        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = par1IconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getCleanUnlocalizedName(getUnlocalizedName()) + "_" + blocktypes[i]);
        }
    }
}
