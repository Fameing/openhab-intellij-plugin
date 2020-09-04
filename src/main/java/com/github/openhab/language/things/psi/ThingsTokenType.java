package com.github.openhab.language.things.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.github.openhab.language.things.ThingsLanguage;

public class ThingsTokenType extends IElementType {

    public ThingsTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ThingsLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "Things." + super.toString();
    }
}
