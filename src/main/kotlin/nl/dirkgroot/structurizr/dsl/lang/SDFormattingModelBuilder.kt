package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLanguage
import nl.dirkgroot.structurizr.dsl.psi.SDTypes

class SDFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel =
        FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            SDBlock(formattingContext.node, createSpacingBuilder(formattingContext.codeStyleSettings)),
            formattingContext.codeStyleSettings
        )

    private fun createSpacingBuilder(codeStyleSettings: CodeStyleSettings) =
        SpacingBuilder(codeStyleSettings, StructurizrDSLLanguage)
            .around(SDTypes.EQUALS).spaces(1)
            .around(SDTypes.IDENTIFIER_NAME).spaces(1)
            .before(SDTypes.ARGUMENT).spaces(1)
            .before(SDTypes.BRACE1).spaces(1)
            .between(SDTypes.KEY, SDTypes.VALUE).spaces(1)
}
