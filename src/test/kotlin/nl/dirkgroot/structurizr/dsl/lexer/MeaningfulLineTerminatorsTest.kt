package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class MeaningfulLineTerminatorsTest {
    @Test
    fun `carriage return`() {
        "description text\r".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            CRLF to "\r"
        )
    }

    @Test
    fun `line feed`() {
        "description text\n".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            CRLF to "\n"
        )
    }

    @Test
    fun `carriage return + line feed`() {
        "description text\r\n".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to (" "),
            UNQUOTED_TEXT to "text",
            CRLF to "\r\n"
        )
    }
}
