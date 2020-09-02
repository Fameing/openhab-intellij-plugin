package com.githab.openhab.language;

import com.intellij.CommonBundle;
import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

public class OpenhabBundle {
    /** Gitignore plugin ID. */
    @NonNls
    public static final String PLUGIN_ID = "com.githab.openhab";

    /** The {@link java.util.ResourceBundle} path. */
    @NonNls
    private static final String BUNDLE_NAME = "messages.OpenhabBundle";

    /** The {@link java.util.ResourceBundle} instance. */
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    /** Plugin name. */
    @NonNls
    public static final String NAME = "OpenHab";

    /** {@link OpenhabBundle} is a non-instantiable static class. */
    private OpenhabBundle() {
    }

    /**
     * Loads a {@link String} from the {@link #BUNDLE} {@link java.util.ResourceBundle}.
     *
     * @param key    the key of the resource
     * @param params the optional parameters for the specific resource
     * @return the {@link String} value or {@code null} if no resource found for the key
     */
    public static String message(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object... params) {
        return DynamicBundle.message(BUNDLE, key, params);
    }

    /**
     * Loads a {@link String} from the {@link #BUNDLE} {@link java.util.ResourceBundle}.
     *
     * @param key          the key of the resource
     * @param defaultValue the default value that will be returned if there is nothing set
     * @param params       the optional parameters for the specific resource
     * @return the {@link String} value or {@code null} if no resource found for the key
     */
    public static String messageOrDefault(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, String defaultValue, Object... params) {
        return DynamicBundle.messageOrDefault(BUNDLE, key, defaultValue, params);
    }

}
