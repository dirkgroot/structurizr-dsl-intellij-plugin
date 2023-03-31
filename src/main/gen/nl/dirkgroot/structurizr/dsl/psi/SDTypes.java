// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.dirkgroot.structurizr.dsl.psi.impl.*;

public interface SDTypes {

  IElementType ARGUMENT = new SDElement("ARGUMENT");
  IElementType BLOCK_STATEMENT = new SDElement("BLOCK_STATEMENT");
  IElementType EXPLICIT_RELATIONSHIP = new SDElement("EXPLICIT_RELATIONSHIP");
  IElementType IDENTIFIER_NAME = new SDElement("IDENTIFIER_NAME");
  IElementType IDENTIFIER_REFERENCES = new SDElement("IDENTIFIER_REFERENCES");
  IElementType IMPLICIT_RELATIONSHIP = new SDElement("IMPLICIT_RELATIONSHIP");
  IElementType KEY = new SDElement("KEY");
  IElementType KEYWORD = new SDElement("KEYWORD");
  IElementType KEYWORD_WITH_PROPERTY_BLOCK = new SDElement("KEYWORD_WITH_PROPERTY_BLOCK");
  IElementType KEY_VALUE_PAIR = new SDElement("KEY_VALUE_PAIR");
  IElementType PROPERTY_BLOCK_STATEMENT = new SDElement("PROPERTY_BLOCK_STATEMENT");
  IElementType SCRIPT_BLOCK = new SDElement("SCRIPT_BLOCK");
  IElementType SCRIPT_CONTENTS = new SDElement("SCRIPT_CONTENTS");
  IElementType SINGLE_LINE_STATEMENT = new SDElement("SINGLE_LINE_STATEMENT");
  IElementType VALUE = new SDElement("VALUE");

