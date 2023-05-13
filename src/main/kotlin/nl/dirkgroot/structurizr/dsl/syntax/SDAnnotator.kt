package nl.dirkgroot.structurizr.dsl.syntax

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import nl.dirkgroot.structurizr.dsl.psi.*

class SDAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is SDKeyword, is SDPropertiesKeyword, is SDScriptKeyword, is SDRelationshipKeyword, is SDAnimationKeyword ->
                holder.createAnnotation(element, KEYWORD)

            is SDArgument, is SDPropertyDefinition -> holder.createAnnotation(element, STRING)
            is SDScriptBlock -> holder.createAnnotation(element, EditorColors.INJECTED_LANGUAGE_FRAGMENT)
            is SDIdentifierReference -> holder.createAnnotation(element, IDENTIFIER)
        }
    }

    private fun AnnotationHolder.createAnnotation(element: PsiElement, textAttributesKey: TextAttributesKey) {
        newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(element)
            .textAttributes(textAttributesKey)
            .create()
    }
}
