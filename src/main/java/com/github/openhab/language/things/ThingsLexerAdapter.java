package com.github.openhab.language.things;

import com.intellij.lexer.FlexAdapter;

public class ThingsLexerAdapter extends FlexAdapter {
    public ThingsLexerAdapter() {
        super(new ThingsLexer(null));
    }
}
