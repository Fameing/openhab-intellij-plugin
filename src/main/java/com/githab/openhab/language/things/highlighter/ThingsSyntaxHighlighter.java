package com.githab.openhab.language.things.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import com.githab.openhab.language.things.ThingsLexerAdapter;
import com.githab.openhab.language.things.psi.ThingsTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ThingsSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("THINGS_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey THINGS_KEYWORD =
            createTextAttributesKey("THINGS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("THINGS_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("THINGS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("THINGS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey COMMA =
            createTextAttributesKey("THINGS_COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey BINDING_ID =
            createTextAttributesKey("BINDING_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey TYPE_ID =
            createTextAttributesKey("TYPE_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey THING_ID =
            createTextAttributesKey("THING_ID", DefaultLanguageHighlighterColors.IDENTIFIER);


    private static final TextAttributesKey[] BINDING_ID_KEYS = new TextAttributesKey[]{BINDING_ID, TYPE_ID, THING_ID};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] THINGS_KEYWORD_KEYS = new TextAttributesKey[]{THINGS_KEYWORD};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
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
        } else if (tokenType.equals(ThingsTypes.BINDING_ID_KEYWORD_TYPE)||
                tokenType.equals(ThingsTypes.TYPE_ID_KEYWORD_TYPE)||
                tokenType.equals(ThingsTypes.THING_ID_KEYWORD_TYPE)) {
            return BINDING_ID_KEYS;
        } else if (tokenType.equals(ThingsTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(ThingsTypes.LABEL)) {
            return VALUE_KEYS;




        } else if (tokenType.equals(ThingsTypes.PARAMETER_KEY)) {
            return THINGS_KEYWORD_KEYS;
        } else if (tokenType.equals(ThingsTypes.PARAMETER_VALUE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
