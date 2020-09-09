package com.github.openhab.language.items.highlighter;

import com.github.openhab.language.items.ItemsLexerAdapter;
import com.github.openhab.language.items.psi.ItemsTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ItemsSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("ITEMS_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("ITEMS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey ITEMS_KEYWORD = createTextAttributesKey("ITEMS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);


    public static final TextAttributesKey PARAMETER_KEY = createTextAttributesKey("PARAMETER_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey PARAMETER_STRING_VALUE = createTextAttributesKey("STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey PARAMETER_NUMBER_VALUE = createTextAttributesKey("NUMBER_LITERAL", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey LABEL = createTextAttributesKey("LABEL", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey COMMENT = createTextAttributesKey("ITEMS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("ITEMS_COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey BRACKETS = createTextAttributesKey("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BINDING_SEPARATOR = createTextAttributesKey("BINDING_SEPARATOR", DefaultLanguageHighlighterColors.SEMICOLON);


    private static final TextAttributesKey[] PARAMETER_KEY_KEYS = new TextAttributesKey[]{PARAMETER_KEY};
    private static final TextAttributesKey[] PARAMETER_VALUE_KEYS = new TextAttributesKey[]{PARAMETER_STRING_VALUE, PARAMETER_NUMBER_VALUE};
    private static final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKETS};

    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ItemsLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ItemsTypes.EQUALS)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(ItemsTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(ItemsTypes.STRING_LITERAL) || tokenType.equals(ItemsTypes.NUMBER_LITERAL)) {
            return PARAMETER_VALUE_KEYS;
        } else if (tokenType.equals(ItemsTypes.LABEL)) {
            return LABEL_KEYS;
        } else if (tokenType.equals(ItemsTypes.PARAMETER_KEY)) {
            return PARAMETER_KEY_KEYS;
        } else if (tokenType.equals(ItemsTypes.LEFT_BRACKET) || tokenType.equals(ItemsTypes.RIGHT_BRACKET)) {
            return BRACKET_KEYS;
        } else if (tokenType.equals(ItemsTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
