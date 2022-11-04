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
%}

%public
%class StructurizrDSLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state ARGUMENTS

LINE_TERMINATOR=\r|\n|\r\n
WHITE_SPACE=[ \t\x0B\f]+
EMPTY_LINE={WHITE_SPACE}* {LINE_TERMINATOR}

//IDENTIFIER=[a-zA-Z0-9\-_\.]+

QUOTED_TEXT=\"[^\"]*\"
UNQUOTED_TEXT=[^\s\"]+

LINE_COMMENT="//" [^\r\n]* {LINE_TERMINATOR}?
BLOCK_COMMENT="/*" [^*] ~"*/" {LINE_TERMINATOR}?

%%

{LINE_COMMENT}     { return LINE_COMMENT; }
{BLOCK_COMMENT}    { return BLOCK_COMMENT; }
{WHITE_SPACE}      { return WHITE_SPACE; }

<YYINITIAL> {
    ^{EMPTY_LINE}      { return WHITE_SPACE; }
    {LINE_TERMINATOR}  { return LINE_TERMINATOR; }

    "{"                { return BRACE1; }
    "}"                { return BRACE2; }

    "workspace"        { yybegin(ARGUMENTS); return WORKSPACE_KEYWORD; }

    "model"            { return MODEL_KEYWORD; }
    "softwareSystem"   { yybegin(ARGUMENTS); return SOFTWARE_SYSTEM_KEYWORD; }

    "views"            { return VIEWS_KEYWORD; }
}

<ARGUMENTS> {
    {LINE_TERMINATOR}  { yybegin(YYINITIAL); return LINE_TERMINATOR; }
    "{"                { return BRACE1; }
    {QUOTED_TEXT}      { return QUOTED_TEXT; }
    {UNQUOTED_TEXT}    { return UNQUOTED_TEXT; }
}

[^]                { return BAD_CHARACTER; }
