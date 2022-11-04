package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.lexer.FlexAdapter
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLexer

class SDLexerAdapter : FlexAdapter(StructurizrDSLLexer())
