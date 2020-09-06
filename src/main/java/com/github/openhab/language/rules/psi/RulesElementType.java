package com.github.openhab.language.rules.psi;

import com.github.openhab.language.rules.RulesLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RulesElementType extends IElementType {
    public RulesElementType(@NotNull @NonNls String debugName) {
        super(debugName, RulesLanguage.INSTANCE);
    }
}