package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import nl.dirkgroot.structurizr.dsl.psi.SDBlock

class SDFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) =
        PsiTreeUtil.findChildrenOfType(root, SDBlock::class.java)
            .map { FoldingDescriptor(it.node, it.textRange) }
            .toTypedArray()

    override fun getPlaceholderText(node: ASTNode) = "{...}"

    override fun isCollapsedByDefault(node: ASTNode) = false
}
