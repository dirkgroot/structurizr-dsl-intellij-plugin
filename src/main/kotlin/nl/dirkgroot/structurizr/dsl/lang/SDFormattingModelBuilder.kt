package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLanguage
import nl.dirkgroot.structurizr.dsl.psi.SDTypes

class SDFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel =
        FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            SDBlock(formattingContext.node, spacingBuilder = createSpacingBuilder(formattingContext.codeStyleSettings)),
            formattingContext.codeStyleSettings
        )

    private fun createSpacingBuilder(codeStyleSettings: CodeStyleSettings) =
        SpacingBuilder(codeStyleSettings, StructurizrDSLLanguage)
            .before(SDTypes.LINE_COMMENT).none()
            .before(SDTypes.BLOCK).spaces(1)
            .before(SDTypes.PROPERTIES_BLOCK).spaces(1)
            .before(SDTypes.PROPERTY_KEY).spaces(1)
            .before(SDTypes.PROPERTY_VALUE).spaces(1)
            .around(SDTypes.RELATIONSHIP_KEYWORD).spaces(1)
            .around(SDTypes.EQUALS).spaces(1)
            .before(SDTypes.ARGUMENT).spaces(1)
}