  IElementType ADRS_KEYWORD = new SDToken("!adrs");
  IElementType ANIMATION_KEYWORD = new SDToken("animation");
  IElementType AUTO_LAYOUT_KEYWORD = new SDToken("autoLayout");
  IElementType BACKGROUND_KEYWORD = new SDToken("background");
  IElementType BLOCK_COMMENT = new SDToken("block_comment");
  IElementType BORDER_KEYWORD = new SDToken("border");
  IElementType BRACE1 = new SDToken("{");
  IElementType BRACE2 = new SDToken("}");
  IElementType BRANDING_KEYWORD = new SDToken("branding");
  IElementType COLOR_KEYWORD = new SDToken("color");
  IElementType COLOUR_KEYWORD = new SDToken("colour");
  IElementType COMPONENT_KEYWORD = new SDToken("component");
  IElementType CONFIGURATION_KEYWORD = new SDToken("configuration");
  IElementType CONSTANT_KEYWORD = new SDToken("!constant");
  IElementType CONTAINER_INSTANCE = new SDToken("containerInstance");
  IElementType CONTAINER_KEYWORD = new SDToken("container");
  IElementType CRLF = new SDToken("CRLF");
  IElementType CUSTOM_KEYWORD = new SDToken("custom");
  IElementType DEPLOYMENT_ENVIRONMENT_KEYWORD = new SDToken("deploymentEnvironment");
  IElementType DEPLOYMENT_GROUP_KEYWORD = new SDToken("deploymentGroup");
  IElementType DEPLOYMENT_KEYWORD = new SDToken("deployment");
  IElementType DEPLOYMENT_NODE_KEYWORD = new SDToken("deploymentNode");
  IElementType DESCRIPTION_KEYWORD = new SDToken("description");
  IElementType DOCS_KEYWORD = new SDToken("!docs");
  IElementType DYNAMIC_KEYWORD = new SDToken("dynamic");
  IElementType ELEMENT_KEYWORD = new SDToken("element");
  IElementType ENTERPRISE_KEYWORD = new SDToken("enterprise");
  IElementType EQUALS = new SDToken("=");
  IElementType EXCLUDE_ELEMENT_KEYWORD = new SDToken("exclude");
  IElementType EXTENDS_KEYWORD = new SDToken("extends");
  IElementType FILTERED_KEYWORD = new SDToken("filtered");
  IElementType FONTSIZE_KEYWORD = new SDToken("fontSize");
  IElementType GROUP_KEYWORD = new SDToken("group");
  IElementType HEALTH_CHECK_KEYWORD = new SDToken("healthCheck");
  IElementType HEIGHT_KEYWORD = new SDToken("height");
  IElementType ICON_KEYWORD = new SDToken("icon");
  IElementType IDENTIFIER = new SDToken("IDENTIFIER");
  IElementType IDENTIFIERS_KEYWORD = new SDToken("!identifiers");
  IElementType IMPLIED_RELATIONSHIPS_KEYWORD = new SDToken("!impliedRelationships");
  IElementType INCLUDE_ELEMENT_KEYWORD = new SDToken("include");
  IElementType INCLUDE_FILE_KEYWORD = new SDToken("!include");
  IElementType INFRASTRUCTURE_NODE_KEYWORD = new SDToken("infrastructureNode");
  IElementType INSTANCES_KEYWORD = new SDToken("instances");
  IElementType LINE_COMMENT = new SDToken("line_comment");
  IElementType METADATA_KEYWORD = new SDToken("metadata");
  IElementType MODEL_KEYWORD = new SDToken("model");
  IElementType OPACITY_KEYWORD = new SDToken("opacity");
  IElementType PERSON_KEYWORD = new SDToken("person");
  IElementType PERSPECTIVES_KEYWORD = new SDToken("perspectives");
  IElementType PLUGIN_KEYWORD = new SDToken("!plugin");
  IElementType POSITION_KEYWORD = new SDToken("position");
  IElementType PROPERTIES_KEYWORD = new SDToken("properties");
  IElementType QUOTED_TEXT = new SDToken("QUOTED_TEXT");
  IElementType REF_KEYWORD = new SDToken("!ref");
  IElementType RELATIONSHIP_KEYWORD = new SDToken("->");
  IElementType ROUTING_KEYWORD = new SDToken("routing");
  IElementType SCRIPT_KEYWORD = new SDToken("!script");
  IElementType SCRIPT_TEXT = new SDToken("SCRIPT_TEXT");
  IElementType SHAPE_KEYWORD = new SDToken("shape");
  IElementType SOFTWARE_SYSTEM_INSTANCE_KEYWORD = new SDToken("softwareSystemInstance");
  IElementType SOFTWARE_SYSTEM_KEYWORD = new SDToken("softwareSystem");
  IElementType STROKEWIDTH_KEYWORD = new SDToken("strokeWidth");
  IElementType STROKE_KEYWORD = new SDToken("stroke");
  IElementType STYLES_KEYWORD = new SDToken("styles");
  IElementType STYLE_KEYWORD = new SDToken("style");
  IElementType SYSTEM_CONTEXT_KEYWORD = new SDToken("systemContext");
  IElementType SYSTEM_LANDSCAPE_KEYWORD = new SDToken("systemLandscape");
  IElementType TAGS_KEYWORD = new SDToken("tags");
  IElementType TECHNOLOGY_KEYWORD = new SDToken("technology");
  IElementType TERMINOLOGY_KEYWORD = new SDToken("terminology");
  IElementType THEME_KEYWORD = new SDToken("theme");
  IElementType THICKNESS_KEYWORD = new SDToken("thickness");
  IElementType TITLE_KEYWORD = new SDToken("title");
  IElementType UNQUOTED_TEXT = new SDToken("UNQUOTED_TEXT");
  IElementType URL_KEYWORD = new SDToken("url");
  IElementType USERS_KEYWORD = new SDToken("users");
  IElementType VIEWS_KEYWORD = new SDToken("views");
  IElementType WIDTH_KEYWORD = new SDToken("width");
  IElementType WORKSPACE_KEYWORD = new SDToken("workspace");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new SDArgumentImpl(node);
      }
      else if (type == BLOCK_STATEMENT) {
        return new SDBlockStatementImpl(node);
      }
      else if (type == EXPLICIT_RELATIONSHIP) {
        return new SDExplicitRelationshipImpl(node);
      }
      else if (type == IDENTIFIER_NAME) {
        return new SDIdentifierNameImpl(node);
      }
      else if (type == IDENTIFIER_REFERENCES) {
        return new SDIdentifierReferencesImpl(node);
      }
      else if (type == IMPLICIT_RELATIONSHIP) {
        return new SDImplicitRelationshipImpl(node);
      }
      else if (type == KEY) {
        return new SDKeyImpl(node);
      }
      else if (type == KEYWORD) {
        return new SDKeywordImpl(node);
      }
      else if (type == KEYWORD_WITH_PROPERTY_BLOCK) {
        return new SDKeywordWithPropertyBlockImpl(node);
      }
      else if (type == KEY_VALUE_PAIR) {
        return new SDKeyValuePairImpl(node);
      }
      else if (type == PROPERTY_BLOCK_STATEMENT) {
        return new SDPropertyBlockStatementImpl(node);
      }
      else if (type == SCRIPT_BLOCK) {
        return new SDScriptBlockImpl(node);
      }
      else if (type == SCRIPT_CONTENTS) {
        return new SDScriptContentsImpl(node);
      }
      else if (type == SINGLE_LINE_STATEMENT) {
        return new SDSingleLineStatementImpl(node);
      }
      else if (type == VALUE) {
        return new SDValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
