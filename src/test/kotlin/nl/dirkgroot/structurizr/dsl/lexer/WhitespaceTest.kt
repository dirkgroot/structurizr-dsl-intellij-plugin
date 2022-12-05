package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.support.tokenize

class WhitespaceTest : StringSpec({
    "empty lines" {
        "\n   \n\t\u000c\n".tokenize() shouldContainExactly listOf(
            TokenType.WHITE_SPACE to "\n",
            TokenType.WHITE_SPACE to "   \n",
            TokenType.WHITE_SPACE to "\t\u000c\n"
        )
    }

    "whitespace" {
        " \t\u000c".tokenize() shouldContainExactly listOf(TokenType.WHITE_SPACE to " \t\u000c")
    }
})
