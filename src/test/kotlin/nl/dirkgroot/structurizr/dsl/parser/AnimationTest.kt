package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class AnimationTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `single identifier reference on one line`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier
                }
            """.trimIndent(),
            """
                AnimationBlock
                    AnimationKeyword animation
                    IdentifierReferences
                        IdentifierReference someIdentifier
            """.trimIndent()
        )
    }

    @Test
    fun `multiple identifier references on one line`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier1 someIdentifier2
                }
            """.trimIndent(),
            """
                AnimationBlock
                    AnimationKeyword animation
                    IdentifierReferences
                        IdentifierReference someIdentifier1
                        IdentifierReference someIdentifier2
            """.trimIndent()
        )
    }

    @Test
    fun `multiple lines with identifier references`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier1 someIdentifier2
                    someIdentifier3
                    someIdentifier4
                }
            """.trimIndent(),
            """
                AnimationBlock
                    AnimationKeyword animation
                    IdentifierReferences
                        IdentifierReference someIdentifier1
                        IdentifierReference someIdentifier2
                    IdentifierReferences
                        IdentifierReference someIdentifier3
                    IdentifierReferences
                        IdentifierReference someIdentifier4
            """.trimIndent()
        )
    }
}
