package com.github.openhab.ide.actions;

import com.github.openhab.language.items.ItemsFileType;
import com.github.openhab.language.persist.PersistFileType;
import com.github.openhab.language.rules.RulesFileType;
import com.github.openhab.language.scripts.ScriptsFileType;
import com.github.openhab.language.services.ServicesFileType;
import com.github.openhab.language.sitemaps.SitemapsFileType;
import com.github.openhab.language.things.ThingsFileType;
import com.intellij.openapi.fileTypes.LanguageFileType;

public class OpenhabTemplates {
    public static final String OPENHAB_ITEMS = "Items file.items";
    public static final String OPENHAB_PERSIST = "Persistence file.persist";
    public static final String OPENHAB_RULES = "Rules file.rules";
    public static final String OPENHAB_SCRIPT = "Script file.script";
    public static final String OPENHAB_SERVICES = "Services file.services";
    public static final String OPENHAB_SITEMAPS = "Sitemap file.sitemap";
    public static final String OPENHAB_THINGS = "Things file.things";

    public static LanguageFileType findLanguageFileType(String templateName) {
        switch (templateName) {
            case OpenhabTemplates.OPENHAB_ITEMS:
                return ItemsFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_PERSIST:
                return PersistFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_RULES:
                return RulesFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_SCRIPT:
                return ScriptsFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_SERVICES:
                return ServicesFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_SITEMAPS:
                return SitemapsFileType.INSTANCE;
            case OpenhabTemplates.OPENHAB_THINGS:
                return ThingsFileType.INSTANCE;
        }
        return null;
    }
}
