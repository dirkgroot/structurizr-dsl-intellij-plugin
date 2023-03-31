package nl.dirkgroot.structurizr.dsl.support

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory
import com.intellij.testFramework.junit5.RunInEdt
import nl.dirkgroot.structurizr.dsl.StructurizrDSLFileType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

@RunInEdt
abstract class StructurizrDSLCodeInsightTest {
    protected lateinit var fixture: CodeInsightTestFixture
    protected lateinit var project: Project

    @BeforeEach
    fun setUp() {
        val fixtureFactory = IdeaTestFixtureFactory.getFixtureFactory()
        fixture = fixtureFactory.createCodeInsightFixture(fixtureFactory.createLightFixtureBuilder("test").fixture)
        fixture.setUp()
        project = fixture.project
    }

    @AfterEach
    fun tearDown() {
        fixture.tearDown()
    }

    private fun parse(text: String) = PsiFileFactory.getInstance(project)
        .createFileFromText("test.dsl", StructurizrDSLFileType, text)

    protected fun assertPsiTree(source: String, expected: String) {
        val file = parse(source)
        assertPsiTree(file, expected)
    }
}
