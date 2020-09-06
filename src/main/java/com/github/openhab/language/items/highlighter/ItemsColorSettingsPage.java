package com.github.openhab.language.items.highlighter;

import com.github.openhab.language.items.ItemsIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ItemsColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Items Keyword", ItemsSyntaxHighlighter.ITEMS_KEYWORD),
            new AttributesDescriptor("Binding Separator", ItemsSyntaxHighlighter.BINDING_SEPARATOR),
            new AttributesDescriptor("Bracket", ItemsSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Label", ItemsSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Parameter Key", ItemsSyntaxHighlighter.PARAMETER_KEY),
            new AttributesDescriptor("Separator", ItemsSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Parameter Value String", ItemsSyntaxHighlighter.PARAMETER_STRING_VALUE),
            new AttributesDescriptor("Parameter Value Number", ItemsSyntaxHighlighter.PARAMETER_NUMBER_VALUE),
            new AttributesDescriptor("Bad Value", ItemsSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return ItemsIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ItemsSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "Number Livingroom_Temperature \"Temperature [%.1f °C]\" <temperature> (gTemperature, gLivingroom) [\"TargetTemperature\", \"dasdf\"] {knx=\"1/0/15+0/0/15\", ccc=35}";
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
        return "Items";
    }
}
