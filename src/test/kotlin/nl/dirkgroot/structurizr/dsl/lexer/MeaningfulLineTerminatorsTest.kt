package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class MeaningfulLineTerminatorsTest : StringSpec({
    "carriage return" {
        "description text\r".tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            CRLF to "\r"
        )
    }

    "line feed" {
        "description text\n".tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "text",
            CRLF to "\n"
        )
    }

    "carriage return + line feed" {
        "description text\r\n".tokenize() shouldContainExactly listOf(
            DESCRIPTION_KEYWORD to "description",
            WHITE_SPACE to (" "),
            UNQUOTED_TEXT to "text",
            CRLF to "\r\n"
        )
    }
})
