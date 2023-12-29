package nl.dirkgroot.structurizr.dsl.lexer

import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test

class BracesTest {
    @Test
    fun `opening brace`() {
        "{".tokenize() shouldContainExactly listOf(SDTypes.BRACE1 to "{")
    }

    @Test
    fun `closing brace`() {
        "}".tokenize() shouldContainExactly listOf(SDTypes.BRACE2 to "}")
    }
}
