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

%state EXPECT_ARGUMENTS
%state EXPECT_PROPERTIES
%state EXPECT_REL_DESTINATION
%state EXPECT_SCRIPT
%state EXPECT_SCRIPT_ARGUMENTS

CRLF=\r|\n|\r\n
WHITE_SPACE=[\ \t\f]+
EMPTY_LINE={WHITE_SPACE}* {CRLF}

QUOTED_TEXT=\" [^\"\r\n]* \"?
UNQUOTED_TEXT=[^\s\"\r\n]+
IDENTIFIER=[a-zA-Z_0-9\\.]+

LINE_COMMENT=("//"|"#") [^\r\n]*
BLOCK_COMMENT="/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

SCRIPT_TEXT=[^\r\n{}]+

%%

<YYINITIAL,EXPECT_PROPERTIES,EXPECT_REL_DESTINATION,EXPECT_ARGUMENTS,EXPECT_SCRIPT_ARGUMENTS> {
{WHITE_SPACE}      { return WHITE_SPACE; }
{BLOCK_COMMENT}    { return BLOCK_COMMENT; }
{LINE_COMMENT}     { return LINE_COMMENT; }
}

<YYINITIAL,EXPECT_PROPERTIES> {
^{EMPTY_LINE}      { return WHITE_SPACE; }
}

<YYINITIAL> {
{CRLF}                   { return CRLF; }

"{"                      { return BRACE1; }
"}"                      { return BRACE2; }
"="                      { return EQUALS; }

"!adrs"                  { yybegin(EXPECT_ARGUMENTS); return ADRS_KEYWORD; }
"!constant"              { yybegin(EXPECT_ARGUMENTS); return CONSTANT_KEYWORD; }
"!docs"                  { yybegin(EXPECT_ARGUMENTS); return DOCS_KEYWORD; }
"!identifiers"           { yybegin(EXPECT_ARGUMENTS); return IDENTIFIERS_KEYWORD; }
"!impliedRelationships"  { yybegin(EXPECT_ARGUMENTS); return IMPLIED_RELATIONSHIPS_KEYWORD; }
"!include"               { yybegin(EXPECT_ARGUMENTS); return INCLUDE_FILE_KEYWORD; }
"!plugin"                { yybegin(EXPECT_ARGUMENTS); return PLUGIN_KEYWORD; }
"!ref"                   { yybegin(EXPECT_ARGUMENTS); return REF_KEYWORD; }
"!script"                { yybegin(EXPECT_SCRIPT_ARGUMENTS); return SCRIPT_KEYWORD; }
"->"                     { yybegin(EXPECT_REL_DESTINATION); return RELATIONSHIP_KEYWORD; }
"animation"              { yybegin(EXPECT_ARGUMENTS); return ANIMATION_KEYWORD; }
"autoLayout"             { yybegin(EXPECT_ARGUMENTS); return AUTO_LAYOUT_KEYWORD; }
"background"             { yybegin(EXPECT_ARGUMENTS); return BACKGROUND_KEYWORD; }
"border"                 { yybegin(EXPECT_ARGUMENTS); return BORDER_KEYWORD; }
"branding"               { yybegin(EXPECT_PROPERTIES); return BRANDING_KEYWORD; }
"color"                  { yybegin(EXPECT_ARGUMENTS); return COLOR_KEYWORD; }
"colour"                 { yybegin(EXPECT_ARGUMENTS); return COLOUR_KEYWORD; }
"component"              { yybegin(EXPECT_ARGUMENTS); return COMPONENT_KEYWORD; }
"configuration"          { yybegin(EXPECT_PROPERTIES); return CONFIGURATION_KEYWORD; }
"container"              { yybegin(EXPECT_ARGUMENTS); return CONTAINER_KEYWORD; }
"containerInstance"      { yybegin(EXPECT_ARGUMENTS); return CONTAINER_INSTANCE; }
"custom"                 { yybegin(EXPECT_ARGUMENTS); return CUSTOM_KEYWORD; }
"deployment"             { yybegin(EXPECT_ARGUMENTS); return DEPLOYMENT_KEYWORD; }
"deploymentEnvironment"  { yybegin(EXPECT_ARGUMENTS); return DEPLOYMENT_ENVIRONMENT_KEYWORD; }
"deploymentGroup"        { yybegin(EXPECT_ARGUMENTS); return DEPLOYMENT_GROUP_KEYWORD; }
"deploymentNode"         { yybegin(EXPECT_ARGUMENTS); return DEPLOYMENT_NODE_KEYWORD; }
"description"            { yybegin(EXPECT_ARGUMENTS); return DESCRIPTION_KEYWORD; }
"dynamic"                { yybegin(EXPECT_ARGUMENTS); return DYNAMIC_KEYWORD; }
"element"                { yybegin(EXPECT_ARGUMENTS); return ELEMENT_KEYWORD; }
"enterprise"             { yybegin(EXPECT_ARGUMENTS); return ENTERPRISE_KEYWORD; }
"exclude"                { yybegin(EXPECT_ARGUMENTS); return EXCLUDE_ELEMENT_KEYWORD; }
"extends"                { yybegin(EXPECT_ARGUMENTS); return EXTENDS_KEYWORD; }
"filtered"               { yybegin(EXPECT_ARGUMENTS); return FILTERED_KEYWORD; }
"fontSize"               { yybegin(EXPECT_ARGUMENTS); return FONTSIZE_KEYWORD; }
"group"                  { yybegin(EXPECT_ARGUMENTS); return GROUP_KEYWORD; }
"healthCheck"            { yybegin(EXPECT_ARGUMENTS); return HEALTH_CHECK_KEYWORD; }
"height"                 { yybegin(EXPECT_ARGUMENTS); return HEIGHT_KEYWORD; }
"icon"                   { yybegin(EXPECT_ARGUMENTS); return ICON_KEYWORD; }
"include"                { yybegin(EXPECT_ARGUMENTS); return INCLUDE_ELEMENT_KEYWORD; }
"infrastructureNode"     { yybegin(EXPECT_ARGUMENTS); return INFRASTRUCTURE_NODE_KEYWORD; }
"instances"              { yybegin(EXPECT_ARGUMENTS); return INSTANCES_KEYWORD; }
"metadata"               { yybegin(EXPECT_ARGUMENTS); return METADATA_KEYWORD; }
"model"                  { yybegin(EXPECT_ARGUMENTS); return MODEL_KEYWORD; }
"opacity"                { yybegin(EXPECT_ARGUMENTS); return OPACITY_KEYWORD; }
"person"                 { yybegin(EXPECT_ARGUMENTS); return PERSON_KEYWORD; }
"perspectives"           { yybegin(EXPECT_ARGUMENTS); return PERSPECTIVES_KEYWORD; }
"position"               { yybegin(EXPECT_ARGUMENTS); return POSITION_KEYWORD; }
"properties"             { yybegin(EXPECT_PROPERTIES); return PROPERTIES_KEYWORD; }
"routing"                { yybegin(EXPECT_ARGUMENTS); return ROUTING_KEYWORD; }
"shape"                  { yybegin(EXPECT_ARGUMENTS); return SHAPE_KEYWORD; }
"softwareSystem"         { yybegin(EXPECT_ARGUMENTS); return SOFTWARE_SYSTEM_KEYWORD; }
"softwareSystemInstance" { yybegin(EXPECT_ARGUMENTS); return SOFTWARE_SYSTEM_INSTANCE_KEYWORD; }
"stroke"                 { yybegin(EXPECT_ARGUMENTS); return STROKE_KEYWORD; }
"strokeWidth"            { yybegin(EXPECT_ARGUMENTS); return STROKEWIDTH_KEYWORD; }
"style"                  { yybegin(EXPECT_ARGUMENTS); return STYLE_KEYWORD; }
"styles"                 { yybegin(EXPECT_ARGUMENTS); return STYLES_KEYWORD; }
"systemContext"          { yybegin(EXPECT_ARGUMENTS); return SYSTEM_CONTEXT_KEYWORD; }
"systemLandscape"        { yybegin(EXPECT_ARGUMENTS); return SYSTEM_LANDSCAPE_KEYWORD; }
"tags"                   { yybegin(EXPECT_ARGUMENTS); return TAGS_KEYWORD; }
"technology"             { yybegin(EXPECT_ARGUMENTS); return TECHNOLOGY_KEYWORD; }
"terminology"            { yybegin(EXPECT_PROPERTIES); return TERMINOLOGY_KEYWORD; }
"theme"                  { yybegin(EXPECT_ARGUMENTS); return THEME_KEYWORD; }
"thickness"              { yybegin(EXPECT_ARGUMENTS); return THICKNESS_KEYWORD; }
"title"                  { yybegin(EXPECT_ARGUMENTS); return TITLE_KEYWORD; }
"url"                    { yybegin(EXPECT_ARGUMENTS); return URL_KEYWORD; }
"users"                  { yybegin(EXPECT_PROPERTIES); return USERS_KEYWORD; }
"views"                  { yybegin(EXPECT_ARGUMENTS); return VIEWS_KEYWORD; }
"width"                  { yybegin(EXPECT_ARGUMENTS); return WIDTH_KEYWORD; }
"workspace"              { yybegin(EXPECT_ARGUMENTS); return WORKSPACE_KEYWORD; }

{IDENTIFIER}             { return IDENTIFIER; }

[^]                      { return BAD_CHARACTER; }
}

<EXPECT_REL_DESTINATION> {
{IDENTIFIER}       { yybegin(EXPECT_ARGUMENTS); return IDENTIFIER; }
[^]                { yybegin(YYINITIAL); yypushback(yytext().length()); }
}

<EXPECT_ARGUMENTS> {
"{"                { yybegin(YYINITIAL); yypushback(yytext().length()); }

{QUOTED_TEXT}      { return QUOTED_TEXT; }
{UNQUOTED_TEXT}    { return UNQUOTED_TEXT; }

[^]                { yybegin(YYINITIAL); yypushback(yytext().length()); }
}

<EXPECT_PROPERTIES> {
"{"                { return BRACE1; }
"}"                { yybegin(YYINITIAL); return BRACE2; }
{CRLF}             { return CRLF; }

{QUOTED_TEXT}      { return QUOTED_TEXT; }
{UNQUOTED_TEXT}    { return UNQUOTED_TEXT; }
}

<EXPECT_SCRIPT_ARGUMENTS> {
"{"                { startScript(); return BRACE1; }
{QUOTED_TEXT}      { return QUOTED_TEXT; }
{UNQUOTED_TEXT}    { return UNQUOTED_TEXT; }
[^]                { yybegin(YYINITIAL); yypushback(yytext().length()); }
}

<EXPECT_SCRIPT> {
"{"                { braces++; return SCRIPT_TEXT; }
"}"                {
                     if (braces == 0) {
                         endScript();
                         return BRACE2;
                     }
                     braces--;
                     return SCRIPT_TEXT;
                   }
{CRLF}             { return SCRIPT_TEXT; }
{SCRIPT_TEXT}      { return SCRIPT_TEXT; }
}

[^]                { return BAD_CHARACTER; }
