package nl.dirkgroot.structurizr.dsl.support

import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isNotEmpty
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.tree.TokenSet
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory
import com.intellij.testFramework.junit5.RunInEdt
import nl.dirkgroot.structurizr.dsl.StructurizrDSLFileType
import nl.dirkgroot.structurizr.dsl.psi.StructurizrDSLFile
import org.junit.jupiter.api.BeforeEach

@RunInEdt
abstract class StructurizrDSLParserTest {
    private lateinit var project: Project

    @BeforeEach
    fun setUp() {
        val fixtureFactory = IdeaTestFixtureFactory.getFixtureFactory()
        val fixture = fixtureFactory.createLightFixtureBuilder("test").fixture
        fixture.setUp()
        project = fixture.project
    }

    protected fun parse(text: String) = PsiFileFactory.getInstance(project)
        .createFileFromText("test.dsl", StructurizrDSLFileType, text)

    protected fun assertPsiTree(source: String, expected: String) {
        val file = parse(source)
        assertPsiTree(file, expected)
    }

    protected fun assertParseSucceeds(source: String): StructurizrDSLFile {
        val psiFile = parse(source)
        val root = psiFile.viewProvider.allFiles.first()

        assertThat(
            root.node.getChildren(TokenSet.ANY)
                .filterIsInstance<PsiErrorElement>()
        ).isEmpty()

        return root as StructurizrDSLFile
    }

    protected fun assertParseFails(source: String) {
        val psiFile = parse(source)
        val root = psiFile.viewProvider.allFiles.first()

        assertThat(
            root.node.getChildren(TokenSet.ANY)
                .filterIsInstance<PsiErrorElement>()
        ).isNotEmpty()
    }
}
