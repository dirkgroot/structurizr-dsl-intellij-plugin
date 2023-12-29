package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.ARROW
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class RelationshipTest {
    @Test
    fun `basic form`() {
        "system1 -> system2".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "system1",
            WHITE_SPACE to " ",
            ARROW to "->",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "system2",
        )
    }
}
