package me.spyobird.universalaspect.core.lib.references;

public class References
{
    // Debug Mode
    public static final boolean DEBUG_MODE = false;
    
    // General References
    public static final String MOD_ID = "UniversalAspect";
    public static final String MOD_NAME = "The Universal Aspect";
    public static final String VERSION = "v0.1.0";
    public static final String DEPENDENCIES = "required-after:Forge@[7.7.1.650,)";
    public static final int TICKS_SECOND = 20;
    
    // Proxies
    public static final String SERVER_PROXY = "me.spyobird.universalaspect.core.proxies.client.ClientProxy";
    public static final String CLIENT_PROXY = "me.spyobird.universalaspect.core.proxies.common.CommonProxy";
    
    public static final int ORE_DICTIONARY_NOT_FOUND = -1;
}
