package me.spyobird.universalaspect.magi.item.wands;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.magi.item.ItemUAMAGI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class MagiWandArcaneLevitation extends ItemUAMAGI
{
    @SideOnly(Side.CLIENT)
    private Icon chargedIcon;
    
    public MagiWandArcaneLevitation(int id)
    {
        super(id);
        // TODO Auto-generated constructors stub
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Strings.ARCANE_LEVITATION_WAND_UNLOCAL);
    }
    
    @Override
    public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase target)
    {
        if (!target.worldObj.isRemote)
        {
            if (isCharged(itemstack.getItemDamage()))
            {
                itemstack.setItemDamage(0);
                target.motionX = (target.posX - player.posX) * 1;
                target.motionZ = (target.posZ - player.posZ) * 1;
                target.motionY = 2.4F;
            }
            else
            {
            itemstack.setItemDamage(itemstack.getItemDamage() + 1);
            target.motionX = (target.posX - player.posX) * 0.2;
            target.motionZ = (target.posZ - player.posZ) * 0.2;
            target.motionY = 1.2F;
            }
        }
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        int meta = MathHelper.clamp_int(stack.getItemDamage(), 0, 50);
        
        if (meta == 50)
            return true;
        else
            return false;
    }
        
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("This Wand is " + itemstack.getItemDamage() * 2 + "% charged.");
        
        if (isCharged(itemstack.getItemDamage()))
        {
            info.add("This Wand is filled with mystical enegies.");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
        chargedIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "_charged");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        if (isCharged(dmg))
        {
            return chargedIcon;
        }
        else
        {
            return itemIcon;
        }
    }
    
    private boolean isCharged(int dmg)
    {
        return dmg>= 50;
    }
}
