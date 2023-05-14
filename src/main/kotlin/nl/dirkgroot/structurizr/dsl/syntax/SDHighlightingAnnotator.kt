package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import nl.dirkgroot.structurizr.dsl.psi.*

class SDHighlightingAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is SDKeyword -> holder.createAnnotation(KEYWORD)
            is SDArgument, is SDPropertyKey, is SDPropertyValue -> holder.createAnnotation(STRING)
            is SDScriptBlock -> holder.createAnnotation(EditorColors.INJECTED_LANGUAGE_FRAGMENT)
            is SDIdentifierReference, is SDRelationshipSource, is SDRelationshipDestination ->
                holder.createAnnotation(IDENTIFIER)
        }
    }

    private fun AnnotationHolder.createAnnotation(textAttributesKey: TextAttributesKey) {
        newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(textAttributesKey)
            .create()
    }
}
