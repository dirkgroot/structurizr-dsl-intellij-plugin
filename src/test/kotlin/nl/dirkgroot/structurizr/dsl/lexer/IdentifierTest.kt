package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class IdentifierTest : StringSpec({
    "valid individual token" {
        "valid_identifier".tokenize() shouldContainExactly listOf(IDENTIFIER to "valid_identifier")
    }

    "identifier assignment" {
        "valid_identifier = softwareSystem name".tokenize() shouldContainExactly listOf(
            IDENTIFIER to "valid_identifier",
            WHITE_SPACE to " ",
            EQUALS to "=",
            WHITE_SPACE to " ",
            SOFTWARE_SYSTEM_KEYWORD to "softwareSystem",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "name",
        )
    }
})
