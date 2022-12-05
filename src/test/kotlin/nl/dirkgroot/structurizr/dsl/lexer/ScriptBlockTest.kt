package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class ScriptBlockTest : StringSpec({
    "arguments, no block" {
        "!script kotlin arg2 arg3".tokenize() shouldContainExactly listOf(
            SCRIPT_KEYWORD to "!script",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "kotlin",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "arg2",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "arg3",
        )
    }

    "no arguments, block" {
        """
            !script {
                some arbitrary code
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            SCRIPT_KEYWORD to "!script",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n",
            SCRIPT_TEXT to "    some arbitrary code",
            SCRIPT_TEXT to "\n",
            BRACE2 to "}"
        )
    }

    "arguments, block" {
        """
            !script kotlin {
                some arbitrary code
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            SCRIPT_KEYWORD to "!script",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "kotlin",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n",
            SCRIPT_TEXT to "    some arbitrary code",
            SCRIPT_TEXT to "\n",
            BRACE2 to "}"
        )
    }

    "indented block" {
        """
            |    !script {
            |        some arbitrary code
            |    }
        """.trimMargin().tokenize() shouldContainExactly listOf(
            WHITE_SPACE to "    ",
            SCRIPT_KEYWORD to "!script",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n",
            SCRIPT_TEXT to "        some arbitrary code",
            SCRIPT_TEXT to "\n",
            SCRIPT_TEXT to "    ",
            BRACE2 to "}"
        )
    }
})
