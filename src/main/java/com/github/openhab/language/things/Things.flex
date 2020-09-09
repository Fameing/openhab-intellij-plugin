package com.github.openhab.language.things;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.openhab.language.things.psi.ThingsTypes.*;

%%

%{
  public ThingsLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class ThingsLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%debug

%state WAITING_BINDING_ID, WAITING_TYPE_ID, WAITING_THING_ID, WAITING_PARAMETER_KEY, WAITING_PARAMETER_VALUE, WAITING_LOCATION
CRLF=\R
WHITE_SPACE=\s
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*

STRING_LITERAL=\"([^\"]|\"\")*\"
IDENTIFIER_STRING=[a-zA-Z][a-zA-Z0-9_-]*
NUMBER_LITERAL=[0-9]+

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+     { return WHITE_SPACE; }

    "Thing"                     { yybegin(WAITING_BINDING_ID); return THING_KEYWORD; }
    "Bridge"                    { yybegin(WAITING_BINDING_ID); return THING_KEYWORD; }

    ":"                         { return COLON; }
    "("                         { return LEFT_PAREN; }
    ")"                         { return RIGHT_PAREN; }
    "{"                         { return LEFT_BRACE; }
    "}"                         { return RIGHT_BRACE; }
    "["                         { yybegin(WAITING_PARAMETER_KEY); return LEFT_BRACKET; }
    "]"                         { return RIGHT_BRACKET; }
    "<"                         { return LESS_THAN; }
    ">"                         { return MORE_THAN; }
    "="                         { yybegin(WAITING_PARAMETER_VALUE); return EQUALS; }
    ","                         { yybegin(WAITING_PARAMETER_KEY); return COMMA; }
    "@"                         { yybegin(WAITING_LOCATION); return ET; }
    ":"                         { return COLON; }

    {STRING_LITERAL}            { return LABEL; }
    {END_OF_LINE_COMMENT}       { return COMMENT; }
    ({CRLF}|{WHITE_SPACE})+     { return WHITE_SPACE; }
}

<WAITING_BINDING_ID> {
    {IDENTIFIER_STRING}       { yybegin(WAITING_TYPE_ID); return BINDING_ID_KEYWORD; }
}

<WAITING_TYPE_ID> {
    {IDENTIFIER_STRING}       { yybegin(WAITING_THING_ID); return TYPE_ID_KEYWORD; }
}

<WAITING_THING_ID> {
    {IDENTIFIER_STRING}       { yybegin(YYINITIAL); return THING_ID_KEYWORD; }
}

<WAITING_LOCATION> {
    {STRING_LITERAL}         { yybegin(YYINITIAL); return LOCATION; }
}

<WAITING_PARAMETER_KEY> {
    {IDENTIFIER_STRING}       { yybegin(YYINITIAL); return PARAMETER_KEY; }
}

<WAITING_PARAMETER_VALUE> {
    {STRING_LITERAL}           { yybegin(YYINITIAL); return PARAMETER_STRING_VALUE; }
    {NUMBER_LITERAL}           { yybegin(YYINITIAL); return PARAMETER_NUMBER_VALUE; }
}

    [^]                        { return BAD_CHARACTER; }

