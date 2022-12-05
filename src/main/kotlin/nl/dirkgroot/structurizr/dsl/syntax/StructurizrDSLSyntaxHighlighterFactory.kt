package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class StructurizrDSLSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) =
        StructurizrDSLSyntaxHighlighter()
}
