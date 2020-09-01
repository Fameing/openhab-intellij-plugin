package ua.com.miltrex.openhab.language.things;

import com.intellij.lexer.FlexAdapter;
import ua.com.miltrex.openhab.language.things.ThingsLexer;

public class ThingsLexerAdapter extends FlexAdapter {
    public ThingsLexerAdapter() {
        super(new ThingsLexer(null));
    }
}
