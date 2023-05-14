package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.tree.TokenSet
import nl.dirkgroot.structurizr.dsl.psi.SDStatement
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*

class SDFormattingBlock(
    node: ASTNode,
    wrap: Wrap = Wrap.createWrap(WrapType.NONE, false),
    alignment: Alignment? = null,
    private val spacingBuilder: SpacingBuilder,
    private val indent: Indent = Indent.getNoneIndent()
) : AbstractBlock(node, wrap, alignment) {
    override fun buildChildren() =
        if (myNode.elementType == SCRIPT_BLOCK)
            emptyList()
        else
            generateSequence(myNode.firstChildNode) { it.treeNext }
                .mapNotNull { child ->
                    if (child.elementType != WHITE_SPACE && child.elementType != CRLF)
                        SDFormattingBlock(child, spacingBuilder = spacingBuilder, indent = calculateIndent(child))
                    else
                        null
                }
                .toList()

    private fun calculateIndent(child: ASTNode) =
        if ((child.elementType in INDENT_TOKEN_TYPES || child.psi is SDStatement) && myNode.treeParent != null)
            Indent.getNormalIndent()
        else
            Indent.getNoneIndent()

    override fun getIndent() = indent

    override fun getSpacing(child1: Block?, child2: Block) = spacingBuilder.getSpacing(this, child1, child2)

    override fun isLeaf() = myNode.firstChildNode == null

    override fun getChildAttributes(newChildIndex: Int) =
        if (myNode.elementType in INDENT_TOKEN_TYPES || myNode.psi is SDStatement)
            ChildAttributes(Indent.getNormalIndent(), null)
        else
            ChildAttributes(Indent.getNoneIndent(), null)

    companion object {
        private val INDENT_TOKEN_TYPES = TokenSet.create(PROPERTIES_BLOCK, BLOCK, PROPERTY_DEFINITION)
    }
}
