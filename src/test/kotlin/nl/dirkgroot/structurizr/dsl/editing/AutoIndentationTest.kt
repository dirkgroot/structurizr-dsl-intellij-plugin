package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class AutoIndentationTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `on a new block`() {
        checkEditor(
            """
                workspace <caret>
            """.trimIndent(),
            "{\n",
            """
                workspace {
                    <caret>
                }
            """.trimIndent()
        )
    }

    @Test
    fun `on an existing empty block`() {
        checkEditor(
            """
                workspace {<caret>
                }
            """.trimIndent(),
            "\n",
            """
                workspace {
                    <caret>
                }
            """.trimIndent()
        )
    }

    @Test
    fun `on an existing non-empty block`() {
        checkEditor(
            """
                workspace {<caret>
                    model {
                    }
                }
            """.trimIndent(),
            "\n",
            """
                workspace {
                    <caret>
                    model {
                    }
                }
            """.trimIndent()
        )
    }

    @Test
    fun `inside an existing non-empty block`() {
        checkEditor(
            """
                workspace {
                    model {
                    }<caret>
                }
            """.trimIndent(),
            "\n",
            """
                workspace {
                    model {
                    }
                    <caret>
                }
            """.trimIndent()
        )
    }

    private fun checkEditor(initialState: String, type: String, expectedState: String) {
        fixture.configureByText("test.dsl", initialState)
        fixture.type(type)
        fixture.checkResult(expectedState)
    }
}
