package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class CommentsTest {
    @Test
    fun `full line comment`() {
        "//".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//")
        "#".tokenize() shouldContainExactly listOf(LINE_COMMENT to "#")
        "//\n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//", CRLF to "\n")
        "  //\n".tokenize() shouldContainExactly listOf(WHITE_SPACE to "  ", LINE_COMMENT to "//", CRLF to "\n")
        "//   ".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//   ")
        "//   \n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//   ", CRLF to "\n")
        "// line comment".tokenize() shouldContainExactly listOf(LINE_COMMENT to "// line comment")
        "// line comment\n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "// line comment", CRLF to "\n")
    }

    @Test
    fun `line comment after other tokens`() {
        "description text // comment\n".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "//",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "comment",
            CRLF to "\n",
        )
    }

    @Test
    fun `block comment`() {
        "/* */".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* */")
        "/* **/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* **/")
        "/*\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/*\n*/")
        "/*text\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/*text\n*/")
        "/* text\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* text\n*/")
    }

    @Test
    fun `block comment between other tokens`() {
        "description /* */ text".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "/*",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "*/",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
        )
    }

    @Test
    fun `block comment between other tokens on successive lines`() {
        """
            description text /* */
            description
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "/*",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "*/",
            CRLF to "\n",
            UNQUOTED_TEXT to "description"
        )
    }

    @Test
    fun `unterminated block comment`() {
        """
            /*
            workspace
        """.trimIndent().tokenize() shouldContainExactly listOf(
            BLOCK_COMMENT to "/*\nworkspace",
        )
    }
}
