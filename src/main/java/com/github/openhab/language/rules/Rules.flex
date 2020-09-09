package com.github.openhab.language.rules;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.openhab.language.rules.psi.RulesTypes.*;

%%

%{
  public RulesLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class RulesLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%debug

CRLF=\R
WHITE_SPACE=\s
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
STRING_LITERAL=\"([^\"]|\"\")*\"
IDENTIFIER_STRING=[a-zA-Z][a-zA-Z0-9_-]*
NUMBER_LITERAL=[0-9]+

// Number Livingroom_Temperature "Temperature [%.1f °C]" <temperature> (gTemperature, gLivingroom) ["TargetTemperature"] {knx="1/0/15+0/0/15"}

%%
 <YYINITIAL> {
   "("                        { return LEFT_PAREN; }
   ")"                        { return RIGHT_PAREN; }
   "{"                        { return LEFT_BRACE; }
   "}"                        { return RIGHT_BRACE; }
   "["                        { return LEFT_BRACKET; }
   "]"                        { return RIGHT_BRACKET; }
   "<"                        { return LESS_THAN; }
   ">"                        { return MORE_THAN; }
   "="                        { return EQUALS; }
   ","                        { return COMMA; }
   {STRING_LITERAL}           { return STRING_LITERAL; }
   {IDENTIFIER_STRING}        { return IDENTIFIER_STRING; }
   {NUMBER_LITERAL}           { return NUMBER_LITERAL; }

   {END_OF_LINE_COMMENT}      { return COMMENT; }
   ({CRLF}|{WHITE_SPACE})+    { return WHITE_SPACE; }
 }

 [^] { return BAD_CHARACTER; }

