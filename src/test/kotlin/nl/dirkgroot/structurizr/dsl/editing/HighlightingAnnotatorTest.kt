package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class HighlightingAnnotatorTest : StructurizrDSLCodeInsightTest() {
    fun `test generic keyword`() {
        checkHighlighting("${asKeyword("softwareSystem")} name")
    }

    fun `test properties keyword`() {
        checkHighlighting(
            """
                ${asKeyword("properties")} {
                }
            """.trimIndent()
        )
    }

    fun `test script keyword`() {
        checkHighlighting(
            """
                ${asKeyword("!script")} kotlin {
                }
            """.trimIndent()
        )
    }

    fun `test script contents`() {
        checkHighlighting(
            """
                !script kotlin ${highlight("{\nsome kotlin code\n}", "INJECTED_LANGUAGE_FRAGMENT")}
            """.trimIndent()
        )
    }

    fun `test relationship keyword`() {
        checkHighlighting("a ${asKeyword("->")} b uses")
    }

    fun `test animation keyword`() {
        checkHighlighting(
            """
                ${asKeyword("animation")} {
                }
            """.trimIndent()
        )
    }

    fun `test arguments`() {
        checkHighlighting("container ${asString("unquoted")} ${asString("\"quoted\"")}")
    }

    fun `test property definitions`() {
        checkHighlighting(
            """
                properties {
                    ${asString("key1")} ${asString("value1")}
                    ${asString("\"key 2\"")} ${asString("value2")}
                    ${asString("key3")} ${asString("\"value 3\"")}
                    ${asString("\"key 4\"")} ${asString("\"value 4\"")}
                }
            """.trimIndent()
        )
    }

    fun `test relationship identifiers`() {
        checkHighlighting(
            """
                -> ${asIdentifier("destination")} uses
                ${asIdentifier("source")} -> ${asIdentifier("destination")} uses
            """.trimIndent()
        )
    }

    fun `test identifier definition`() {
        checkHighlighting("${asIdentifier("someId")} = container name")
    }

    private fun checkHighlighting(code: String) {
        myFixture.configureByText("test.dsl", code)
        myFixture.checkHighlighting(false, true, false, true)
    }

    private fun asKeyword(keyword: String) = highlight(keyword, "DEFAULT_KEYWORD")

    private fun asString(string: String) = highlight(string, "DEFAULT_STRING")

    private fun asIdentifier(identifier: String) = highlight(identifier, "DEFAULT_IDENTIFIER")

    private fun highlight(keyword: String, textAttributesKey: String) =
        """<info descr="null" textAttributesKey="$textAttributesKey">$keyword</info>"""
}
