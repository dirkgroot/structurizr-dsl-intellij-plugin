package nl.dirkgroot.structurizr.dsl.support

import com.intellij.psi.PsiElement
import junit.framework.TestCase.assertEquals

fun assertPsiTree(root: PsiElement, expected: String) {
    assertEquals(expected, psiTreeToString(root))
}