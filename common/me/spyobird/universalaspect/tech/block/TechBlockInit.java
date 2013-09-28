package me.spyobird.universalaspect.tech.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.Integers;
import me.spyobird.universalaspect.core.lib.references.Strings;
import me.spyobird.universalaspect.tech.block.machine.TechBlockMachineGrinder;
import net.minecraft.block.Block;
import net.minecraft.util.EnumChatFormatting;

public class TechBlockInit
{
    public static Block GrinderMachine;
    public static Block GrinderMachineActive;
    public static Block SonicTNT;
    
    public static void init()
    {
        GrinderMachine = new TechBlockMachineGrinder(Integers.MACHINE_GRINDER_BLOCK_ID, false).setUnlocalizedName(Strings.MACHINE_GRINDER_BLOCK_UNLOCAL);
        GrinderMachineActive = new TechBlockMachineGrinder(Integers.MACHINE_GRINDER_BLOCK_ACTIVE_ID, true).setUnlocalizedName(Strings.MACHINE_GRINDER_BLOCK_ACTIVE_UNLOCAL).setCreativeTab(CreativeTabInit.tabsuniversalaspectmisc);
        SonicTNT = new TechBlockSonicTNT(Integers.SONIC_TNT_BLOCK_ID);
        
        GameRegistry.registerBlock(GrinderMachine, Strings.MACHINE_GRINDER_BLOCK_UNLOCAL);
        GameRegistry.registerBlock(GrinderMachineActive, Strings.MACHINE_GRINDER_BLOCK_ACTIVE_UNLOCAL);
        GameRegistry.registerBlock(SonicTNT, Strings.SONIC_TNT_BLOCK_UNLOCAL);
    }
    
    public static void names()
    {
        LanguageRegistry.addName(GrinderMachine, Strings.MACHINE_GRINDER_BLOCK_LOCAL);
        LanguageRegistry.addName(GrinderMachineActive, EnumChatFormatting.RED + Strings.MACHINE_GRINDER_BLOCK_LOCAL + " (ACTIVE, UTIL BLOCK, ID = 501)");
        LanguageRegistry.addName(SonicTNT, Strings.SONIC_TNT_BLOCK_LOCAL);
    }
}
