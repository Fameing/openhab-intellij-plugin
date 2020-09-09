package com.github.openhab.language.rules.highlighter;

import com.github.openhab.language.rules.RulesIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class RulesColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Things Keyword", RulesSyntaxHighlighter.THINGS_KEYWORD),
            new AttributesDescriptor("Binding Id", RulesSyntaxHighlighter.BINDING_ID),
            new AttributesDescriptor("Binding Separator", RulesSyntaxHighlighter.BINDING_SEPARATOR),
            new AttributesDescriptor("Bracket", RulesSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Label", RulesSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Location", RulesSyntaxHighlighter.LOCATION),
            new AttributesDescriptor("Parameter Key", RulesSyntaxHighlighter.PARAMETER_KEY),
            new AttributesDescriptor("Separator", RulesSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Parameter Value String", RulesSyntaxHighlighter.STRING_PARAMETER_VALUE),
            new AttributesDescriptor("Parameter Value Number", RulesSyntaxHighlighter.NUMBER_PARAMETER_VALUE),
            new AttributesDescriptor("Bad Value", RulesSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return RulesIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new RulesSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "rule \"Speedtest init\"\n" +
                "when\n" +
                "    System started\n" +
                "then\n" +
                "    createTimer(now.plusSeconds(30), [|\n" +
                "        if (Speedtest_Summary.state == NULL || Speedtest_Summary.state == \"\") Speedtest_Summary.postUpdate(\"unknown\")\n" +
                "    ])\n" +
                "end";
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
        return "Rules";
    }
}
