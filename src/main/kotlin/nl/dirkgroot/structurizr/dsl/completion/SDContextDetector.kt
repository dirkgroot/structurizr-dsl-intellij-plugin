package nl.dirkgroot.structurizr.dsl.completion

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import nl.dirkgroot.structurizr.dsl.psi.SDBlock
import nl.dirkgroot.structurizr.dsl.psi.SDBlockStatement

object SDContextDetector {

    fun detect(position: PsiElement): SDCompletionContext {
        val enclosingBlock = PsiTreeUtil.getParentOfType(position, SDBlock::class.java)
            ?: return SDCompletionContext.TOP_LEVEL

        val enclosingKeyword = blockKeyword(enclosingBlock) ?: return SDCompletionContext.UNKNOWN
        val parentBlock = PsiTreeUtil.getParentOfType(enclosingBlock, SDBlock::class.java)
        val parentKeyword = parentBlock?.let(::blockKeyword)

        return contextFor(enclosingKeyword, parentKeyword)
    }

    private fun blockKeyword(block: SDBlock): String? {
        val statement = block.parent as? SDBlockStatement ?: return null
        return statement.keyword.text?.lowercase()
    }

    private fun contextFor(enclosing: String, parent: String?): SDCompletionContext = when (enclosing) {
        "workspace" -> SDCompletionContext.WORKSPACE
        "model" -> SDCompletionContext.MODEL
        "enterprise" -> SDCompletionContext.ENTERPRISE
        "group" -> SDCompletionContext.GROUP
        "softwaresystem" -> SDCompletionContext.SOFTWARE_SYSTEM
        "container" -> SDCompletionContext.CONTAINER
        "component" -> SDCompletionContext.COMPONENT
        "person" -> SDCompletionContext.PERSON
        "deploymentenvironment" -> SDCompletionContext.DEPLOYMENT_ENVIRONMENT
        "deploymentnode" -> SDCompletionContext.DEPLOYMENT_NODE
        "infrastructurenode" -> SDCompletionContext.INFRASTRUCTURE_NODE
        "containerinstance" -> SDCompletionContext.CONTAINER_INSTANCE
        "softwaresysteminstance" -> SDCompletionContext.SOFTWARE_SYSTEM_INSTANCE
        "views" -> SDCompletionContext.VIEWS
        "configuration" -> SDCompletionContext.CONFIGURATION
        "branding" -> SDCompletionContext.BRANDING
        "terminology" -> SDCompletionContext.TERMINOLOGY
        "styles" -> SDCompletionContext.STYLES
        "element" -> if (parent == "styles") SDCompletionContext.STYLES_ELEMENT else SDCompletionContext.UNKNOWN
        "relationship" -> if (parent == "styles") SDCompletionContext.STYLES_RELATIONSHIP else SDCompletionContext.UNKNOWN
        else -> SDCompletionContext.UNKNOWN
    }
}
