package com.github.openhab.language.things.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.github.openhab.language.things.ThingsIcons;

import javax.swing.*;
import java.util.Map;

public class ThingsColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Things Keyword", ThingsSyntaxHighlighter.THINGS_KEYWORD),
            new AttributesDescriptor("Binding Id", ThingsSyntaxHighlighter.BINDING_ID),
            new AttributesDescriptor("Binding Separator", ThingsSyntaxHighlighter.BINDING_SEPARATOR),
            new AttributesDescriptor("Bracket", ThingsSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Label", ThingsSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Location", ThingsSyntaxHighlighter.LOCATION),
            new AttributesDescriptor("Parameter Key", ThingsSyntaxHighlighter.PARAMETER_KEY),
            new AttributesDescriptor("Separator", ThingsSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Parameter Value String", ThingsSyntaxHighlighter.STRING_PARAMETER_VALUE),
            new AttributesDescriptor("Parameter Value Number", ThingsSyntaxHighlighter.NUMBER_PARAMETER_VALUE),
            new AttributesDescriptor("Bad Value", ThingsSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return ThingsIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ThingsSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "Thing network:device:webcam \"Webcam\" @ \"Living Room\" [ hostname=\"192.168.0.2\", port=2234, timeout=5000 ]";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Things";
    }
}
