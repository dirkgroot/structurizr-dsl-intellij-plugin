package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class TextTest : StringSpec({
    "unquoted text" {
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

    "quoted text" {
        "description \"unquoted text words\"".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words\"",
        )
    }

    "quoted text without closing quotes" {
        "description \"unquoted text words".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words",
        )
    }

    "quoted text without closing quotes and crlf" {
        "description \"unquoted text words\n".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "description",
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"unquoted text words",
            CRLF to "\n"
        )
    }
})
