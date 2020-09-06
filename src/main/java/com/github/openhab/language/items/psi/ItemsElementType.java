package com.github.openhab.language.items.psi;

import com.github.openhab.language.items.ItemsLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ItemsElementType extends IElementType {
    public ItemsElementType(@NotNull @NonNls String debugName) {
        super(debugName, ItemsLanguage.INSTANCE);
    }
}
