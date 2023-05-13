package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import nl.dirkgroot.structurizr.dsl.lang.SDLexerAdapter
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.BLOCK_COMMENT
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.LINE_COMMENT

class StructurizrDSLSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = SDLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> = pack(MAP[tokenType])

    companion object {
        private val BLOCK_COMMENT_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
        private val LINE_COMMENT_KEY = createTextAttributesKey(
            "STRUCTURIZR_DSL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val BAD_CHARACTER_KEY = createTextAttributesKey(
            "STRUCTURIZR_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER
        )

        private val MAP = buildMap {
            fillMap(this, LINE_COMMENT_KEY, LINE_COMMENT)
            fillMap(this, BLOCK_COMMENT_KEY, BLOCK_COMMENT)
            fillMap(this, BAD_CHARACTER_KEY, TokenType.BAD_CHARACTER)
        }
    }
}
