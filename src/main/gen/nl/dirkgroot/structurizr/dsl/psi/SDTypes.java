// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.dirkgroot.structurizr.dsl.psi.impl.*;

public interface SDTypes {

  IElementType DESCRIPTION_ARGUMENT = new SDElement("DESCRIPTION_ARGUMENT");
  IElementType MODEL_SECTION = new SDElement("MODEL_SECTION");
  IElementType NAME_ARGUMENT = new SDElement("NAME_ARGUMENT");
  IElementType SOFTWARE_SYSTEM = new SDElement("SOFTWARE_SYSTEM");
  IElementType TAGS_ARGUMENT = new SDElement("TAGS_ARGUMENT");
  IElementType VIEWS_SECTION = new SDElement("VIEWS_SECTION");
  IElementType WORKSPACE = new SDElement("WORKSPACE");

  IElementType BLOCK_COMMENT = new SDToken("block_comment");
  IElementType BRACE1 = new SDToken("BRACE1");
  IElementType BRACE2 = new SDToken("BRACE2");
  IElementType LINE_COMMENT = new SDToken("line_comment");
  IElementType LINE_TERMINATOR = new SDToken("LINE_TERMINATOR");
  IElementType MODEL_KEYWORD = new SDToken("MODEL_KEYWORD");
  IElementType QUOTED_TEXT = new SDToken("QUOTED_TEXT");
  IElementType SOFTWARE_SYSTEM_KEYWORD = new SDToken("SOFTWARE_SYSTEM_KEYWORD");
  IElementType UNQUOTED_TEXT = new SDToken("UNQUOTED_TEXT");
  IElementType VIEWS_KEYWORD = new SDToken("VIEWS_KEYWORD");
  IElementType WORKSPACE_KEYWORD = new SDToken("WORKSPACE_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DESCRIPTION_ARGUMENT) {
        return new SDDescriptionArgumentImpl(node);
      }
      else if (type == MODEL_SECTION) {
        return new SDModelSectionImpl(node);
      }
      else if (type == NAME_ARGUMENT) {
        return new SDNameArgumentImpl(node);
      }
      else if (type == SOFTWARE_SYSTEM) {
        return new SDSoftwareSystemImpl(node);
      }
      else if (type == TAGS_ARGUMENT) {
        return new SDTagsArgumentImpl(node);
      }
      else if (type == VIEWS_SECTION) {
        return new SDViewsSectionImpl(node);
      }
      else if (type == WORKSPACE) {
        return new SDWorkspaceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
