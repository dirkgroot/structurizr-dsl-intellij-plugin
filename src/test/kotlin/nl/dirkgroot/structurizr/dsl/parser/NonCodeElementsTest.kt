package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLParserTest
import org.junit.jupiter.api.Test

class NonCodeElementsTest : StructurizrDSLParserTest() {
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
        assertPsiTree("// comment", "PsiComment // comment")
    }

    @Test
    fun `line comments`() {
        assertPsiTree(
            """
                // comment
                // another comment
            """.trimIndent(),
            """
                PsiComment // comment
                LeafPsiElement \n
                PsiComment // another comment
            """.trimIndent()
        )
    }

    @Test
    fun `line comment with trailing newline`() {
        assertPsiTree(
            "// comment\n",
            """
                PsiComment // comment
                LeafPsiElement \n
            """.trimIndent()
        )
    }

    @Test
    fun `block comment single line`() {
        assertPsiTree(
            "/* block comment */",
            "PsiComment /* block comment */"
        )
    }

    @Test
    fun `block comment multiple lines`() {
        assertPsiTree(
            """
                /* block
                   comment */
            """.trimIndent(),
            """PsiComment /* block\n   comment */"""
        )
    }
}
