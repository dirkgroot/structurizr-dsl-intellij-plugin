package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.Test

class NonCodeElementsTest : StructurizrDSLCodeInsightTest() {
    @Test
    fun `empty line`() {
        assertPsiTree("\n", """PsiWhiteSpace \n""")
    }

    @Test
    fun `empty lines`() {
        assertPsiTree(
            "\n\n",
            """
                PsiWhiteSpace \n
                PsiWhiteSpace \n
            """.trimIndent()
        )
    }

    @Test
    fun `line comment`() {
        assertPsiTree(
            "// comment",
            """
                LineCommentStatement // comment
            """.trimIndent()
        )
    }

    @Test
    fun `line comments`() {
        assertPsiTree(
            """
                // comment
                // another comment
            """.trimIndent(),
            """
                LineCommentStatement // comment\n
                LineCommentStatement // another comment
            """.trimIndent()
        )
    }

    @Test
    fun `line comment with trailing newline`() {
        assertPsiTree(
            "// comment\n",
            """
                LineCommentStatement // comment\n
            """.trimIndent()
        )
    }

    @Test
    fun `block comment single line`() {
        assertPsiTree(
            "/* block comment */",
            """
                BlockCommentStatement /* block comment */
            """.trimIndent()
        )
    }

    @Test
    fun `block comment multiple lines`() {
        assertPsiTree(
            """
                /* block
                   comment */
            """.trimIndent(),
            """
                BlockCommentStatement /* block\n   comment */
            """.trimIndent()
        )
    }
}
