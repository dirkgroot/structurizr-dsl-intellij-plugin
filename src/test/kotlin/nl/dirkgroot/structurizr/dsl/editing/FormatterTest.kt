package nl.dirkgroot.structurizr.dsl.editing

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.codeStyle.CodeStyleManager
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLParserTest

open class FormatterTest : StructurizrDSLParserTest() {
    protected fun assertFormattingResult(code: String, expectedResult: String) {
        val file = fixture.addFileToProject("test.dsl", code)
        fixture.openFileInEditor(file.virtualFile)

        WriteCommandAction.writeCommandAction(project).run<Exception> {
            CodeStyleManager.getInstance(project)
                .reformatText(fixture.file, listOf(fixture.file.textRange))
        }
        fixture.checkResult(expectedResult)
    }
}
