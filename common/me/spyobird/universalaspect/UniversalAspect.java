package me.spyobird.universalaspect;

import me.spyobird.universalaspect.core.lib.configuration.ConfigHandler;
import me.spyobird.universalaspect.core.lib.creativetabs.CreativeTabInit;
import me.spyobird.universalaspect.core.lib.references.References;
import me.spyobird.universalaspect.core.proxies.common.CommonProxy;
import me.spyobird.universalaspect.core.util.CraftingManager;
import me.spyobird.universalaspect.core.util.TileEntityManager;
import me.spyobird.universalaspect.desi.block.DesiBlockInit;
import me.spyobird.universalaspect.magi.block.MagiBlockInit;
import me.spyobird.universalaspect.magi.item.MagiItemInit;
import me.spyobird.universalaspect.natu.ores.block.OresBlockInit;
import me.spyobird.universalaspect.natu.ores.item.OresItemInit;
import me.spyobird.universalaspect.tech.block.TechBlockInit;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class UniversalAspect
{
    @Instance(References.MOD_ID)
    public static UniversalAspect instance;
    
    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;
  
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        
        proxy.registerRenderers();                
        
        TechBlockInit.init();
        
        MagiBlockInit.init();
        MagiItemInit.init();
            
        OresBlockInit.init();
        OresItemInit.init();
        
        DesiBlockInit.init();
        
        TileEntityManager.init();
        
        CraftingManager.init();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        CreativeTabInit.names();
        
        TechBlockInit.names();
        
        MagiBlockInit.names();
        MagiItemInit.names();
            
        OresBlockInit.names();
        OresItemInit.names();
        
        DesiBlockInit.names();
    }
    
    @EventHandler
    public static void load(FMLPostInitializationEvent event)
    {
        System.out.println("The Universal Aspect is fully loaded.");
    }
}