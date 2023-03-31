package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class SingleLineElementsTest : StructurizrDSLCodeInsightTest() {
    @TestFactory
    fun `without argument`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                keyword,
                """
                    SingleLineStatement
                        Keyword $keyword
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `with one argument`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                "$keyword arg1",
                """
                    SingleLineStatement
                        Keyword $keyword
                        Argument arg1
                """.trimIndent()
            )
        }
    }

    @TestFactory
    fun `with many arguments`() = KEYWORDS_WITH_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
            assertPsiTree(
                """$keyword arg1 "arg 2" arg3""",
                """
                    SingleLineStatement
                        Keyword $keyword
                        Argument arg1
                        Argument "arg 2"
                        Argument arg3
                """.trimIndent()
            )
        }
    }

    @Test
    fun `multiple single line elements`() {
        assertPsiTree(
            """
                !adrs docs/adrs
                !adrs other/stuff
             """.trimIndent(),
            """
                SingleLineStatement
                    Keyword !adrs
                    Argument docs/adrs
                SingleLineStatement
                    Keyword !adrs
                    Argument other/stuff
            """.trimIndent()
        )
    }
}
