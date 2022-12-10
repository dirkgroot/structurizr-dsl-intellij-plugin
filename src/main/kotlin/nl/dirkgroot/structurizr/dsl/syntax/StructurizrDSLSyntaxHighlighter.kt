package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import nl.dirkgroot.structurizr.dsl.lang.SDLexerAdapter
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*

class StructurizrDSLSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = SDLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> = pack(MAP[tokenType])

    companion object {
        private val BLOCK_COMMENT_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
        private val KEYWORD_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
        )
        private val LINE_COMMENT_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val TEXT_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_TEXT", DefaultLanguageHighlighterColors.STRING
        )
        private val BAD_CHARACTER_KEY = createTextAttributesKey(
            "STRUCTURIZR_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER
        )
        private val INJECTED_CODE_KEY = createTextAttributesKey(
            "STRUCTURIZR_INJECTED_CODE", EditorColors.INJECTED_LANGUAGE_FRAGMENT
        )

        private val KEYWORD_TOKENS = TokenSet.create(
            ADRS_KEYWORD,
            ANIMATION_KEYWORD,
            AUTO_LAYOUT_KEYWORD,
            BACKGROUND_KEYWORD,
            BORDER_KEYWORD,
            BRANDING_KEYWORD,
            COLOR_KEYWORD,
            COLOUR_KEYWORD,
            COMPONENT_KEYWORD,
            CONFIGURATION_KEYWORD,
            CONSTANT_KEYWORD,
            CONTAINER_INSTANCE,
            CONTAINER_KEYWORD,
            CUSTOM_KEYWORD,
            DEPLOYMENT_ENVIRONMENT_KEYWORD,
            DEPLOYMENT_GROUP_KEYWORD,
            DEPLOYMENT_KEYWORD,
            DEPLOYMENT_NODE_KEYWORD,
            DESCRIPTION_KEYWORD,
            DOCS_KEYWORD,
            DYNAMIC_KEYWORD,
            ELEMENT_KEYWORD,
            ENTERPRISE_KEYWORD,
            EXCLUDE_ELEMENT_KEYWORD,
            EXTENDS_KEYWORD,
            FILTERED_KEYWORD,
            FONTSIZE_KEYWORD,
            GROUP_KEYWORD,
            HEALTH_CHECK_KEYWORD,
            HEIGHT_KEYWORD,
            ICON_KEYWORD,
            IDENTIFIERS_KEYWORD,
            IMPLIED_RELATIONSHIPS_KEYWORD,
            INCLUDE_ELEMENT_KEYWORD,
            INCLUDE_FILE_KEYWORD,
            INFRASTRUCTURE_NODE_KEYWORD,
            INSTANCES_KEYWORD,
            METADATA_KEYWORD,
            MODEL_KEYWORD,
            OPACITY_KEYWORD,
            PERSON_KEYWORD,
            PERSPECTIVES_KEYWORD,
            PLUGIN_KEYWORD,
            POSITION_KEYWORD,
            PROPERTIES_KEYWORD,
            REF_KEYWORD,
            RELATIONSHIP_KEYWORD,
            ROUTING_KEYWORD,
            SCRIPT_KEYWORD,
            SHAPE_KEYWORD,
            SOFTWARE_SYSTEM_INSTANCE_KEYWORD,
            SOFTWARE_SYSTEM_KEYWORD,
            STROKE_KEYWORD,
            STROKEWIDTH_KEYWORD,
            STYLE_KEYWORD,
            STYLES_KEYWORD,
            SYSTEM_CONTEXT_KEYWORD,
            SYSTEM_LANDSCAPE_KEYWORD,
            TAGS_KEYWORD,
            TECHNOLOGY_KEYWORD,
            TERMINOLOGY_KEYWORD,
            THEME_KEYWORD,
            THICKNESS_KEYWORD,
            TITLE_KEYWORD,
            URL_KEYWORD,
            USERS_KEYWORD,
            VIEWS_KEYWORD,
            WIDTH_KEYWORD,
            WORKSPACE_KEYWORD,
        )
        private val TEXT_TOKENS = TokenSet.create(QUOTED_TEXT, UNQUOTED_TEXT)

        private val MAP = buildMap {
            fillMap(this, LINE_COMMENT_KEY, LINE_COMMENT)
            fillMap(this, BLOCK_COMMENT_KEY, BLOCK_COMMENT)
            fillMap(this, TEXT_TOKENS, TEXT_KEY)
            fillMap(this, KEYWORD_TOKENS, KEYWORD_KEY)
            fillMap(this, BAD_CHARACTER_KEY, TokenType.BAD_CHARACTER)
            fillMap(this, INJECTED_CODE_KEY, SCRIPT_TEXT)
        }
    }
}
