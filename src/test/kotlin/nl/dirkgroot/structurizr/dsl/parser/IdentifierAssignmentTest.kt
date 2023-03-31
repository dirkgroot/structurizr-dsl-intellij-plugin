package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLParserTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class IdentifierAssignmentTest : StructurizrDSLParserTest() {
    @TestFactory
    fun `identifier assignment to single line element`() = KEYWORDS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """identifier = softwareSystem blaat""",
                """
                    SingleLineStatement
                        IdentifierName identifier
                        Keyword softwareSystem
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
                    BlockStatement
                        IdentifierName identifier
                        Keyword softwareSystem
                        Argument blaat
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
                        SingleLineStatement
                            IdentifierName identifier
                            Keyword softwareSystem
                            Argument name
                """.trimIndent()
            )
        }
    }
}
