package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class NonCodeElementsTest : StructurizrDSLCodeInsightTest() {
    fun `test empty line`() {
        assertPsiTree("\n", """PsiWhiteSpace \n""")
    }

    fun `test empty lines`() {
        assertPsiTree(
            "\n\n",
            """
                PsiWhiteSpace \n\n
            """.trimIndent()
        )
    }

    fun `test line comment`() {
        assertPsiTree(
            "// comment",
            """
                PsiComment // comment
            """.trimIndent()
        )
    }

    fun `test line comments`() {
        assertPsiTree(
            """
                // comment
                // another comment
            """.trimIndent(),
            """
                PsiComment // comment
                PsiWhiteSpace \n
                PsiComment // another comment
            """.trimIndent()
        )
    }

    fun `test line comment with trailing newline`() {
        assertPsiTree(
            "// comment\n",
            """
                PsiComment // comment
                PsiWhiteSpace \n
            """.trimIndent()
        )
    }

    fun `test block comment single line`() {
        assertPsiTree(
            "/* block comment */",
            """
                PsiComment /* block comment */
            """.trimIndent()
        )
    }

    fun `test block comment multiple lines`() {
        assertPsiTree(
            """
                /* block
                   comment */
            """.trimIndent(),
            """
                PsiComment /* block\n   comment */
            """.trimIndent()
        )
    }
}
