package com.github.openhab.language.items;

import com.intellij.lang.Language;

public class ItemsLanguage extends Language {
    public static final ItemsLanguage INSTANCE = new ItemsLanguage();

    private ItemsLanguage() {
        super("Items");
    }
}