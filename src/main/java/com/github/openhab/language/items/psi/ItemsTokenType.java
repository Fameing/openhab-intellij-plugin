package com.github.openhab.language.items.psi;

import com.github.openhab.language.items.ItemsLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ItemsTokenType extends IElementType {
    public ItemsTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ItemsLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "Items." + super.toString();
    }
}
