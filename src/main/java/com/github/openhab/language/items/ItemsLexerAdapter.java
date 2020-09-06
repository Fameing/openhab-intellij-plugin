package com.github.openhab.language.items;

import com.intellij.lexer.FlexAdapter;

public class ItemsLexerAdapter extends FlexAdapter {
    public ItemsLexerAdapter() {
        super(new ItemsLexer());
    }
}
