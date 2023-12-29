package nl.dirkgroot.structurizr.dsl.editing.formatter

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.codeStyle.CodeStyleManager
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

abstract class FormatterTest : StructurizrDSLCodeInsightTest() {
    protected fun assertFormattingResult(code: String, expectedResult: String) {
        val file = myFixture.addFileToProject("test.dsl", code)
        myFixture.openFileInEditor(file.virtualFile)

        WriteCommandAction.writeCommandAction(project).run<Exception> {
            CodeStyleManager.getInstance(project)
                .reformatText(myFixture.file, listOf(myFixture.file.textRange))
        }
        myFixture.checkResult(expectedResult)
    }
}
