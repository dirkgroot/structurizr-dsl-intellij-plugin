// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.dirkgroot.structurizr.dsl.psi.impl.*;

public interface SDTypes {

  IElementType ANIMATION_BLOCK = new SDElement("ANIMATION_BLOCK");
  IElementType ANIMATION_KEYWORD = new SDElement("ANIMATION_KEYWORD");
  IElementType ARGUMENT = new SDElement("ARGUMENT");
  IElementType BLOCK = new SDElement("BLOCK");
  IElementType BLOCK_COMMENT_STATEMENT = new SDElement("BLOCK_COMMENT_STATEMENT");
  IElementType BLOCK_STATEMENT = new SDElement("BLOCK_STATEMENT");
  IElementType EXPLICIT_RELATIONSHIP = new SDElement("EXPLICIT_RELATIONSHIP");
  IElementType IDENTIFIER_ASSIGNMENT = new SDElement("IDENTIFIER_ASSIGNMENT");
  IElementType IDENTIFIER_REFERENCE = new SDElement("IDENTIFIER_REFERENCE");
  IElementType IDENTIFIER_REFERENCES = new SDElement("IDENTIFIER_REFERENCES");
  IElementType IMPLICIT_RELATIONSHIP = new SDElement("IMPLICIT_RELATIONSHIP");
  IElementType KEYWORD = new SDElement("KEYWORD");
  IElementType LINE_COMMENT_STATEMENT = new SDElement("LINE_COMMENT_STATEMENT");
  IElementType PROPERTIES_BLOCK = new SDElement("PROPERTIES_BLOCK");
  IElementType PROPERTIES_DEFINITION = new SDElement("PROPERTIES_DEFINITION");
  IElementType PROPERTIES_KEYWORD = new SDElement("PROPERTIES_KEYWORD");
  IElementType PROPERTY_DEFINITION = new SDElement("PROPERTY_DEFINITION");
  IElementType PROPERTY_KEY = new SDElement("PROPERTY_KEY");
  IElementType PROPERTY_VALUE = new SDElement("PROPERTY_VALUE");
  IElementType RELATIONSHIP_DESTINATION = new SDElement("RELATIONSHIP_DESTINATION");
  IElementType RELATIONSHIP_KEYWORD = new SDElement("RELATIONSHIP_KEYWORD");
  IElementType RELATIONSHIP_SOURCE = new SDElement("RELATIONSHIP_SOURCE");
  IElementType SCRIPT_BLOCK = new SDElement("SCRIPT_BLOCK");
  IElementType SCRIPT_DEFINITION = new SDElement("SCRIPT_DEFINITION");
  IElementType SCRIPT_KEYWORD = new SDElement("SCRIPT_KEYWORD");
  IElementType SINGLE_LINE_STATEMENT = new SDElement("SINGLE_LINE_STATEMENT");

  IElementType ARROW = new SDToken("ARROW");
  IElementType BLOCK_COMMENT = new SDToken("BLOCK_COMMENT");
  IElementType BRACE1 = new SDToken("{");
  IElementType BRACE2 = new SDToken("}");
  IElementType CRLF = new SDToken("CRLF");
  IElementType EQUALS = new SDToken("=");
  IElementType LINE_COMMENT = new SDToken("LINE_COMMENT");
  IElementType QUOTED_TEXT = new SDToken("QUOTED_TEXT");
  IElementType SCRIPT_TEXT = new SDToken("SCRIPT_TEXT");
  IElementType UNQUOTED_TEXT = new SDToken("UNQUOTED_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANIMATION_BLOCK) {
        return new SDAnimationBlockImpl(node);
      }
      else if (type == ANIMATION_KEYWORD) {
        return new SDAnimationKeywordImpl(node);
      }
      else if (type == ARGUMENT) {
        return new SDArgumentImpl(node);
      }
      else if (type == BLOCK) {
        return new SDBlockImpl(node);
      }
      else if (type == BLOCK_COMMENT_STATEMENT) {
        return new SDBlockCommentStatementImpl(node);
      }
      else if (type == BLOCK_STATEMENT) {
        return new SDBlockStatementImpl(node);
      }
      else if (type == EXPLICIT_RELATIONSHIP) {
        return new SDExplicitRelationshipImpl(node);
      }
      else if (type == IDENTIFIER_ASSIGNMENT) {
        return new SDIdentifierAssignmentImpl(node);
      }
      else if (type == IDENTIFIER_REFERENCE) {
        return new SDIdentifierReferenceImpl(node);
      }
      else if (type == IDENTIFIER_REFERENCES) {
        return new SDIdentifierReferencesImpl(node);
      }
      else if (type == IMPLICIT_RELATIONSHIP) {
        return new SDImplicitRelationshipImpl(node);
      }
      else if (type == KEYWORD) {
        return new SDKeywordImpl(node);
      }
      else if (type == LINE_COMMENT_STATEMENT) {
        return new SDLineCommentStatementImpl(node);
      }
      else if (type == PROPERTIES_BLOCK) {
        return new SDPropertiesBlockImpl(node);
      }
      else if (type == PROPERTIES_DEFINITION) {
        return new SDPropertiesDefinitionImpl(node);
      }
      else if (type == PROPERTIES_KEYWORD) {
        return new SDPropertiesKeywordImpl(node);
      }
      else if (type == PROPERTY_DEFINITION) {
        return new SDPropertyDefinitionImpl(node);
      }
      else if (type == PROPERTY_KEY) {
        return new SDPropertyKeyImpl(node);
      }
      else if (type == PROPERTY_VALUE) {
        return new SDPropertyValueImpl(node);
      }
      else if (type == RELATIONSHIP_DESTINATION) {
        return new SDRelationshipDestinationImpl(node);
      }
      else if (type == RELATIONSHIP_KEYWORD) {
        return new SDRelationshipKeywordImpl(node);
      }
      else if (type == RELATIONSHIP_SOURCE) {
        return new SDRelationshipSourceImpl(node);
      }
      else if (type == SCRIPT_BLOCK) {
        return new SDScriptBlockImpl(node);
      }
      else if (type == SCRIPT_DEFINITION) {
        return new SDScriptDefinitionImpl(node);
      }
      else if (type == SCRIPT_KEYWORD) {
        return new SDScriptKeywordImpl(node);
      }
      else if (type == SINGLE_LINE_STATEMENT) {
        return new SDSingleLineStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
