package nl.dirkgroot.structurizr.dsl.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import nl.dirkgroot.structurizr.dsl.StructurizrDSLLanguage
import nl.dirkgroot.structurizr.dsl.StructurizrDSLParser
import nl.dirkgroot.structurizr.dsl.psi.StructurizrDSLFile
import nl.dirkgroot.structurizr.dsl.psi.SDTypes

class StructurizrDSLParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)

        val FILE = IFileElementType(StructurizrDSLLanguage)
    }

    override fun createLexer(project: Project) = SDLexerAdapter()

    override fun getWhitespaceTokens() = WHITE_SPACES

    override fun getCommentTokens(): TokenSet = TokenSet.create(SDTypes.LINE_COMMENT, SDTypes.BLOCK_COMMENT)

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createParser(project: Project) = StructurizrDSLParser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = StructurizrDSLFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) =
        ParserDefinition.SpaceRequirements.MAY

    override fun createElement(node: ASTNode?): PsiElement = SDTypes.Factory.createElement(node)
}
