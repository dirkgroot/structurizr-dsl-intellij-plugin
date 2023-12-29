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
                PsiWhiteSpace \n
                PsiWhiteSpace \n
            """.trimIndent()
        )
    }

    fun `test line comment`() {
        assertPsiTree(
            "// comment",
            """
                LineCommentStatement // comment
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
                LineCommentStatement // comment\n
                LineCommentStatement // another comment
            """.trimIndent()
        )
    }

    fun `test line comment with trailing newline`() {
        assertPsiTree(
            "// comment\n",
            """
                LineCommentStatement // comment\n
            """.trimIndent()
        )
    }

    fun `test block comment single line`() {
        assertPsiTree(
            "/* block comment */",
            """
                BlockCommentStatement /* block comment */
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
                BlockCommentStatement /* block\n   comment */
            """.trimIndent()
        )
    }
}
