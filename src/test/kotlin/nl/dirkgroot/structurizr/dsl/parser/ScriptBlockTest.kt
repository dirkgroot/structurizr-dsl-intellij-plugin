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
                ScriptBlock
                    ScriptContents \n
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
                ScriptBlock
                    Argument kotlin
                    Argument arg2
                    ScriptContents \n
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
                ScriptBlock
                    Argument kotlin
                    ScriptContents \n    println("Hello World...")\n    println("...from a script block")\n
            """.trimIndent()
        )
    }
}
