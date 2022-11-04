package nl.dirkgroot.structurizr.dsl.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import nl.dirkgroot.structurizr.dsl.StructurizrDSLFileType
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLanguage

class SDFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, StructurizrDSLLanguage) {
    override fun getFileType() = StructurizrDSLFileType

    override fun toString() = "StructurizrDSL File"
}
