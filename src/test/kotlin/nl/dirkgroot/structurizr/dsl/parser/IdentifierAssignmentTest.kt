package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class IdentifierAssignmentTest : StructurizrDSLCodeInsightTest() {
    @TestFactory
    fun `identifier assignment to single line element`() = KEYWORDS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """identifier = $keyword blaat""",
                """
                    IdentifierAssignment
                        IdentifierReference identifier
                        SingleLineStatement
                            Keyword $keyword
                            Argument blaat
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `identifier assignment to block element`() = KEYWORDS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """
                    identifier = softwareSystem blaat {
                        container containerName
                    }
                """.trimIndent(),
                """
                    IdentifierAssignment
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
    }

    @TestFactory
    fun `identifier assignment inside block`() = KEYWORDS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
                            IdentifierAssignment
                                IdentifierReference identifier
                                SingleLineStatement
                                    Keyword softwareSystem
                                    Argument name
                """.trimIndent()
            )
        }
    }
}
