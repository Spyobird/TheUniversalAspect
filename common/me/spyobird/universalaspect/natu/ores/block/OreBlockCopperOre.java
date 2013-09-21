package me.spyobird.universalaspect.natu.ores.block;

import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.natu.block.BlockUANATU;
import net.minecraft.block.material.Material;

public class OreBlockCopperOre extends BlockUANATU
{
    public OreBlockCopperOre(int id)
    {
        super(id, Material.rock);
        // TODO Auto-generated constructor stub
        this.setUnlocalizedName(Strings.ORE_COPPER_BLOCK_UNLOCAL);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(CreativeTabInit.tabsuniversalaspectmisc);
    }
}
