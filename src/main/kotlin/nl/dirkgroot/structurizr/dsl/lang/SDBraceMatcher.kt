package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import nl.dirkgroot.structurizr.dsl.psi.SDTypes

class SDBraceMatcher : PairedBraceMatcher {
    override fun getPairs() = arrayOf(BracePair(SDTypes.BRACE1, SDTypes.BRACE2, true))

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?) = true

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int) = openingBraceOffset
}
