package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SingleLineElementsTest(private val keyword: String) : StructurizrDSLCodeInsightTest() {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> = KEYWORDS_WITH_BLOCKS.map { (keyword, _) -> arrayOf(keyword) }
    }

    @Test
    fun `without argument`() {
        assertPsiTree(
            keyword,
            """
                SingleLineStatement
                    Keyword $keyword
            """.trimIndent()
        )
    }

    @Test
    fun `with one argument`() {
        assertPsiTree(
            "$keyword arg1",
            """
                SingleLineStatement
                    Keyword $keyword
                    Argument arg1
            """.trimIndent()
        )
    }

    @Test
    fun `with many arguments`() {
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
