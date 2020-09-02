package com.githab.openhab;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

public class OpenhabBundle extends AbstractBundle {
    @NonNls
    private static final String BUNDLE_NAME = "messages.OpenhabBundle";

    private static final OpenhabBundle INSTANCE = new OpenhabBundle();

    protected OpenhabBundle() {
        super(BUNDLE_NAME);
    }

    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE_NAME) String key, @NotNull Object... params) {
        return INSTANCE.getMessage(key, params);
    }
}
