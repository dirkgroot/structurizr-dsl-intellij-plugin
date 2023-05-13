package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class ScriptBlockTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `empty script block`() {
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

    @Test
    fun `empty script block with arguments`() {
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

    @Test
    fun `script block with content`() {
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
