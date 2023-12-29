package nl.dirkgroot.structurizr.dsl.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import io.kotest.matchers.collections.shouldContainExactly
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.QUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.psi.SDTypes.UNQUOTED_TEXT
import nl.dirkgroot.structurizr.dsl.support.tokenize
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class KeywordsTest(private val keyword: String, private val token: IElementType) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> = KEYWORDS.map { (keyword, token) -> arrayOf(keyword, token) }
    }

    @Test
    fun `individual keyword`() {
        keyword.tokenize() shouldContainExactly listOf(token to keyword)
    }

    @Test
    fun `with unquoted argument`() {
        "$keyword unquoted_argument".tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "unquoted_argument",
        )
    }

    @Test
    fun `with quoted argument`() {
        "$keyword \"quoted artument\"".tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"quoted artument\"",
        )
    }

    @Test
    fun `with multiple arguments`() {
        "$keyword \"quoted artument\" unquoted_argument".tokenize() shouldContainExactly listOf(
            token to keyword,
            WHITE_SPACE to " ",
            QUOTED_TEXT to "\"quoted artument\"",
            WHITE_SPACE to " ",
            UNQUOTED_TEXT to "unquoted_argument",
        )
    }
}
