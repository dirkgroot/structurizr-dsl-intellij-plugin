package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class AnimationTest : StructurizrDSLCodeInsightTest() {
    fun `test single identifier reference on one line`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier
                }
            """.trimIndent(),
            """
                AnimationStatement
                    AnimationKeyword animation
                    AnimationBlock
                        IdentifierReferencesStatement
                            IdentifierReference someIdentifier
            """.trimIndent()
        )
    }

    fun `test multiple identifier references on one line`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier1 someIdentifier2
                }
            """.trimIndent(),
            """
                AnimationStatement
                    AnimationKeyword animation
                    AnimationBlock
                        IdentifierReferencesStatement
                            IdentifierReference someIdentifier1
                            IdentifierReference someIdentifier2
            """.trimIndent()
        )
    }

    fun `test multiple lines with identifier references`() {
        assertPsiTree(
            """
                animation {
                    someIdentifier1 someIdentifier2
                    someIdentifier3
                    someIdentifier4
                }
            """.trimIndent(),
            """
                AnimationStatement
                    AnimationKeyword animation
                    AnimationBlock
                        IdentifierReferencesStatement
                            IdentifierReference someIdentifier1
                            IdentifierReference someIdentifier2
                        IdentifierReferencesStatement
                            IdentifierReference someIdentifier3
                        IdentifierReferencesStatement
                            IdentifierReference someIdentifier4
            """.trimIndent()
        )
    }
}
