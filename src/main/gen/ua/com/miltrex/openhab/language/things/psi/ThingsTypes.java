// This is a generated file. Not intended for manual editing.
package ua.com.miltrex.openhab.language.things.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ua.com.miltrex.openhab.language.things.psi.impl.*;

public interface ThingsTypes {

  IElementType THING_ITEM = new ThingsElementType("THING_ITEM");

  IElementType BINDING_ID_KEYWORD_TYPE = new ThingsTokenType("BINDING_ID_KEYWORD_TYPE");
  IElementType COLON = new ThingsTokenType("COLON");
  IElementType COMMA = new ThingsTokenType("COMMA");
  IElementType COMMENT = new ThingsTokenType("COMMENT");
  IElementType CRLF = new ThingsTokenType("CRLF");
  IElementType LABEL = new ThingsTokenType("LABEL");
  IElementType LBRACKET = new ThingsTokenType("LBRACKET");
  IElementType LOCATION = new ThingsTokenType("LOCATION");
  IElementType PARAMETER_KEY = new ThingsTokenType("PARAMETER_KEY");
  IElementType PARAMETER_VALUE = new ThingsTokenType("PARAMETER_VALUE");
  IElementType RBRACKET = new ThingsTokenType("RBRACKET");
  IElementType SEPARATOR = new ThingsTokenType("SEPARATOR");
  IElementType THING_ID_KEYWORD_TYPE = new ThingsTokenType("THING_ID_KEYWORD_TYPE");
  IElementType THING_KEYWORD_TYPE = new ThingsTokenType("THING_KEYWORD_TYPE");
  IElementType TYPE_ID_KEYWORD_TYPE = new ThingsTokenType("TYPE_ID_KEYWORD_TYPE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == THING_ITEM) {
        return new ThingsThingItemImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
