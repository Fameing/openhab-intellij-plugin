package com.github.openhab.language.things;

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

%state WAITING_BINDING_ID, WAITING_TYPE_ID, WAITING_THING_ID, WAITING_PARAMETER_KEY, WAITING_PARAMETER_VALUE, WAITING_LOCATION, WAITING_LABEL
CRLF=\R
WHITE_SPACE=\s+
SEPARATOR=[=]
BINDING_KEYWORD_TYPE=\w+
KEY=\w+
STRING_PARAMETER_VALUE=\"([^\\\"\r\n]|\\[^\r\n])*\"?
NUMBER_PARAMETER_VALUE=\d+
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*

%%
<YYINITIAL> {
  "Thing"                      { yybegin(WAITING_BINDING_ID); return THING_KEYWORD_TYPE; }
  "Bridge"                     { yybegin(WAITING_BINDING_ID); return THING_KEYWORD_TYPE; }
  "["                          { yybegin(WAITING_PARAMETER_KEY); return LBRACKET; }
  "]"                          { return RBRACKET; }
  ","                          { yybegin(WAITING_PARAMETER_KEY); return COMMA; }
  "@"                          { yybegin(WAITING_LOCATION); return ET; }

  {SEPARATOR}                  { yybegin(WAITING_PARAMETER_VALUE); return SEPARATOR; }
  {END_OF_LINE_COMMENT}        { return COMMENT; }
  {WHITE_SPACE}                { return WHITE_SPACE; }
}


 <WAITING_BINDING_ID> {
    {WHITE_SPACE}             { yybegin(WAITING_BINDING_ID); return WHITE_SPACE; }
    {BINDING_KEYWORD_TYPE}    { yybegin(WAITING_TYPE_ID); return BINDING_ID_KEYWORD_TYPE; }
 }
 <WAITING_TYPE_ID> {
    ":"                       { yybegin(WAITING_TYPE_ID); return COLON; }
    {BINDING_KEYWORD_TYPE}    { yybegin(WAITING_THING_ID); return TYPE_ID_KEYWORD_TYPE; }
 }
 <WAITING_THING_ID> {
    ":"                       { yybegin(WAITING_THING_ID); return COLON; }
    {BINDING_KEYWORD_TYPE}    { yybegin(WAITING_LABEL); return THING_ID_KEYWORD_TYPE; }
 }

 <WAITING_LABEL> {
     {WHITE_SPACE}            { yybegin(WAITING_LABEL); return WHITE_SPACE; }
     {STRING_PARAMETER_VALUE} { yybegin(YYINITIAL); return LABEL; }
 }

 <WAITING_LOCATION> {
     {WHITE_SPACE}            { yybegin(WAITING_LOCATION); return WHITE_SPACE; }
     {STRING_PARAMETER_VALUE} { yybegin(YYINITIAL); return LOCATION; }
  }

 <WAITING_PARAMETER_KEY> {
    {WHITE_SPACE}             { yybegin(WAITING_PARAMETER_KEY); return WHITE_SPACE; }
    {KEY}                     { yybegin(YYINITIAL); return PARAMETER_KEY; }
 }

 <WAITING_PARAMETER_VALUE> {
   {WHITE_SPACE}              { yybegin(WAITING_PARAMETER_VALUE); return WHITE_SPACE; }
   {STRING_PARAMETER_VALUE}   { yybegin(YYINITIAL); return STRING_PARAMETER_VALUE; }
   {NUMBER_PARAMETER_VALUE}   { yybegin(YYINITIAL); return NUMBER_PARAMETER_VALUE; }
 }

 ({CRLF}|{WHITE_SPACE})+      { return WHITE_SPACE; }

 [^] { return BAD_CHARACTER; }

