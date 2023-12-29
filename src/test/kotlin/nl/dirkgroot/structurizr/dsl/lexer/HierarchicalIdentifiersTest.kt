package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.ARROW
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class HierarchicalIdentifiersTest {
    @Test
    fun `one level`() {
        "identifier1.child".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "identifier1.child"
        )
    }

    @Test
    fun `as relationship destination`() {
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
}
