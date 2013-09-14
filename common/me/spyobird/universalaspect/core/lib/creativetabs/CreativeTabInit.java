package me.spyobird.universalaspect.core.lib.creativetabs;

import me.spyobird.universalaspect.core.lib.references.Strings;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTabInit
{
    public static CreativeTabUA tabsuniversalaspectmisc = new CreativeTabUAMISC(CreativeTabs.getNextID(), Strings.UAMISC_TABS_DEFAULT);
    public static CreativeTabUA tabsuniversalaspecttech = new CreativeTabUATECH(CreativeTabs.getNextID(), Strings.UATECH_TABS_DEFAULT);
    public static CreativeTabUA tabsuniversalaspectmagi = new CreativeTabUAMAGI(CreativeTabs.getNextID(), Strings.UAMAGI_TABS_DEFAULT);
    public static CreativeTabUA tabsuniversalaspectnatu = new CreativeTabUANATU(CreativeTabs.getNextID(), Strings.UANATU_TABS_DEFAULT);
    public static CreativeTabUA tabsuniversalaspectdesi = new CreativeTabUADESI(CreativeTabs.getNextID(), Strings.UADESI_TABS_DEFAULT);
    
    public static void init()
    {
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Strings.UAMISC_TABS_DEFAULT, "en_US", Strings.UAMISC_TABS_LOCAL);
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Strings.UATECH_TABS_DEFAULT, "en_US", Strings.UATECH_TABS_LOCAL);
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Strings.UAMAGI_TABS_DEFAULT, "en_US", Strings.UAMAGI_TABS_LOCAL);
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Strings.UANATU_TABS_DEFAULT, "en_US", Strings.UANATU_TABS_LOCAL);
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Strings.UADESI_TABS_DEFAULT, "en_US", Strings.UADESI_TABS_LOCAL);
    }
}
