package ua.com.miltrex.openhab.language.persist;

import com.intellij.lang.Language;

public class PersistLanguage extends Language {
    public static final PersistLanguage INSTANCE = new PersistLanguage();

    private PersistLanguage() {
        super("Persist");
    }
}