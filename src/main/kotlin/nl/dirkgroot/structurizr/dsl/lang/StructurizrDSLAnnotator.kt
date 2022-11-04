package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement

class StructurizrDSLAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
//        when (element) {
//            is SDSoftwareSystemName ->
//                holder.createTextAttribute(element, StructurizrDSLSyntaxHighlighter.SOFTWARE_SYSTEM_NAME)
//
//            is SDSoftwareSystemIdentifier ->
//                holder.createTextAttribute(element, StructurizrDSLSyntaxHighlighter.IDENTIFIER)
//        }
    }

//    private fun AnnotationHolder.createTextAttribute(element: PsiElement, textAttributesKey: TextAttributesKey) {
//        newSilentAnnotation(HighlightSeverity.INFORMATION)
//            .range(element)
//            .textAttributes(textAttributesKey)
//            .create()
//    }
}
