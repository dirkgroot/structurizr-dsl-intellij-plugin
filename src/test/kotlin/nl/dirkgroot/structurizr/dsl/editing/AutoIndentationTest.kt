package nl.dirkgroot.structurizr.dsl.editing

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class AutoIndentationTest : StructurizrDSLCodeInsightTest() {
    fun `test on a new block`() {
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

    fun `test on an existing empty block`() {
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

    fun `test on an existing non-empty block`() {
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

    fun `test inside an existing non-empty block`() {
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

    fun `test on a raw block`() {
        checkEditor(
            """
                dynamic * {
                    <caret>
                }
            """.trimIndent(),
            "{",
            """
                dynamic * {
                    {<caret>}
                }
            """.trimIndent()
        )
    }

    private fun checkEditor(initialState: String, type: String, expectedState: String) {
        myFixture.configureByText("test.dsl", initialState)
        myFixture.type(type)
        myFixture.checkResult(expectedState)
    }
}
