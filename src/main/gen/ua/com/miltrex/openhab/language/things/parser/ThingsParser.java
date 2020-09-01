// This is a generated file. Not intended for manual editing.
package ua.com.miltrex.openhab.language.things.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ua.com.miltrex.openhab.language.things.psi.ThingsTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ThingsParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return thingsFile(b, l + 1);
  }

  /* ********************************************************** */
  // BINDING_ID_KEYWORD_TYPE
  static boolean binding_id_keyword(PsiBuilder b, int l) {
    return consumeToken(b, BINDING_ID_KEYWORD_TYPE);
  }

  /* ********************************************************** */
  // binding_id_keyword COLON type_id_keyword COLON thing_id_keyword
  static boolean binding_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_type")) return false;
    if (!nextTokenIs(b, BINDING_ID_KEYWORD_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_id_keyword(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_id_keyword(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && thing_id_keyword(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARAMETER_KEY SEPARATOR PARAMETER_VALUE
  static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, PARAMETER_KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARAMETER_KEY, SEPARATOR, PARAMETER_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parameter (COMMA parameter_list)*
  static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, PARAMETER_KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameter_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA parameter_list)*
  private static boolean parameter_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_list_1", c)) break;
    }
    return true;
  }

  // COMMA parameter_list
  private static boolean parameter_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THING_ID_KEYWORD_TYPE
  static boolean thing_id_keyword(PsiBuilder b, int l) {
    return consumeToken(b, THING_ID_KEYWORD_TYPE);
  }

  /* ********************************************************** */
  // THING_KEYWORD_TYPE binding_type (LABEL)? '@'? (LOCATION)? LBRACKET parameter_list RBRACKET
  public static boolean thing_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thing_item")) return false;
    if (!nextTokenIs(b, THING_KEYWORD_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THING_KEYWORD_TYPE);
    r = r && binding_type(b, l + 1);
    r = r && thing_item_2(b, l + 1);
    r = r && thing_item_3(b, l + 1);
    r = r && thing_item_4(b, l + 1);
    r = r && consumeToken(b, LBRACKET);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, THING_ITEM, r);
    return r;
  }

  // (LABEL)?
  private static boolean thing_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thing_item_2")) return false;
    consumeToken(b, LABEL);
    return true;
  }

  // '@'?
  private static boolean thing_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thing_item_3")) return false;
    consumeToken(b, "@");
    return true;
  }

  // (LOCATION)?
  private static boolean thing_item_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thing_item_4")) return false;
    consumeToken(b, LOCATION);
    return true;
  }

  /* ********************************************************** */
  // things_*
  static boolean thingsFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thingsFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!things_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "thingsFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // thing_item|COMMENT|CRLF
  static boolean things_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "things_")) return false;
    boolean r;
    r = thing_item(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // TYPE_ID_KEYWORD_TYPE
  static boolean type_id_keyword(PsiBuilder b, int l) {
    return consumeToken(b, TYPE_ID_KEYWORD_TYPE);
  }

}
