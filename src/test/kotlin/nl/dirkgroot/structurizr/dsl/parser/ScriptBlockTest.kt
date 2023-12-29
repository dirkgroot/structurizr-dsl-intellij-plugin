package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class ScriptBlockTest : StructurizrDSLCodeInsightTest() {
    fun `test empty script block`() {
        assertPsiTree(
            """
                !script {
                }
            """.trimIndent(),
            """
                ScriptStatement
                    ScriptKeyword !script
                    ScriptBlock {\n}
            """.trimIndent()
        )
    }

    fun `test empty script block with arguments`() {
        assertPsiTree(
            """
                !script kotlin arg2 {
                }
            """.trimIndent(),
            """
                ScriptStatement
                    ScriptKeyword !script
                    Argument kotlin
                    Argument arg2
                    ScriptBlock {\n}
            """.trimIndent()
        )
    }

    fun `test script block with content`() {
        assertPsiTree(
            """
                !script kotlin {
                    println("Hello World...")
                    println("...from a script block")
                }
            """.trimIndent(),
            """
                ScriptStatement
                    ScriptKeyword !script
                    Argument kotlin
                    ScriptBlock {\n    println("Hello World...")\n    println("...from a script block")\n}
            """.trimIndent()
        )
    }
}
