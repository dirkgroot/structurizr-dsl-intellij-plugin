package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class CommentsTest : StringSpec({
    "full line comment" {
        "//".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//")
        "#".tokenize() shouldContainExactly listOf(LINE_COMMENT to "#")
        "//\n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//", CRLF to "\n")
        "  //\n".tokenize() shouldContainExactly listOf(WHITE_SPACE to "  ", LINE_COMMENT to "//", CRLF to "\n")
        "//   ".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//   ")
        "//   \n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "//   ", CRLF to "\n")
        "// line comment".tokenize() shouldContainExactly listOf(LINE_COMMENT to "// line comment")
        "// line comment\n".tokenize() shouldContainExactly listOf(LINE_COMMENT to "// line comment", CRLF to "\n")
    }

    "line comment after other tokens does not consume crlf" {
        "description text // comment\n".tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            LINE_COMMENT to "// comment",
            CRLF to "\n",
        )
    }

    "block comment" {
        "/* */".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* */")
        "/* **/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* **/")
        "/*\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/*\n*/")
        "/*text\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/*text\n*/")
        "/* text\n*/".tokenize() shouldContainExactly listOf(BLOCK_COMMENT to "/* text\n*/")
    }

    "block comment between other tokens" {
        "description /* */ text".tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to " ",
            BLOCK_COMMENT to "/* */",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
        )
    }

    "block comment between other tokens on successive lines" {
        """
            description text /* */
            description
        """.trimIndent().tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            BLOCK_COMMENT to "/* */",
            CRLF to "\n",
            DESCRIPTION_KEYWORD to "description"
        )
    }
})
