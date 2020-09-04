package com.github.openhab.language.things.highlighter;

import com.github.openhab.language.things.ThingsLexerAdapter;
import com.github.openhab.language.things.psi.ThingsTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ThingsSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("THINGS_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("THINGS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey THINGS_KEYWORD = createTextAttributesKey("THINGS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);


    public static final TextAttributesKey PARAMETER_KEY = createTextAttributesKey("PARAMETER_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING_PARAMETER_VALUE = createTextAttributesKey("STRING_PARAMETER_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER_PARAMETER_VALUE = createTextAttributesKey("NUMBER_PARAMETER_VALUE", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey LABEL = createTextAttributesKey("LABEL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey LOCATION = createTextAttributesKey("LOCATION", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey COMMENT = createTextAttributesKey("THINGS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("THINGS_COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey BINDING_ID = createTextAttributesKey("BINDING_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey TYPE_ID = createTextAttributesKey("TYPE_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey THING_ID = createTextAttributesKey("THING_ID", DefaultLanguageHighlighterColors.IDENTIFIER);


    public static final TextAttributesKey BRACKETS = createTextAttributesKey("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BINDING_SEPARATOR = createTextAttributesKey("BINDING_SEPARATOR", DefaultLanguageHighlighterColors.SEMICOLON);


    private static final TextAttributesKey[] BINDING_ID_KEYS = new TextAttributesKey[]{BINDING_ID, TYPE_ID, THING_ID};
    private static final TextAttributesKey[] BINDING_SEPARATOR_KEYS = new TextAttributesKey[]{BINDING_SEPARATOR};
    private static final TextAttributesKey[] STRING_PARAMETER_VALUE_KEYS = new TextAttributesKey[]{STRING_PARAMETER_VALUE};
    private static final TextAttributesKey[] NUMBER_PARAMETER_VALUE_KEYS = new TextAttributesKey[]{NUMBER_PARAMETER_VALUE};
    private static final TextAttributesKey[] PARAMETER_KEY_KEYS = new TextAttributesKey[]{PARAMETER_KEY};
    private static final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] LOCATION_KEYS = new TextAttributesKey[]{LOCATION};

    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKETS};

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] THINGS_KEYWORD_KEYS = new TextAttributesKey[]{THINGS_KEYWORD};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ThingsLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ThingsTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(ThingsTypes.THING_KEYWORD_TYPE)) {
            return THINGS_KEYWORD_KEYS;
        } else if (tokenType.equals(ThingsTypes.BINDING_ID_KEYWORD_TYPE) ||
                tokenType.equals(ThingsTypes.TYPE_ID_KEYWORD_TYPE) ||
                tokenType.equals(ThingsTypes.THING_ID_KEYWORD_TYPE)) {
            return BINDING_ID_KEYS;
        } else if (tokenType.equals(ThingsTypes.COLON)) {
            return BINDING_SEPARATOR_KEYS;
        } else if (tokenType.equals(ThingsTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(ThingsTypes.LABEL)) {
            return LABEL_KEYS;
        } else if (tokenType.equals(ThingsTypes.LOCATION)) {
            return LOCATION_KEYS;
        } else if (tokenType.equals(ThingsTypes.PARAMETER_KEY)) {
            return PARAMETER_KEY_KEYS;
        } else if (tokenType.equals(ThingsTypes.STRING_PARAMETER_VALUE)) {
            return STRING_PARAMETER_VALUE_KEYS;
        } else if (tokenType.equals(ThingsTypes.NUMBER_PARAMETER_VALUE)) {
            return NUMBER_PARAMETER_VALUE_KEYS;
        } else if (tokenType.equals(ThingsTypes.LBRACKET) || tokenType.equals(ThingsTypes.RBRACKET)) {
            return BRACKET_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
