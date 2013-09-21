package me.spyobird.universalaspect.magi.block;

import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagiBlockCardReader extends BlockUAMAGI
{
    @SideOnly(Side.CLIENT)
    public static final String[] blocktypes = new String[] { "blank", "fire", "water", "earth", "air", "arcane", "ominous" };
    
    @SideOnly(Side.CLIENT)
    private Icon[] blockIcons;
    
    public MagiBlockCardReader(int id)
    {
        super(id, Material.wood);
        // TODO Auto-generated constructor stub
        this.setUnlocalizedName(Strings.CARD_READER_BLOCK_UNLOCAL);
        this.setHardness(2.5F);
        this.setResistance(6.0F);
        this.setStepSound(soundStoneFootstep);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcons = new Icon[blocktypes.length];
        
        for (int i = 0; i < blocktypes.length; i++)
        {
            blockIcons[i] = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), this.getUnlocalizedName().substring(5) + "_" + blocktypes[i]));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        return blockIcons[meta]; 
    }
}
