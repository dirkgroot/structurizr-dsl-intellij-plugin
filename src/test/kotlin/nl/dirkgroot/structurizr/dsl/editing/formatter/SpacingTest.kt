package nl.dirkgroot.structurizr.dsl.editing.formatter

import org.junit.jupiter.api.Test

class SpacingTest : FormatterTest() {
    @Test
    fun arguments() {
        assertFormattingResult(
            "softwareSystem  name  description",
            "softwareSystem name description"
        )
    }

    @Test
    fun `key value pair`() {
        assertFormattingResult(
            """
                properties {
                    a       b
                    c   d
                }
            """.trimIndent(),
            """
                properties {
                    a b
                    c d
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `identifier assignment`() {
        assertFormattingResult(
            """
                a=softwareSystem system
            """.trimIndent(),
            """
                a = softwareSystem system
            """.trimIndent()
        )
    }

    @Test
    fun `identifier references`() {
        assertFormattingResult(
            "a    b   c",
            "a b c"
        )
    }

    @Test
    fun relationships() {
        assertFormattingResult(
            """
                a   ->  b   Uses
                ->   b  "Uses"
            """.trimIndent(),
            """
                a -> b Uses
                -> b "Uses"
            """.trimIndent()
        )
    }

    @Test
    fun `before opening brace`() {
        assertFormattingResult(
            """
                properties    {
                }
            """.trimIndent(),
            """
                properties {
                }
            """.trimIndent()
        )
    }
}
