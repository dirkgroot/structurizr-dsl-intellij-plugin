package nl.dirkgroot.structurizr.dsl.support

import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase
import nl.dirkgroot.structurizr.dsl.StructurizrDSLFileType

abstract class StructurizrDSLCodeInsightTest : LightJavaCodeInsightFixtureTestCase() {
    private fun parse(text: String) = PsiFileFactory.getInstance(project)
        .createFileFromText("test.dsl", StructurizrDSLFileType, text)

    protected fun assertPsiTree(source: String, expected: String) {
        val file = parse(source)
        assertPsiTree(file, expected)
    }

    override fun getTestDataPath() = "src/test/testData"
}
