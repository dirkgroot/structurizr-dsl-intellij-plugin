// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.dirkgroot.structurizr.dsl.psi.impl.*;

public interface SDTypes {

  IElementType ROOT_ELEMENT = new SDElement("ROOT_ELEMENT");

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
  IElementType CRLF = new SDToken("crlf");
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
  IElementType IDENTIFIER = new SDToken("identifier");
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
  IElementType QUOTED_TEXT = new SDToken("quoted_text");
  IElementType REF_KEYWORD = new SDToken("!ref");
  IElementType RELATIONSHIP_KEYWORD = new SDToken("->");
  IElementType ROUTING_KEYWORD = new SDToken("routing");
  IElementType SCRIPT_KEYWORD = new SDToken("!script");
  IElementType SCRIPT_TEXT = new SDToken("script_text");
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
  IElementType UNQUOTED_TEXT = new SDToken("unquoted_text");
  IElementType URL_KEYWORD = new SDToken("url");
  IElementType USERS_KEYWORD = new SDToken("users");
  IElementType VIEWS_KEYWORD = new SDToken("views");
  IElementType WIDTH_KEYWORD = new SDToken("width");
  IElementType WORKSPACE_KEYWORD = new SDToken("workspace");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ROOT_ELEMENT) {
        return new SDRootElementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
