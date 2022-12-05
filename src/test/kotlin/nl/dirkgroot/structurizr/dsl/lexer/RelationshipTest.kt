package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.IDENTIFIER
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.RELATIONSHIP_KEYWORD
import nl.dirkgroot.structurizr.dsl.support.tokenize

class RelationshipTest : StringSpec({
    "basic form" {
        "system1 -> system2".tokenize() shouldContainExactly listOf(
            IDENTIFIER to "system1",
            WHITE_SPACE to " ",
            RELATIONSHIP_KEYWORD to "->",
            WHITE_SPACE to " ",
            IDENTIFIER to "system2",
        )
    }
})
