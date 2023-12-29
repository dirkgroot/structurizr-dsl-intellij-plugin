package nl.dirkgroot.structurizr.dsl.editing.formatter

class SpacingTest : FormatterTest() {
    fun `test arguments`() {
        assertFormattingResult(
            "softwareSystem  name  description",
            "softwareSystem name description"
        )
    }

    fun `test key value pair`() {
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

    fun `test identifier assignment`() {
        assertFormattingResult(
            """
                a   =   softwareSystem system
            """.trimIndent(),
            """
                a = softwareSystem system
            """.trimIndent()
        )
    }

    fun `test identifier references`() {
        assertFormattingResult(
            "a    b   c",
            "a b c"
        )
    }

    fun `test relationships`() {
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

    fun `test before opening brace`() {
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
