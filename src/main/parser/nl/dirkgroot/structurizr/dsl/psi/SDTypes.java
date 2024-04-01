// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.dirkgroot.structurizr.dsl.psi.impl.*;

public interface SDTypes {

  IElementType ANIMATION_BLOCK = new SDElement("ANIMATION_BLOCK");
  IElementType ANIMATION_KEYWORD = new SDElement("ANIMATION_KEYWORD");
  IElementType ANIMATION_STATEMENT = new SDElement("ANIMATION_STATEMENT");
  IElementType ARGUMENT = new SDElement("ARGUMENT");
  IElementType BLOCK = new SDElement("BLOCK");
  IElementType BLOCK_STATEMENT = new SDElement("BLOCK_STATEMENT");
  IElementType EXPLICIT_RELATIONSHIP_STATEMENT = new SDElement("EXPLICIT_RELATIONSHIP_STATEMENT");
  IElementType IDENTIFIER_ASSIGNMENT_STATEMENT = new SDElement("IDENTIFIER_ASSIGNMENT_STATEMENT");
  IElementType IDENTIFIER_REFERENCE = new SDElement("IDENTIFIER_REFERENCE");
  IElementType IDENTIFIER_REFERENCES_STATEMENT = new SDElement("IDENTIFIER_REFERENCES_STATEMENT");
  IElementType IMPLICIT_RELATIONSHIP_STATEMENT = new SDElement("IMPLICIT_RELATIONSHIP_STATEMENT");
  IElementType KEYWORD = new SDElement("KEYWORD");
  IElementType PROPERTIES_BLOCK = new SDElement("PROPERTIES_BLOCK");
  IElementType PROPERTIES_KEYWORD = new SDElement("PROPERTIES_KEYWORD");
  IElementType PROPERTIES_STATEMENT = new SDElement("PROPERTIES_STATEMENT");
  IElementType PROPERTY_DEFINITION = new SDElement("PROPERTY_DEFINITION");
  IElementType PROPERTY_DEFINITION_PART = new SDElement("PROPERTY_DEFINITION_PART");
  IElementType RAW_BLOCK_STATEMENT = new SDElement("RAW_BLOCK_STATEMENT");
  IElementType RELATIONSHIP_DESTINATION = new SDElement("RELATIONSHIP_DESTINATION");
  IElementType RELATIONSHIP_KEYWORD = new SDElement("RELATIONSHIP_KEYWORD");
  IElementType RELATIONSHIP_SOURCE = new SDElement("RELATIONSHIP_SOURCE");
  IElementType SCRIPT_BLOCK = new SDElement("SCRIPT_BLOCK");
  IElementType SCRIPT_KEYWORD = new SDElement("SCRIPT_KEYWORD");
  IElementType SCRIPT_STATEMENT = new SDElement("SCRIPT_STATEMENT");
  IElementType SINGLE_LINE_STATEMENT = new SDElement("SINGLE_LINE_STATEMENT");
  IElementType STATEMENT = new SDElement("STATEMENT");

  IElementType ARROW = new SDToken("->");
  IElementType BLOCK_COMMENT = new SDToken("block_comment");
  IElementType BRACE1 = new SDToken("{");
  IElementType BRACE2 = new SDToken("}");
  IElementType CRLF = new SDToken("CRLF");
  IElementType EQUALS = new SDToken("=");
  IElementType LINE_COMMENT = new SDToken("line_comment");
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
      else if (type == ANIMATION_STATEMENT) {
        return new SDAnimationStatementImpl(node);
      }
      else if (type == ARGUMENT) {
        return new SDArgumentImpl(node);
      }
      else if (type == BLOCK) {
        return new SDBlockImpl(node);
      }
      else if (type == BLOCK_STATEMENT) {
        return new SDBlockStatementImpl(node);
      }
      else if (type == EXPLICIT_RELATIONSHIP_STATEMENT) {
        return new SDExplicitRelationshipStatementImpl(node);
      }
      else if (type == IDENTIFIER_ASSIGNMENT_STATEMENT) {
        return new SDIdentifierAssignmentStatementImpl(node);
      }
      else if (type == IDENTIFIER_REFERENCE) {
        return new SDIdentifierReferenceImpl(node);
      }
      else if (type == IDENTIFIER_REFERENCES_STATEMENT) {
        return new SDIdentifierReferencesStatementImpl(node);
      }
      else if (type == IMPLICIT_RELATIONSHIP_STATEMENT) {
        return new SDImplicitRelationshipStatementImpl(node);
      }
      else if (type == KEYWORD) {
        return new SDKeywordImpl(node);
      }
      else if (type == PROPERTIES_BLOCK) {
        return new SDPropertiesBlockImpl(node);
      }
      else if (type == PROPERTIES_KEYWORD) {
        return new SDPropertiesKeywordImpl(node);
      }
      else if (type == PROPERTIES_STATEMENT) {
        return new SDPropertiesStatementImpl(node);
      }
      else if (type == PROPERTY_DEFINITION) {
        return new SDPropertyDefinitionImpl(node);
      }
      else if (type == PROPERTY_DEFINITION_PART) {
        return new SDPropertyDefinitionPartImpl(node);
      }
      else if (type == RAW_BLOCK_STATEMENT) {
        return new SDRawBlockStatementImpl(node);
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
      else if (type == SCRIPT_KEYWORD) {
        return new SDScriptKeywordImpl(node);
      }
      else if (type == SCRIPT_STATEMENT) {
        return new SDScriptStatementImpl(node);
      }
      else if (type == SINGLE_LINE_STATEMENT) {
        return new SDSingleLineStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
