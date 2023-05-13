package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.*
import nl.dirkgroot.structurizr.dsl.support.tokenize

class HierarchicalIdentifiersTest : StringSpec({
    "one level" {
        "identifier1.child".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "identifier1.child"
        )
    }

    "as relationship destination" {
        "system1.frontend -> system2.backend description".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "system1.frontend",
            WHITE_SPACE to " ",
            ARROW to "->",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "system2.backend",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "description"
        )
    }
})
