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

CrLf=\r|\n|\r\n
WhiteSpace=[\ \t\f]+

_MultiLineSeparator=\\\R
// Dot (.) matches [^\r\n\u2028\u2029\u000B\u000C\u0085]
// see https://jflex.de/manual.html#Semantics
_EscapedSymbol=\\.
_NonCrLf=([^\r\n\\]|{_MultiLineSeparator}|{_EscapedSymbol})

QuotedText=\" [^\"\r\n]* \"?
UnquotedText=[^\s\"\r\n]+

LineComment=("//"|"#") {_NonCrLf}*
BlockComment="/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

ScriptText=[^\r\n{}]+

%%

<YYINITIAL,EXPECT_NON_COMMENT,EXPECT_SCRIPT_ARGUMENTS> {
{WhiteSpace}             { return WHITE_SPACE; }
^{WhiteSpace}? {CrLf}    { return WHITE_SPACE; }
}

<YYINITIAL> {
{BlockComment}           { return BLOCK_COMMENT; }
{LineComment}            { return LINE_COMMENT; }

[^]                      { yypushback(yytext().length()); yybegin(EXPECT_NON_COMMENT); }
}

<EXPECT_NON_COMMENT> {
"{"                      { return BRACE1; }
"}"                      { return BRACE2; }
"{}"                     { yypushback(1); return BRACE1;}
"="                      { return EQUALS; }
"->"                     { return ARROW; }

"!script"                { yybegin(EXPECT_SCRIPT_ARGUMENTS); return UNQUOTED_TEXT; }

{QuotedText}             { return QUOTED_TEXT; }
{UnquotedText}           { return UNQUOTED_TEXT; }

{CrLf}                   { yybegin(YYINITIAL); return CRLF; }
}

<EXPECT_SCRIPT_ARGUMENTS> {
"{"                { startScript(); return BRACE1; }
{QuotedText}       { return QUOTED_TEXT; }
{UnquotedText}     { return UNQUOTED_TEXT; }
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
{CrLf}             { }
{ScriptText}       { }
}

[^]                      { return BAD_CHARACTER; }
