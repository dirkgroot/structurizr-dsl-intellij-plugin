package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class IdentifierAssignmentTest(private val keyword: String) : StructurizrDSLCodeInsightTest() {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> = KEYWORDS.map { (keyword, _) -> arrayOf(keyword) }
    }

    @Test
    fun `identifier assignment to single line element`() {
        assertPsiTree(
            """identifier = $keyword blaat""",
            """
                IdentifierAssignmentStatement
                    IdentifierReference identifier
                    SingleLineStatement
                        Keyword $keyword
                        Argument blaat
            """.trimIndent()
        )
    }

    @Test
    fun `identifier assignment to block element`() {
        assertPsiTree(
            """
                identifier = softwareSystem blaat {
                    container containerName
                }
            """.trimIndent(),
            """
                IdentifierAssignmentStatement
                    IdentifierReference identifier
                    BlockStatement
                        Keyword softwareSystem
                        Argument blaat
                        Block
                            SingleLineStatement
                                Keyword container
                                Argument containerName
             """.trimIndent()
        )
    }

    @Test
    fun `identifier assignment inside block`() {
        assertPsiTree(
            """
                model {
                    identifier = softwareSystem name
                }
            """.trimIndent(),
            """
                BlockStatement
                    Keyword model
                    Block
                        IdentifierAssignmentStatement
                            IdentifierReference identifier
                            SingleLineStatement
                                Keyword softwareSystem
                                Argument name
            """.trimIndent()
        )
    }
}
