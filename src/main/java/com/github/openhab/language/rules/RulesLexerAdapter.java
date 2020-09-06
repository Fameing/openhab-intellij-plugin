package com.github.openhab.language.rules;

import com.intellij.lexer.FlexAdapter;

public class RulesLexerAdapter extends FlexAdapter {
    public RulesLexerAdapter() {
        super(new RulesLexer());
    }
}
