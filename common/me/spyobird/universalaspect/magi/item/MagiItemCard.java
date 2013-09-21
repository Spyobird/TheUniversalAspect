package me.spyobird.universalaspect.magi.item;

import java.util.List;

import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.magi.block.MagiBlockInit;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagiItemCard extends ItemUAMAGI
{
    @SideOnly(Side.CLIENT)
    public static final String[] itemtypes = new String[] { "blank", "fire", "water", "earth", "air", "arcane", "ominous" };
    
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public MagiItemCard(int id)
    {
        super(id);
        // TODO Auto-generated constructor stub
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.CARD_UNLOCAL);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 6);
        return super.getUnlocalizedName() + "_" + itemtypes[meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        icons = new Icon[itemtypes.length];
        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = register.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "_" + itemtypes[i]);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return icons[dmg]; 
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < itemtypes.length; i++)
        {
            ItemStack stack = new ItemStack(id, 1, i);
            list.add(stack);
        }
    }
    
    @Override
    public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float HitY, float HitZ)
    {
        if (!world.isRemote && world.getBlockId(x, y, z) == MagiBlockInit.CardReader.blockID)
        {
            int m = world.getBlockMetadata(x, y, z);
            int type = itemstack.getItemDamage();
            world.setBlockMetadataWithNotify(x, y, z, type, 3);
            itemstack.stackSize--;
            return true;
        }
        else
        {
            return false;
        }
    }
}
