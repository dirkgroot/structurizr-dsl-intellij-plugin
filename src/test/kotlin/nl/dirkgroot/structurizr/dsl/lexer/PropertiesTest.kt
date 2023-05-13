package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class PropertiesTest : StringSpec({
    "properties block" {
        """
            properties {
                name value
                "quoted name" "quoted value"
                properties description
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "properties",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            QUOTED_TEXT to "\"quoted name\"",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"quoted value\"",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            UNQUOTED_TEXT to "properties",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "description",
            CRLF to "\n",
            BRACE2 to "}",
        )
    }

    "properties block with line comments" {
        """
            properties {
                // line comment
                name value // line comment
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "properties",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            LINE_COMMENT to "// line comment",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            UNQUOTED_TEXT to "name",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "value",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "//",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "line",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "comment",
            CRLF to "\n",
            BRACE2 to "}",
        )
    }

    "properties block with block comments" {
        """
            properties {
                /* block comment */
                name value /* block comment */
                name /* block comment */ value
                /* block
                   comment */
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "properties",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            CRLF to "\n",
            WHITE_SPACE to "    ",
            BLOCK_COMMENT to "/* block comment */",
            CRLF to "\n",
            WHITE_SPACE to "    ",
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
            CRLF to "\n",
            WHITE_SPACE to "    ",
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
            CRLF to "\n",
            WHITE_SPACE to "    ",
            BLOCK_COMMENT to "/* block\n       comment */",
            CRLF to "\n",
            BRACE2 to "}",
        )
    }
})
