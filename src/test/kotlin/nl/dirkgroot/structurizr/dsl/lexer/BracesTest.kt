package nl.dirkgroot.structurizr.dsl.lexer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes
import nl.dirkgroot.structurizr.dsl.support.tokenize

class BracesTest : StringSpec({
    "opening brace" { "{".tokenize() shouldContainExactly listOf(SDTypes.BRACE1 to "{") }
    "closing brace" { "}".tokenize() shouldContainExactly listOf(SDTypes.BRACE2 to "}") }
})
