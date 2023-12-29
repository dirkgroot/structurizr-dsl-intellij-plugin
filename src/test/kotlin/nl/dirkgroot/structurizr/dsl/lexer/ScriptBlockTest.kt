package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class ScriptBlockTest {
    @Test
    fun `arguments, no block`() {
        "!script kotlin arg2 arg3".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "!script",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "kotlin",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "arg2",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "arg3",
        )
    }

    @Test
    fun `no arguments, block`() {
        """
            !script {
                some arbitrary code
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "!script",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n    some arbitrary code\n",
            BRACE2 to "}"
        )
    }

    @Test
    fun `arguments, block`() {
        """
            !script kotlin {
                some arbitrary code
            }
        """.trimIndent().tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "!script",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "kotlin",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n    some arbitrary code\n",
            BRACE2 to "}"
        )
    }

    @Test
    fun `indented block`() {
        """
            |    !script {
            |        some arbitrary code
            |    }
        """.trimMargin().tokenize() shouldContainExactly listOf(
            WHITE_SPACE to "    ",
            UNQUOTED_TEXT to "!script",
            WHITE_SPACE to " ",
            BRACE1 to "{",
            SCRIPT_TEXT to "\n        some arbitrary code\n    ",
            BRACE2 to "}"
        )
    }
}
