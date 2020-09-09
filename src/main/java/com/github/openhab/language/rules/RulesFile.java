package com.github.openhab.language.rules;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class RulesFile extends PsiFileBase {
    public RulesFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RulesLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RulesFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Rules File";
    }
}
