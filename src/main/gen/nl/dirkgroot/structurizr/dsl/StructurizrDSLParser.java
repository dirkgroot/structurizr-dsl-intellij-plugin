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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ANIMATION_BLOCK, BLOCK_COMMENT_STATEMENT, BLOCK_STATEMENT, EXPLICIT_RELATIONSHIP,
      IDENTIFIER_ASSIGNMENT, IDENTIFIER_REFERENCES, IMPLICIT_RELATIONSHIP, LINE_COMMENT_STATEMENT,
      PROPERTIES_DEFINITION, SCRIPT_DEFINITION, SINGLE_LINE_STATEMENT),
  };

  /* ********************************************************** */
  // animationKeyword '{' CRLF (identifierReferences | lineCommentStatement | blockCommentStatement)* '}' lf_eof
  public static boolean animationBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "animationBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANIMATION_BLOCK, "<animation block>");
    r = animationKeyword(b, l + 1);
    r = r && consumeTokens(b, 0, BRACE1, CRLF);
    r = r && animationBlock_3(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (identifierReferences | lineCommentStatement | blockCommentStatement)*
  private static boolean animationBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "animationBlock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!animationBlock_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "animationBlock_3", c)) break;
    }
    return true;
  }

  // identifierReferences | lineCommentStatement | blockCommentStatement
  private static boolean animationBlock_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "animationBlock_3_0")) return false;
    boolean r;
    r = identifierReferences(b, l + 1);
    if (!r) r = lineCommentStatement(b, l + 1);
    if (!r) r = blockCommentStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'animation'
  public static boolean animationKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "animationKeyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANIMATION_KEYWORD, "<animation keyword>");
    r = consumeToken(b, "animation");
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // '{' CRLF expr* '}'
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = consumeTokens(b, 1, BRACE1, CRLF);
    p = r; // pin = 1
    r = r && report_error_(b, block_2(b, l + 1));
    r = p && consumeToken(b, BRACE2) && r;
    exit_section_(b, l, m, r, p, StructurizrDSLParser::blockRecover);
    return r || p;
  }

  // expr*
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT lf_eof
  public static boolean blockCommentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockCommentStatement")) return false;
    if (!nextTokenIs(b, BLOCK_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_COMMENT);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, m, BLOCK_COMMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // !(text | lf_eof)
  static boolean blockRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !blockRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // text | lf_eof
  private static boolean blockRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockRecover_0")) return false;
    boolean r;
    r = text(b, l + 1);
    if (!r) r = lf_eof(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // keyword argument* block lf_eof
  public static boolean blockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyword(b, l + 1);
    r = r && blockStatement_1(b, l + 1);
    r = r && block(b, l + 1);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, m, BLOCK_STATEMENT, r);
    return r;
  }

  // argument*
  private static boolean blockStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockStatement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // relationshipSource relationshipKeyword relationshipDestination argument* block? lf_eof
  public static boolean explicitRelationship(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitRelationship")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationshipSource(b, l + 1);
    r = r && relationshipKeyword(b, l + 1);
    r = r && relationshipDestination(b, l + 1);
    r = r && explicitRelationship_3(b, l + 1);
    r = r && explicitRelationship_4(b, l + 1);
    r = r && lf_eof(b, l + 1);
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

  // block?
  private static boolean explicitRelationship_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitRelationship_4")) return false;
    block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // scriptDefinition
  //             | explicitRelationship
  //             | implicitRelationship
  //             | animationBlock
  //             | propertiesDefinition
  //             | identifierAssignment
  //             | blockStatement
  //             | singleLineStatement
  //             | lineCommentStatement
  //             | blockCommentStatement
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    r = scriptDefinition(b, l + 1);
    if (!r) r = explicitRelationship(b, l + 1);
    if (!r) r = implicitRelationship(b, l + 1);
    if (!r) r = animationBlock(b, l + 1);
    if (!r) r = propertiesDefinition(b, l + 1);
    if (!r) r = identifierAssignment(b, l + 1);
    if (!r) r = blockStatement(b, l + 1);
    if (!r) r = singleLineStatement(b, l + 1);
    if (!r) r = lineCommentStatement(b, l + 1);
    if (!r) r = blockCommentStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifierReference '=' (blockStatement | singleLineStatement)
  public static boolean identifierAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierAssignment")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierReference(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && identifierAssignment_2(b, l + 1);
    exit_section_(b, m, IDENTIFIER_ASSIGNMENT, r);
    return r;
  }

  // blockStatement | singleLineStatement
  private static boolean identifierAssignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierAssignment_2")) return false;
    boolean r;
    r = blockStatement(b, l + 1);
    if (!r) r = singleLineStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // UNQUOTED_TEXT
  public static boolean identifierReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierReference")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNQUOTED_TEXT);
    exit_section_(b, m, IDENTIFIER_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // identifierReference* CRLF
  public static boolean identifierReferences(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierReferences")) return false;
    if (!nextTokenIs(b, "<identifier references>", CRLF, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_REFERENCES, "<identifier references>");
    r = identifierReferences_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifierReference*
  private static boolean identifierReferences_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierReferences_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifierReference(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifierReferences_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // relationshipKeyword relationshipDestination argument* block? lf_eof
  public static boolean implicitRelationship(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implicitRelationship")) return false;
    if (!nextTokenIs(b, ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationshipKeyword(b, l + 1);
    r = r && relationshipDestination(b, l + 1);
    r = r && implicitRelationship_2(b, l + 1);
    r = r && implicitRelationship_3(b, l + 1);
    r = r && lf_eof(b, l + 1);
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

  // block?
  private static boolean implicitRelationship_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "implicitRelationship_3")) return false;
    block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // UNQUOTED_TEXT
  public static boolean keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNQUOTED_TEXT);
    exit_section_(b, m, KEYWORD, r);
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
  // LINE_COMMENT lf_eof
  public static boolean lineCommentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineCommentStatement")) return false;
    if (!nextTokenIs(b, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, m, LINE_COMMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '{' CRLF propertyDefinition* '}'
  public static boolean propertiesBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesBlock")) return false;
    if (!nextTokenIs(b, BRACE1)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BRACE1, CRLF);
    r = r && propertiesBlock_2(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    exit_section_(b, m, PROPERTIES_BLOCK, r);
    return r;
  }

  // propertyDefinition*
  private static boolean propertiesBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!propertyDefinition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertiesBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // propertiesKeyword propertiesBlock lf_eof
  public static boolean propertiesDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_DEFINITION, "<properties definition>");
    r = propertiesKeyword(b, l + 1);
    r = r && propertiesBlock(b, l + 1);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'perspectives' | 'properties' | 'users'
  public static boolean propertiesKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesKeyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_KEYWORD, "<properties keyword>");
    r = consumeToken(b, "perspectives");
    if (!r) r = consumeToken(b, "properties");
    if (!r) r = consumeToken(b, "users");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // propertyKey propertyValue CRLF
  public static boolean propertyDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyDefinition")) return false;
    if (!nextTokenIs(b, "<property definition>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_DEFINITION, "<property definition>");
    r = propertyKey(b, l + 1);
    r = r && propertyValue(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // text
  public static boolean propertyKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyKey")) return false;
    if (!nextTokenIs(b, "<property key>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_KEY, "<property key>");
    r = text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // text
  public static boolean propertyValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyValue")) return false;
    if (!nextTokenIs(b, "<property value>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_VALUE, "<property value>");
    r = text(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNQUOTED_TEXT
  public static boolean relationshipDestination(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationshipDestination")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNQUOTED_TEXT);
    exit_section_(b, m, RELATIONSHIP_DESTINATION, r);
    return r;
  }

  /* ********************************************************** */
  // ARROW
  public static boolean relationshipKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationshipKeyword")) return false;
    if (!nextTokenIs(b, ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    exit_section_(b, m, RELATIONSHIP_KEYWORD, r);
    return r;
  }

  /* ********************************************************** */
  // UNQUOTED_TEXT
  public static boolean relationshipSource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationshipSource")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNQUOTED_TEXT);
    exit_section_(b, m, RELATIONSHIP_SOURCE, r);
    return r;
  }

  /* ********************************************************** */
  // '{' SCRIPT_TEXT '}'
  public static boolean scriptBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBlock")) return false;
    if (!nextTokenIs(b, BRACE1)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BRACE1, SCRIPT_TEXT, BRACE2);
    exit_section_(b, m, SCRIPT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // scriptKeyword argument* scriptBlock lf_eof
  public static boolean scriptDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_DEFINITION, "<script definition>");
    r = scriptKeyword(b, l + 1);
    r = r && scriptDefinition_1(b, l + 1);
    r = r && scriptBlock(b, l + 1);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argument*
  private static boolean scriptDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptDefinition_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scriptDefinition_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '!script'
  public static boolean scriptKeyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptKeyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_KEYWORD, "<script keyword>");
    r = consumeToken(b, "!script");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // keyword argument* lf_eof
  public static boolean singleLineStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleLineStatement")) return false;
    if (!nextTokenIs(b, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyword(b, l + 1);
    r = r && singleLineStatement_1(b, l + 1);
    r = r && lf_eof(b, l + 1);
    exit_section_(b, m, SINGLE_LINE_STATEMENT, r);
    return r;
  }

  // argument*
  private static boolean singleLineStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleLineStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "singleLineStatement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expr*
  static boolean structurizrDSLFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structurizrDSLFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
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

}
