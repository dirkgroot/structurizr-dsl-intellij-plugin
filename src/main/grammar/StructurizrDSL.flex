package nl.dirkgroot.structurizr.dsl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.dirkgroot.structurizr.dsl.psi.SDTypes.*;

%%

%{
    public StructurizrDSLLexer() {
        this(null);
    }

    private void startScript() {
        braces = 0;
        yybegin(EXPECT_SCRIPT);
    }

    private void endScript() {
        braces = 0;
        yybegin(YYINITIAL);
    }
%}

%{
    private int braces = 0;
%}

%ignorecase
%public
%class StructurizrDSLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state EXPECT_NON_COMMENT
%state EXPECT_SCRIPT_ARGUMENTS
%state EXPECT_SCRIPT

CRLF=\r|\n|\r\n
WHITE_SPACE=[\ \t\f]+

QUOTED_TEXT=\" [^\"\r\n]* \"?
UNQUOTED_TEXT=[^\s\"\r\n{}]+

LINE_COMMENT=("//"|"#") [^\r\n]*
BLOCK_COMMENT="/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

SCRIPT_TEXT=[^\r\n{}]+

%%

<YYINITIAL,EXPECT_NON_COMMENT,EXPECT_SCRIPT_ARGUMENTS> {
{WHITE_SPACE}            { return WHITE_SPACE; }
^{WHITE_SPACE}? {CRLF}   { return WHITE_SPACE; }
}

<YYINITIAL> {
{BLOCK_COMMENT}          { return BLOCK_COMMENT; }
{LINE_COMMENT}           { return LINE_COMMENT; }

[^]                      { yypushback(yytext().length()); yybegin(EXPECT_NON_COMMENT); }
}

<EXPECT_NON_COMMENT> {
"{"                      { return BRACE1; }
"}"                      { return BRACE2; }
"="                      { return EQUALS; }
"->"                     { return ARROW; }

"!script"                { yybegin(EXPECT_SCRIPT_ARGUMENTS); return UNQUOTED_TEXT; }

{QUOTED_TEXT}            { return QUOTED_TEXT; }
{UNQUOTED_TEXT}          { return UNQUOTED_TEXT; }

{CRLF}                   { yybegin(YYINITIAL); return CRLF; }
}

<EXPECT_SCRIPT_ARGUMENTS> {
"{"                { startScript(); return BRACE1; }
{QUOTED_TEXT}      { return QUOTED_TEXT; }
{UNQUOTED_TEXT}    { return UNQUOTED_TEXT; }
[^]                { yybegin(YYINITIAL); yypushback(yytext().length()); }
}

<EXPECT_SCRIPT> {
"{"                { braces++; }
"}"                {
                     if (braces == 0) {
                         endScript();
                         yypushback(1);
                         return SCRIPT_TEXT;
                     }
                     braces--;
                   }
{CRLF}             { }
{SCRIPT_TEXT}      { }
}

[^]                      { return BAD_CHARACTER; }
