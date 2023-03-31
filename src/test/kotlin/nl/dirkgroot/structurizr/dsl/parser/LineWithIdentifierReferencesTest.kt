package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class LineWithIdentifierReferencesTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `single identifier reference on one line`() {
        assertPsiTree(
            """
                someIdentifier
            """.trimIndent(),
            """
                IdentifierReferences
                    IdentifierName someIdentifier
            """.trimIndent()
        )
    }

    @Test
    fun `multiple identifier references on one line`() {
        assertPsiTree(
            """
                someIdentifier1 someIdentifier2
            """.trimIndent(),
            """
                IdentifierReferences
                    IdentifierName someIdentifier1
                    IdentifierName someIdentifier2
            """.trimIndent()
        )
    }

    @Test
    fun `multiple lines with identifier references`() {
        assertPsiTree(
            """
                someIdentifier1 someIdentifier2
                someIdentifier3
                someIdentifier4
            """.trimIndent(),
            """
                IdentifierReferences
                    IdentifierName someIdentifier1
                    IdentifierName someIdentifier2
                IdentifierReferences
                    IdentifierName someIdentifier3
                IdentifierReferences
                    IdentifierName someIdentifier4
            """.trimIndent()
        )
    }
}
