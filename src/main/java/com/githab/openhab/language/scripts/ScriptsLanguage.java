package com.githab.openhab.language.scripts;

import com.intellij.lang.Language;

public class ScriptsLanguage extends Language {
    public static final ScriptsLanguage INSTANCE = new ScriptsLanguage();

    private ScriptsLanguage() {
        super("Scripts");
    }
}