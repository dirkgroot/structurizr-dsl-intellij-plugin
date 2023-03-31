package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.tree.TokenSet
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*

class SDBlock(
    node: ASTNode,
    private val spacingBuilder: SpacingBuilder,
    private val indent: Indent = Indent.getNoneIndent(),
    wrap: Wrap = Wrap.createWrap(WrapType.NONE, false),
    alignment: Alignment = Alignment.createAlignment()
) : AbstractBlock(node, wrap, alignment) {
    override fun buildChildren(): MutableList<Block> {
        val result = mutableListOf<Block>()
        var child = myNode.firstChildNode
        while (child != null) {
            if (child.elementType != WHITE_SPACE && child.elementType != CRLF) {
                val indent = if (child.elementType in INDENT_TOKEN_TYPES && myNode.treeParent != null)
                    Indent.getNormalIndent(true)
                else
                    Indent.getNoneIndent()
                val block = SDBlock(child, spacingBuilder, indent)
                result.add(block)
            }
            child = child.treeNext
        }
        return result
    }

    override fun getIndent() = indent

    override fun getSpacing(child1: Block?, child2: Block) = spacingBuilder.getSpacing(this, child1, child2)

    override fun isLeaf() = myNode.firstChildNode == null

    companion object {
        private val INDENT_TOKEN_TYPES = TokenSet.create(
            BLOCK_COMMENT,
            BLOCK_STATEMENT,
            EXPLICIT_RELATIONSHIP,
            IDENTIFIER_REFERENCES,
            IMPLICIT_RELATIONSHIP,
            KEY_VALUE_PAIR,
            LINE_COMMENT,
            PROPERTY_BLOCK_STATEMENT,
            SCRIPT_BLOCK,
            SINGLE_LINE_STATEMENT,
        )
    }
}
