package com.github.openhab.language.rules;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RulesFileType extends LanguageFileType {
    public static final RulesFileType INSTANCE = new RulesFileType();

    private RulesFileType() {
        super(RulesLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Openhab Rules File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Rules language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "rules";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return RulesIcons.FILE;
    }
}
