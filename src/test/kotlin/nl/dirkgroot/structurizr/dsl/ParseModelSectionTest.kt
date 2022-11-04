package nl.dirkgroot.structurizr.dsl

import org.junit.Test

class ParseModelSectionTest : StructurizrDSLParserTest() {
    @Test
    fun `plain model keyword`() {
        assertParseSucceeds(
            "model"
        )
    }

    @Test
    fun `empty model section`() {
        assertParseSucceeds(
            """
            model {
            }
            """.trimIndent()
        )
    }

    @Test
    fun `model section can have one or more child elements`() {
        assertParseSucceeds(
            """
            model {
                softwareSystem system
            }
            """.trimIndent()
        )
        assertParseSucceeds(
            """
            model {
                softwareSystem system1
                softwareSystem system2
                softwareSystem system3
            }
            """.trimIndent()
        )
    }
}
