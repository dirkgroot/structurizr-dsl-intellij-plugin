// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static nl.dirkgroot.structurizr.dsl.psi.SDTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class StructurizrDSLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return structurizrDSLFile(b, l + 1);
  }

  /* ********************************************************** */
  // text
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    if (!nextTokenIs(b, "<argument>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifierAssignment? keywordWithArguments '{' CRLF statement* '}' lf_eof
  public static boolean blockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_STATEMENT, "<block statement>");
    r = blockStatement_0(b, l + 1);
    r = r && keywordWithArguments(b, l + 1);
    r = r && consumeTokens(b, 0, BRACE1, CRLF);
    r = r && blockStatement_4(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifierAssignment?
  private static boolean blockStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement_0")) return false;
    identifierAssignment(b, l + 1);
    return true;
  }

  // statement*
  private static boolean blockStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockStatement_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // singleLineStatement | blockStatement | propertyBlockStatement | CRLF
  static boolean elementDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementDefinition")) return false;
    boolean r;
    r = singleLineStatement(b, l + 1);
    if (!r) r = blockStatement(b, l + 1);
    if (!r) r = propertyBlockStatement(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // identifierName '->' identifierName argument*
  public static boolean explicitRelationship(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitRelationship")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierName(b, l + 1);
    r = r && consumeToken(b, RELATIONSHIP_KEYWORD);
    r = r && identifierName(b, l + 1);
    r = r && explicitRelationship_3(b, l + 1);
    exit_section_(b, m, EXPLICIT_RELATIONSHIP, r);
    return r;
  }

  // argument*
  private static boolean explicitRelationship_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitRelationship_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "explicitRelationship_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifierName '='
  static boolean identifierAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierAssignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierName(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifierName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENTIFIER_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // '->' identifierName argument*
  public static boolean implicitRelationship(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implicitRelationship")) return false;
    if (!nextTokenIs(b, RELATIONSHIP_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RELATIONSHIP_KEYWORD);
    r = r && identifierName(b, l + 1);
    r = r && implicitRelationship_2(b, l + 1);
    exit_section_(b, m, IMPLICIT_RELATIONSHIP, r);
    return r;
  }

  // argument*
  private static boolean implicitRelationship_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implicitRelationship_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "implicitRelationship_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // text
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, "<key>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
    r = text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key value CRLF
  public static boolean keyValuePair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValuePair")) return false;
    if (!nextTokenIs(b, "<key value pair>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE_PAIR, "<key value pair>");
    r = key(b, l + 1);
    r = r && value(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '!adrs' | 'animation' | 'autoLayout' | 'background' | 'border' | 'color' | 'colour' | 'component' |
  //             '!constant' | 'containerInstance' | 'container' | 'custom' | 'deploymentEnvironment' | 'deploymentGroup' |
  //             'deployment' | 'deploymentNode' | 'description' | '!docs' | 'dynamic' | 'element' | 'enterprise' |
  //             'exclude' | 'extends' | 'filtered' | 'fontSize' | 'group' | 'healthCheck' | 'height' | 'icon' |
  //             '!identifiers' | '!impliedRelationships' | 'include' | '!include' | 'infrastructureNode' | 'instances' |
  //             'metadata' | 'model' | 'opacity' | 'person' | 'perspectives' | '!plugin' | 'position' | '!ref' | '->' |
  //             'routing' | '!script' | 'shape' | 'softwareSystemInstance' | 'softwareSystem' | 'stroke' | 'strokeWidth' |
  //             'style' | 'styles' | 'systemContext' | 'systemLandscape' | 'tags' | 'technology' | 'theme' | 'thickness' |
  //             'title' | 'url' | 'views' | 'width' | 'workspace'
  public static boolean keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD, "<keyword>");
    r = consumeToken(b, ADRS_KEYWORD);
    if (!r) r = consumeToken(b, ANIMATION_KEYWORD);
    if (!r) r = consumeToken(b, AUTO_LAYOUT_KEYWORD);
    if (!r) r = consumeToken(b, BACKGROUND_KEYWORD);
    if (!r) r = consumeToken(b, BORDER_KEYWORD);
    if (!r) r = consumeToken(b, COLOR_KEYWORD);
    if (!r) r = consumeToken(b, COLOUR_KEYWORD);
    if (!r) r = consumeToken(b, COMPONENT_KEYWORD);
    if (!r) r = consumeToken(b, CONSTANT_KEYWORD);
    if (!r) r = consumeToken(b, CONTAINER_INSTANCE);
    if (!r) r = consumeToken(b, CONTAINER_KEYWORD);
    if (!r) r = consumeToken(b, CUSTOM_KEYWORD);
    if (!r) r = consumeToken(b, DEPLOYMENT_ENVIRONMENT_KEYWORD);
    if (!r) r = consumeToken(b, DEPLOYMENT_GROUP_KEYWORD);
    if (!r) r = consumeToken(b, DEPLOYMENT_KEYWORD);
    if (!r) r = consumeToken(b, DEPLOYMENT_NODE_KEYWORD);
    if (!r) r = consumeToken(b, DESCRIPTION_KEYWORD);
    if (!r) r = consumeToken(b, DOCS_KEYWORD);
    if (!r) r = consumeToken(b, DYNAMIC_KEYWORD);
    if (!r) r = consumeToken(b, ELEMENT_KEYWORD);
    if (!r) r = consumeToken(b, ENTERPRISE_KEYWORD);
    if (!r) r = consumeToken(b, EXCLUDE_ELEMENT_KEYWORD);
    if (!r) r = consumeToken(b, EXTENDS_KEYWORD);
    if (!r) r = consumeToken(b, FILTERED_KEYWORD);
    if (!r) r = consumeToken(b, FONTSIZE_KEYWORD);
    if (!r) r = consumeToken(b, GROUP_KEYWORD);
    if (!r) r = consumeToken(b, HEALTH_CHECK_KEYWORD);
    if (!r) r = consumeToken(b, HEIGHT_KEYWORD);
    if (!r) r = consumeToken(b, ICON_KEYWORD);
    if (!r) r = consumeToken(b, IDENTIFIERS_KEYWORD);
    if (!r) r = consumeToken(b, IMPLIED_RELATIONSHIPS_KEYWORD);
    if (!r) r = consumeToken(b, INCLUDE_ELEMENT_KEYWORD);
    if (!r) r = consumeToken(b, INCLUDE_FILE_KEYWORD);
    if (!r) r = consumeToken(b, INFRASTRUCTURE_NODE_KEYWORD);
    if (!r) r = consumeToken(b, INSTANCES_KEYWORD);
    if (!r) r = consumeToken(b, METADATA_KEYWORD);
    if (!r) r = consumeToken(b, MODEL_KEYWORD);
    if (!r) r = consumeToken(b, OPACITY_KEYWORD);
    if (!r) r = consumeToken(b, PERSON_KEYWORD);
    if (!r) r = consumeToken(b, PERSPECTIVES_KEYWORD);
    if (!r) r = consumeToken(b, PLUGIN_KEYWORD);
    if (!r) r = consumeToken(b, POSITION_KEYWORD);
    if (!r) r = consumeToken(b, REF_KEYWORD);
    if (!r) r = consumeToken(b, RELATIONSHIP_KEYWORD);
    if (!r) r = consumeToken(b, ROUTING_KEYWORD);
    if (!r) r = consumeToken(b, SCRIPT_KEYWORD);
    if (!r) r = consumeToken(b, SHAPE_KEYWORD);
    if (!r) r = consumeToken(b, SOFTWARE_SYSTEM_INSTANCE_KEYWORD);
    if (!r) r = consumeToken(b, SOFTWARE_SYSTEM_KEYWORD);
    if (!r) r = consumeToken(b, STROKE_KEYWORD);
    if (!r) r = consumeToken(b, STROKEWIDTH_KEYWORD);
    if (!r) r = consumeToken(b, STYLE_KEYWORD);
    if (!r) r = consumeToken(b, STYLES_KEYWORD);
    if (!r) r = consumeToken(b, SYSTEM_CONTEXT_KEYWORD);
    if (!r) r = consumeToken(b, SYSTEM_LANDSCAPE_KEYWORD);
    if (!r) r = consumeToken(b, TAGS_KEYWORD);
    if (!r) r = consumeToken(b, TECHNOLOGY_KEYWORD);
    if (!r) r = consumeToken(b, THEME_KEYWORD);
    if (!r) r = consumeToken(b, THICKNESS_KEYWORD);
    if (!r) r = consumeToken(b, TITLE_KEYWORD);
    if (!r) r = consumeToken(b, URL_KEYWORD);
    if (!r) r = consumeToken(b, VIEWS_KEYWORD);
    if (!r) r = consumeToken(b, WIDTH_KEYWORD);
    if (!r) r = consumeToken(b, WORKSPACE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // keyword argument*
  static boolean keywordWithArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywordWithArguments")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyword(b, l + 1);
    r = r && keywordWithArguments_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument*
  private static boolean keywordWithArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywordWithArguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "keywordWithArguments_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'branding' | 'configuration' | 'properties' | 'terminology' | 'users'
  public static boolean keywordWithPropertyBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywordWithPropertyBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD_WITH_PROPERTY_BLOCK, "<keyword with property block>");
    r = consumeToken(b, BRANDING_KEYWORD);
    if (!r) r = consumeToken(b, CONFIGURATION_KEYWORD);
    if (!r) r = consumeToken(b, PROPERTIES_KEYWORD);
    if (!r) r = consumeToken(b, TERMINOLOGY_KEYWORD);
    if (!r) r = consumeToken(b, USERS_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CRLF | <<eof>>
  static boolean lf_eof(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lf_eof")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CRLF);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // keywordWithPropertyBlock '{' CRLF keyValuePair* '}'
  public static boolean propertyBlockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyBlockStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_BLOCK_STATEMENT, "<property block statement>");
    r = keywordWithPropertyBlock(b, l + 1);
    r = r && consumeTokens(b, 0, BRACE1, CRLF);
    r = r && propertyBlockStatement_3(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // keyValuePair*
  private static boolean propertyBlockStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyBlockStatement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!keyValuePair(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertyBlockStatement_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '!script' argument* '{' scriptContents '}'
  public static boolean scriptBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBlock")) return false;
    if (!nextTokenIs(b, SCRIPT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT_KEYWORD);
    r = r && scriptBlock_1(b, l + 1);
    r = r && consumeToken(b, BRACE1);
    r = r && scriptContents(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    exit_section_(b, m, SCRIPT_BLOCK, r);
    return r;
  }

  // argument*
  private static boolean scriptBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scriptBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SCRIPT_TEXT+
  public static boolean scriptContents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptContents")) return false;
    if (!nextTokenIs(b, SCRIPT_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT_TEXT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, SCRIPT_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "scriptContents", c)) break;
    }
    exit_section_(b, m, SCRIPT_CONTENTS, r);
    return r;
  }

  /* ********************************************************** */
  // identifierAssignment? keywordWithArguments lf_eof
  public static boolean singleLineStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleLineStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_LINE_STATEMENT, "<single line statement>");
    r = singleLineStatement_0(b, l + 1);
    r = r && keywordWithArguments(b, l + 1);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifierAssignment?
  private static boolean singleLineStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleLineStatement_0")) return false;
    identifierAssignment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // elementDefinition | scriptBlock | explicitRelationship | implicitRelationship
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = elementDefinition(b, l + 1);
    if (!r) r = scriptBlock(b, l + 1);
    if (!r) r = explicitRelationship(b, l + 1);
    if (!r) r = implicitRelationship(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean structurizrDSLFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structurizrDSLFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structurizrDSLFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // QUOTED_TEXT | UNQUOTED_TEXT
  static boolean text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text")) return false;
    if (!nextTokenIs(b, "", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    r = consumeToken(b, QUOTED_TEXT);
    if (!r) r = consumeToken(b, UNQUOTED_TEXT);
    return r;
  }

  /* ********************************************************** */
  // text
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, "<value>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
