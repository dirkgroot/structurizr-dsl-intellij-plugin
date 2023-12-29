package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class RelationshipTest : StructurizrDSLCodeInsightTest() {
    fun `test explicit without arguments`() {
        assertPsiTree(
            """a -> b""",
            """
                ExplicitRelationshipStatement
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
            """.trimIndent()
        )
    }

    fun `test implicit without arguments`() {
        assertPsiTree(
            """-> b""",
            """
                ImplicitRelationshipStatement
                    RelationshipKeyword ->
                    RelationshipDestination b
            """.trimIndent()
        )
    }

    fun `test explicit with arguments`() {
        assertPsiTree(
            """a -> b arg1 arg2""",
            """
                ExplicitRelationshipStatement
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }

    fun `test explicit relationship with block`() {
        assertPsiTree(
            """
                a -> b arg1 {
                }
            """.trimIndent(),
            """
                ExplicitRelationshipStatement
                    RelationshipSource a
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Block {\n}
            """.trimIndent()
        )
    }

    fun `test implicit with arguments`() {
        assertPsiTree(
            """-> b arg1 arg2""",
            """
                ImplicitRelationshipStatement
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Argument arg2
            """.trimIndent()
        )
    }

    fun `test implicit relationship with block`() {
        assertPsiTree(
            """
                -> b arg1 {
                }
            """.trimIndent(),
            """
                ImplicitRelationshipStatement
                    RelationshipKeyword ->
                    RelationshipDestination b
                    Argument arg1
                    Block {\n}
            """.trimIndent()
        )
    }
}
