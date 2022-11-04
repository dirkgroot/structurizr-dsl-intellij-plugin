package nl.dirkgroot.structurizr.dsl

import com.intellij.openapi.fileTypes.LanguageFileType

object StructurizrDSLFileType : LanguageFileType(StructurizrDSLLanguage) {
    override fun getName() = "StructurizrDSL File"

    override fun getDescription() = "StructurizrDSL language file"

    override fun getDefaultExtension() = "dsl"

    override fun getIcon() = StructurizrDSLIcon.icon
}
