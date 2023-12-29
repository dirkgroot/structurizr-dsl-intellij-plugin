package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.EQUALS
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class IdentifierTest {
    @Test
    fun `valid individual token`() {
        "valid_identifier".tokenize() shouldContainExactly listOf(UNQUOTED_TEXT to "valid_identifier")
    }

    @Test
    fun `identifier assignment`() {
        "valid_identifier = softwareSystem name".tokenize() shouldContainExactly listOf(
            UNQUOTED_TEXT to "valid_identifier",
            WHITE_SPACE to " ",
            EQUALS to "=",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "softwareSystem",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "name",
        )
    }
}
