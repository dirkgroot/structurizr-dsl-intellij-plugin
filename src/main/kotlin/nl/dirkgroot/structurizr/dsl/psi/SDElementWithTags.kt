package nl.dirkgroot.structurizr.dsl.psi

import com.intellij.psi.PsiElement

interface SDElementWithTags : PsiElement {
    val elementTags: Set<String>
}
