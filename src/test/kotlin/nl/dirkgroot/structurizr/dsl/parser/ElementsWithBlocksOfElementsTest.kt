package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ElementsWithBlocksOfElementsTest(private val keyword: String) : StructurizrDSLCodeInsightTest() {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> = KEYWORDS_WITH_BLOCKS.map { (keyword, _) -> arrayOf(keyword) }
    }

    @Test
    fun `empty block`() {
        assertPsiTree(
            """
                $keyword {
                }
            """.trimIndent(),
            """
                BlockStatement
                    Keyword $keyword
                    Block {\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with only empty lines inside`() {
        assertPsiTree(
            """
                $keyword {


                }
            """.trimIndent(),
            """
                BlockStatement
                    Keyword $keyword
                    Block {\n\n\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with single line element inside`() {
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
                    Block
                        SingleLineStatement
                            Keyword $elementKeyword
                            Argument arg1
            """.trimIndent()
        )
    }

    @Test
    fun `block with multiple single line elements inside`() {
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
                    Block
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

    @Test
    fun `nested blocks`() {
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
                    Block
                        BlockStatement
                            Keyword $elementKeyword
                            Argument arg1
                            Block {\n    }
                        BlockStatement
                            Keyword $elementKeyword
                            Argument arg2
                            Block {\n    }
            """.trimIndent()
        )
    }
}
