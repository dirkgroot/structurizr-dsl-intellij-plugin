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
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
            """.trimIndent()
        )
    }

    @Test
    fun `implicit without arguments`() {
        assertPsiTree(
            """-> b""",
            """
                ImplicitRelationship
                    RelationshipKeyword ->
                    RelationshipDestination b
            """.trimIndent()
        )
    }

    @Test
    fun `explicit with arguments`() {
        assertPsiTree(
            """a -> b arg1 arg2""",
            """
                ExplicitRelationship
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }

    @Test
    fun `explicit relationship with block`() {
        assertPsiTree(
            """
                a -> b arg1 {
                }
            """.trimIndent(),
            """
                ExplicitRelationship
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Block {\n}
            """.trimIndent()
        )
    }

    @Test
    fun `implicit with arguments`() {
        assertPsiTree(
            """-> b arg1 arg2""",
            """
                ImplicitRelationship
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }

    @Test
    fun `implicit relationship with block`() {
        assertPsiTree(
            """
                -> b arg1 {
                }
            """.trimIndent(),
            """
                ImplicitRelationship
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Block {\n}
            """.trimIndent()
        )
    }
}
