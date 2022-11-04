package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import nl.dirkgroot.structurizr.dsl.lang.SDLexerAdapter
import nl.dirkgroot.structurizr.dsl.psi.SDTypes

class StructurizrDSLSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = SDLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            SDTypes.LINE_COMMENT -> LINE_COMMENT
            SDTypes.BLOCK_COMMENT -> BLOCK_COMMENT

            SDTypes.QUOTED_TEXT,
            SDTypes.UNQUOTED_TEXT -> STRING

            SDTypes.WORKSPACE_KEYWORD,
            SDTypes.MODEL_KEYWORD,
            SDTypes.VIEWS_KEYWORD,
            SDTypes.SOFTWARE_SYSTEM_KEYWORD -> KEYWORD

            else -> emptyArray()
        }
    }

    companion object {
        private val LINE_COMMENT = arrayOf(
            TextAttributesKey.createTextAttributesKey(
                "STRUCTURIZR_DSL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
            )
        )
        private val BLOCK_COMMENT = arrayOf(
            TextAttributesKey.createTextAttributesKey(
                "STRUCTURIZR_DSL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT
            )
        )
        private val KEYWORD = arrayOf(
            TextAttributesKey.createTextAttributesKey(
                "STRUCTURIZR_DSL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD
            )
        )
        private val STRING = arrayOf(
            TextAttributesKey.createTextAttributesKey(
                "STRUCTURIZR_DSL_STRING", DefaultLanguageHighlighterColors.STRING
            )
        )
    }
}
