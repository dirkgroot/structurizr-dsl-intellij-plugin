package nl.dirkgroot.structurizr.dsl.psi

import com.intellij.psi.PsiElement

interface SDElementWithDescription : PsiElement {
    val elementDescription: String
}
