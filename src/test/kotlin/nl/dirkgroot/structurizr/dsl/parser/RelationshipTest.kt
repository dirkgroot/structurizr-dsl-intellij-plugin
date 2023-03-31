package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class RelationshipTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `explicit without arguments`() {
        assertPsiTree(
            """a -> b""",
            """
                ExplicitRelationship
                    IdentifierName a
                    IdentifierName b
            """.trimIndent()
        )
    }

    @Test
    fun `implicit without arguments`() {
        assertPsiTree(
            """-> b""",
            """
                ImplicitRelationship
                    IdentifierName b
            """.trimIndent()
        )
    }

    @Test
    fun `explicit with arguments`() {
        assertPsiTree(
            """a -> b arg1 arg2""",
            """
                ExplicitRelationship
                    IdentifierName a
                    IdentifierName b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }

    @Test
    fun `implicit with arguments`() {
        assertPsiTree(
            """-> b arg1 arg2""",
            """
                ImplicitRelationship
                    IdentifierName b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }
}
