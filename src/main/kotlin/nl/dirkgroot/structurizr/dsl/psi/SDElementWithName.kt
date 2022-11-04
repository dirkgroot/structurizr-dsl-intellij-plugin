package nl.dirkgroot.structurizr.dsl.psi

import com.intellij.psi.PsiElement

interface SDElementWithName : PsiElement {
    val elementName: String
}
