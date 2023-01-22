package nl.dirkgroot.structurizr.dsl.support

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.util.text.escLBr
import nl.dirkgroot.structurizr.dsl.psi.StructurizrDSLFile

fun psiTreeToString(root: PsiElement): String {
    val builder = StringBuilder()

    fun inner(element: PsiElement, indent: Int = 0) {
        repeat(indent) { builder.append(' ') }

        val name = element.javaClass.simpleName
            .replace("(^SD|Impl$)".toRegex(), "")
        builder.append(name)

        if (element is PsiErrorElement) {
            builder.append(" ")
            builder.append(element.errorDescription)
        }
        if (element.children.isEmpty()) {
            builder.append(" ")
            builder.append(element.text.escLBr())
        }

        element.children.forEach {
            builder.appendLine()
            inner(it, indent + 4)
        }
    }

    if (root is StructurizrDSLFile)
        root.children.forEach {
            if (builder.isNotEmpty()) builder.appendLine()
            inner(it)
        }
    else
        inner(root)

    return builder.toString()
}
