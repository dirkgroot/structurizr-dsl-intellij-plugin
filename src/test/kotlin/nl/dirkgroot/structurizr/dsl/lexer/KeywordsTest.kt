package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class KeywordsTest : FunSpec({
    KEYWORDS.forEach { (keyword, token) ->
        test("\"$keyword\" - individual keyword") {
            keyword.tokenize() shouldContainExactly listOf(token to keyword)
        }

        test("\"$keyword\" - with unquoted argument") {
            "$keyword unquoted_argument".tokenize() shouldContainExactly listOf(
                token to keyword,
                WHITE_SPACE to " ",
                UNQUOTED_TEXT to "unquoted_argument",
            )
        }

        test("\"$keyword\" - with quoted argument") {
            "$keyword \"quoted artument\"".tokenize() shouldContainExactly listOf(
                token to keyword,
                WHITE_SPACE to " ",
                QUOTED_TEXT to "\"quoted artument\"",
            )
        }

        test("\"$keyword\" - with multiple arguments") {
            "$keyword \"quoted artument\" unquoted_argument".tokenize() shouldContainExactly listOf(
                token to keyword,
                WHITE_SPACE to " ",
                QUOTED_TEXT to "\"quoted artument\"",
                WHITE_SPACE to " ",
                UNQUOTED_TEXT to "unquoted_argument",
            )
        }
    }

    KEYWORDS_WITH_BLOCKS.forEach { (keyword, token) ->
        test("\"$keyword\" - with block") {
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
                DESCRIPTION_KEYWORD to "description",
                WHITE_SPACE to " ",
                UNQUOTED_TEXT to "description2",
                CRLF to "\n",
                BRACE2 to "}"
            )
        }
    }

    KEYWORDS_WITH_PROPERTY_BLOCKS.forEach { (keyword, token) ->
        test("\"$keyword\" - properties block") {
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

        test("\"$keyword\" - properties block with line comments") {
            """
                $keyword {
                    // line comment
                    name value // line comment
                }
            """.trimIndent().tokenize() shouldContainExactly listOf(
                token to keyword,
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
                LINE_COMMENT to "// line comment",
                CRLF to "\n",
                BRACE2 to "}",
            )
        }

        test("\"$keyword\" - properties block with block comments") {
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
                CRLF to "\n",
                WHITE_SPACE to "    ",
                BLOCK_COMMENT to "/* block comment */",
                CRLF to "\n",
                WHITE_SPACE to "    ",
                UNQUOTED_TEXT to "name",
                WHITE_SPACE to " ",
                UNQUOTED_TEXT to "value",
                WHITE_SPACE to " ",
                BLOCK_COMMENT to "/* block comment */",
                CRLF to "\n",
                WHITE_SPACE to "    ",
                UNQUOTED_TEXT to "name",
                WHITE_SPACE to " ",
                BLOCK_COMMENT to "/* block comment */",
                WHITE_SPACE to " ",
                UNQUOTED_TEXT to "value",
                CRLF to "\n",
                WHITE_SPACE to "    ",
                BLOCK_COMMENT to "/* block\n       comment */",
                CRLF to "\n",
                BRACE2 to "}",
            )
        }
    }
})
