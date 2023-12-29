package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class KeywordsWithBlocksTest(private val keyword: String, private val token: IElementType) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> =
            KEYWORDS_WITH_BLOCKS.map { (keyword, token) -> arrayOf(keyword, token) }
    }

    @Test
    fun `with block`() {
        """
            $keyword name description {
                description description2
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "description2",
            CRLF to "\n",
            BRACE2 to "}"
        )
    }
}
