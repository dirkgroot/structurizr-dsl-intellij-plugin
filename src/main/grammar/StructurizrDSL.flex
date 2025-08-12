package nl.dirkgroot.structurizr.dsl;

import com.intellij.lexer.FlexLexer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static nl.dirkgroot.structurizr.dsl.psi.SDTypes.*;

%%

%{
    public StructurizrDSLLexer() {
        this(null);
    }
%}

%ignorecase
%public
%class StructurizrDSLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state EXPECT_NON_COMMENT EXPECT_SCRIPT_ARGUMENTS
%xstate BLOCK_COMMENT_BODY EXPECT_SCRIPT

EOL=[\r\n]
NonEOL=[^{EOL}]
CrLf=\r\n|{EOL}
Space=[\p{Whitespace}--{EOL}]
MultiLineSeparator=\\{CrLf}
SpaceOrMultiLineSeparator=({Space}|{MultiLineSeparator})
WhiteSpace={SpaceOrMultiLineSeparator}+
MultiLineSeparatorsWithSpaces={MultiLineSeparator}{SpaceOrMultiLineSeparator}*
WhiteSpaceWithNewLines=({CrLf}|{SpaceOrMultiLineSeparator})+

EscapedSymbol=\\\S
EscapeOrMultiLineSeparator={EscapedSymbol}|{MultiLineSeparator}
NonCrLf=({EscapeOrMultiLineSeparator}|{NonEOL})

QuotedText=\" ({EscapeOrMultiLineSeparator}|[{NonEOL}--[\"]])* \"?
UnquotedText=({EscapedSymbol}|[^\s\"])({MultiLineSeparatorsWithSpaces}?({EscapedSymbol}|\S))*

LineComment=("/"{MultiLineSeparatorsWithSpaces}?"/"|"#") {NonCrLf}*
BlockCommentStart="/"{MultiLineSeparatorsWithSpaces}?"*"
BlockCommentEnd="*"{MultiLineSeparatorsWithSpaces}?"/"

ScriptText=({EscapeOrMultiLineSeparator}|{NonEOL})

Arrow=-{MultiLineSeparatorsWithSpaces}?>
%%

// XSTATES

<BLOCK_COMMENT_BODY> {
    // block comments must end with '*/' at the end of the line
    {NonCrLf}*{BlockCommentEnd}{SpaceOrMultiLineSeparator}*{CrLf}? {
        int closingSlashPos = StringUtil.lastIndexOf(yytext(), '/', 0, yylength());
        yypushback(yylength() - 1 - closingSlashPos);
        yybegin(YYINITIAL);
        return BLOCK_COMMENT;
    }
    {NonCrLf}*{CrLf}   { }
    {NonCrLf}+         {
          // EOF met
          yybegin(YYINITIAL);
          return BLOCK_COMMENT;
    }
}

<EXPECT_SCRIPT> {
    {SpaceOrMultiLineSeparator}*\}{SpaceOrMultiLineSeparator}*{CrLf}? {
           int rbracePosExclusive = StringUtil.lastIndexOf(yytext(), '}', 0, yylength());
           yypushback(yylength() - rbracePosExclusive);
           yybegin(EXPECT_NON_COMMENT);
           return SCRIPT_TEXT;
    }
    {ScriptText}*{CrLf} { }
    {ScriptText}+ {
        // EOF met
        yybegin(YYINITIAL);
        return SCRIPT_TEXT;
    }
}

// STATES

<YYINITIAL, EXPECT_NON_COMMENT, EXPECT_SCRIPT_ARGUMENTS> {
    {WhiteSpace}             { return WHITE_SPACE; }
}
<YYINITIAL> {
    {WhiteSpaceWithNewLines} { yybegin(YYINITIAL); return WHITE_SPACE;}
    {BlockCommentStart}      { yybegin(BLOCK_COMMENT_BODY); }
    {LineComment}            { return LINE_COMMENT; }
    [^]                      { yypushback(yylength()); yybegin(EXPECT_NON_COMMENT); }
}

{WhiteSpaceWithNewLines}     { yybegin(YYINITIAL); yypushback(yylength()); return CRLF; }

<EXPECT_NON_COMMENT> {
"{"                      { return BRACE1; }
"}"                      { return BRACE2; }
"{}"                     { yypushback(1); return BRACE1;}
"="                      { return EQUALS; }
{Arrow}                  { return ARROW; }

"!script"                { yybegin(EXPECT_SCRIPT_ARGUMENTS); return UNQUOTED_TEXT; }

{QuotedText}             { return QUOTED_TEXT; }
{UnquotedText}           { return UNQUOTED_TEXT; }
}

<EXPECT_SCRIPT_ARGUMENTS> {
"{"                { yybegin(EXPECT_SCRIPT); return BRACE1; }
{QuotedText}       { return QUOTED_TEXT; }
{UnquotedText}     { return UNQUOTED_TEXT; }
[^]                { yybegin(YYINITIAL); yypushback(yylength()); }
}

[^]                      { return BAD_CHARACTER; }
