package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class HighlightingAnnotatorTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `generic keyword`() {
        checkHighlighting("${asKeyword("softwareSystem")} name")
    }

    @Test
    fun `properties keyword`() {
        checkHighlighting(
            """
                ${asKeyword("properties")} {
                }
            """.trimIndent()
        )
    }

    @Test
    fun `script keyword`() {
        checkHighlighting(
            """
                ${asKeyword("!script")} kotlin {
                }
            """.trimIndent()
        )
    }

    @Test
    fun `script contents`() {
        checkHighlighting(
            """
                !script kotlin ${highlight("{\nsome kotlin code\n}", "INJECTED_LANGUAGE_FRAGMENT")}
            """.trimIndent()
        )
    }

    @Test
    fun `relationship keyword`() {
        checkHighlighting("a ${asKeyword("->")} b uses")
    }

    @Test
    fun `animation keyword`() {
        checkHighlighting(
            """
                ${asKeyword("animation")} {
                }
            """.trimIndent()
        )
    }

    @Test
    fun arguments() {
        checkHighlighting("container ${asString("unquoted")} ${asString("\"quoted\"")}")
    }

    @Test
    fun `property definitions`() {
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

    @Test
    fun `relationship identifiers`() {
        checkHighlighting(
            """
                -> ${asIdentifier("destination")} uses
                ${asIdentifier("source")} -> ${asIdentifier("destination")} uses
            """.trimIndent()
        )
    }

    @Test
    fun `identifier definition`() {
        checkHighlighting("${asIdentifier("someId")} = container name")
    }

    private fun checkHighlighting(code: String) {
        fixture.configureByText("test.dsl", code)
        fixture.checkHighlighting(false, true, false, true)
    }

    private fun asKeyword(keyword: String) = highlight(keyword, "DEFAULT_KEYWORD")

    private fun asString(string: String) = highlight(string, "DEFAULT_STRING")

    private fun asIdentifier(identifier: String) = highlight(identifier, "DEFAULT_IDENTIFIER")

    private fun highlight(keyword: String, textAttributesKey: String) =
        """<info descr="null" textAttributesKey="$textAttributesKey">$keyword</info>"""
}
