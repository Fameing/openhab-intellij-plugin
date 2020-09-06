package com.github.openhab.language.items;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ItemsFile extends PsiFileBase {
    public ItemsFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ItemsLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ItemsFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Items File";
    }
}
