package nl.dirkgroot.structurizr.dsl.lexer

import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class CaseInsensitiveTest {
    @Test
    fun `lexer is case insensitive`() {
        "WoRKSpacE".tokenize() shouldContainExactly listOf(UNQUOTED_TEXT to "WoRKSpacE")
    }
}
