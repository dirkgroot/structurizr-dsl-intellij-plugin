package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLParserTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ElementsWithBlocksOfElementsTest : StructurizrDSLParserTest() {
    @TestFactory
    fun `empty block`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """
                    $keyword {
                    }
                """.trimIndent(),
                """
                    BlockStatement
                        Keyword $keyword
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `block with only empty lines inside`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """
                    $keyword {
                    
                    
                    }
                """.trimIndent(),
                """
                    BlockStatement
                        Keyword $keyword
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `block with single line element inside`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            val (elementKeyword, _) = KEYWORDS_WITH_BLOCKS.random()
            assertPsiTree(
                """
                    $keyword {
                        $elementKeyword arg1
                    }
                """.trimIndent(),
                """
                    BlockStatement
                        Keyword $keyword
                        SingleLineStatement
                            Keyword $elementKeyword
                            Argument arg1
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `block with multiple single line elements inside`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            val (elementKeyword, _) = KEYWORDS_WITH_BLOCKS.random()
            assertPsiTree(
                """
                    $keyword {
                        $elementKeyword arg1
                        $elementKeyword arg2

                        $elementKeyword arg3
                    }
                """.trimIndent(),
                """
                    BlockStatement
                        Keyword $keyword
                        SingleLineStatement
                            Keyword $elementKeyword
                            Argument arg1
                        SingleLineStatement
                            Keyword $elementKeyword
                            Argument arg2
                        SingleLineStatement
                            Keyword $elementKeyword
                            Argument arg3
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `nested blocks`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            val (elementKeyword, _) = KEYWORDS_WITH_BLOCKS.random()
            assertPsiTree(
                """
                    $keyword {
                        $elementKeyword arg1 {
                        }
                        $elementKeyword arg2 {
                        }
                    }
                """.trimIndent(),
                """
                    BlockStatement
                        Keyword $keyword
                        BlockStatement
                            Keyword $elementKeyword
                            Argument arg1
                        BlockStatement
                            Keyword $elementKeyword
                            Argument arg2
                """.trimIndent()
            )
        }
    }
}
