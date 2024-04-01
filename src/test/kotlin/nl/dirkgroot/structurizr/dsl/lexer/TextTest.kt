package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class TextTest {
    @Test
    fun `unquoted text`() {
        "description unquoted text words".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "unquoted",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "words",
        )
    }

    @Test
    fun `quoted text`() {
        "description \"unquoted text words\"".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words\"",
        )
    }

    @Test
    fun `quoted text with escaped quote`() {
        "description \"unquoted \\\" text words\"".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted \\\" text words\"",
        )
    }

    @Test
    fun `multiline quoted text`() {
        "description \"unquoted \\\n text words\"".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted \\\n text words\"",
        )
    }

    @Test
    fun `quoted text with end of line`() {
        "description \"unquoted \n text words\"".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted ",
            CRLF to "\n",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "words",
            QUOTED_TEXT to "\""
        )
    }

    @Test
    fun `quoted text without closing quotes`() {
        "description \"unquoted text words".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words",
        )
    }

    @Test
    fun `quoted text without closing quotes and crlf`() {
        "description \"unquoted text words\n".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words",
            CRLF to "\n"
        )
    }

    @Test
    fun `unquoted text with curly braces inside`() {
        "description ${"$"}{SOME_CONSTANT}".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "${"$"}{SOME_CONSTANT}"
        )
    }
}
