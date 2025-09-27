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
class KeywordsWithPropertyBlocksTest(private val keyword: String, private val token: IElementType) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> =
            KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, token) -> arrayOf(keyword, token) }
    }

    @Test
    fun `properties block`() {
        """
            $keyword {
                name value
                "quoted name" "quoted value"
                properties description
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            QUOTED_TEXT to "\"quoted name\"",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"quoted value\"",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            UNQUOTED_TEXT to "properties",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "description",
            CRLF to "",
            WHITE_SPACE to "\n",
            BRACE2 to "}",
        )
    }

    @Test
    fun `properties block with line comments`() {
        """
            $keyword {
                // line comment
                name value // line comment
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            LINE_COMMENT to "// line comment",
            WHITE_SPACE to "\n    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "//",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "line",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "comment",
            CRLF to "",
            WHITE_SPACE to "\n",
            BRACE2 to "}",
        )
    }

    @Test
    fun `properties block with block comments`() {
        """
            $keyword {
                /* block comment */
                name value /* block comment */
                name /* block comment */ value
                /* block
                   comment */
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            BLOCK_COMMENT to "/* block comment */",
            WHITE_SPACE to "\n    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "/*",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "block",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "comment",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "*/",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "/*",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "block",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "comment",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "*/",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            CRLF to "",
            WHITE_SPACE to "\n    ",
            BLOCK_COMMENT to "/* block\n       comment */",
            WHITE_SPACE to "\n",
            BRACE2 to "}",
        )
    }
}
