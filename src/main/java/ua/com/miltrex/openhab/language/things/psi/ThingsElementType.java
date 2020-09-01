package ua.com.miltrex.openhab.language.things.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ua.com.miltrex.openhab.language.things.ThingsLanguage;

public class ThingsElementType extends IElementType {
    public ThingsElementType(@NotNull @NonNls String debugName) {
        super(debugName, ThingsLanguage.INSTANCE);
    }
}
