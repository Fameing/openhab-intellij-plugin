package ua.com.miltrex.openhab.language.things;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static ua.com.miltrex.openhab.language.things.psi.ThingsTypes.*;

%%
%public
%class ThingsLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%debug
//%eof{  return;
//%eof}

%state WAITING_BINDING_ID, WAITING_TYPE_ID, WAITING_THING_ID, WAITING_LABEL, WAITING_LOCATION, WAITING_PARAMETER_KEY, WAITING_PARAMETER_VALUE
CRLF=\R
WHITE_SPACE=\s+
SEPARATOR=[=]
BINDING_KEYWORD_TYPE=\w+
KEY=\w+
VALUE=[\"][\w]+[\"]|\d+
LOCATION=(\?<=")[\s\S]+?(\?=")
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*

%%
<YYINITIAL> {
  "Thing"                      { yybegin(WAITING_BINDING_ID); return THING_KEYWORD_TYPE; }
  "Bridge"                     { yybegin(WAITING_BINDING_ID); return THING_KEYWORD_TYPE; }
  "["                          { yybegin(WAITING_PARAMETER_KEY); return LBRACKET; }
  "]"                          { return RBRACKET; }
  ","                          { yybegin(WAITING_PARAMETER_KEY); return COMMA; }
  {SEPARATOR}                  { yybegin(WAITING_PARAMETER_VALUE); return SEPARATOR; }
  //{VALUE}                      { yybegin(WAITING_PARAMETER_LABEL); return LABEL; }
  //{LOCATION}                   { return LOCATION; }

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
    {BINDING_KEYWORD_TYPE}    { yybegin(YYINITIAL); return THING_ID_KEYWORD_TYPE; }
 }

 <WAITING_PARAMETER_KEY> {
    {WHITE_SPACE}             { yybegin(WAITING_PARAMETER_KEY); return WHITE_SPACE; }
    {KEY}                     { yybegin(YYINITIAL); return PARAMETER_KEY; }
 }

 <WAITING_PARAMETER_VALUE> {
   {WHITE_SPACE}              { yybegin(WAITING_PARAMETER_VALUE); return WHITE_SPACE; }
   {VALUE}                    { yybegin(YYINITIAL); return PARAMETER_VALUE; }
 }

 ({CRLF}|{WHITE_SPACE})+      { return WHITE_SPACE; }

 [^] { return BAD_CHARACTER; }

