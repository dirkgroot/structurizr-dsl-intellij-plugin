package nl.dirkgroot.structurizr.dsl.support

import com.intellij.psi.tree.IElementType
import nl.dirkgroot.structurizr.dsl.lang.SDLexerAdapter

fun String.tokenize(): Iterable<Pair<IElementType, String>> {
    val lexer = SDLexerAdapter()
    lexer.start(this)

    return generateSequence {
        val token = lexer.tokenType
        val text = lexer.tokenText
        lexer.advance()
        token?.let { token to text }
    }.toList()
}
