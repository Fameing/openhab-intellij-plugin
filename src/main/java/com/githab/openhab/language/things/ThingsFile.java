package com.githab.openhab.language.things;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ThingsFile extends PsiFileBase {

    public ThingsFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ThingsLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ThingsFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Things File";
    }
}
