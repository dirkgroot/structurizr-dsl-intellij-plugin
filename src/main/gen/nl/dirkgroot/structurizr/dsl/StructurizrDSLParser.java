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
  // quotedArgument | unquotedArgument
  static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    if (!nextTokenIs(b, "", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    r = quotedArgument(b, l + 1);
    if (!r) r = unquotedArgument(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // argument
  public static boolean descriptionArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descriptionArgument")) return false;
    if (!nextTokenIs(b, "<description argument>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DESCRIPTION_ARGUMENT, "<description argument>");
    r = argument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LINE_TERMINATOR | <<eof>>
  static boolean eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_TERMINATOR);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MODEL_KEYWORD (BRACE1 eol modelSectionElements BRACE2)? eol
  public static boolean modelSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelSection")) return false;
    if (!nextTokenIs(b, MODEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODEL_KEYWORD);
    r = r && modelSection_1(b, l + 1);
    r = r && eol(b, l + 1);
    exit_section_(b, m, MODEL_SECTION, r);
    return r;
  }

  // (BRACE1 eol modelSectionElements BRACE2)?
  private static boolean modelSection_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelSection_1")) return false;
    modelSection_1_0(b, l + 1);
    return true;
  }

  // BRACE1 eol modelSectionElements BRACE2
  private static boolean modelSection_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelSection_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE1);
    r = r && eol(b, l + 1);
    r = r && modelSectionElements(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // softwareSystem*
  static boolean modelSectionElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modelSectionElements")) return false;
    while (true) {
      int c = current_position_(b);
      if (!softwareSystem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modelSectionElements", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // argument
  public static boolean nameArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameArgument")) return false;
    if (!nextTokenIs(b, "<name argument>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAME_ARGUMENT, "<name argument>");
    r = argument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QUOTED_TEXT
  static boolean quotedArgument(PsiBuilder b, int l) {
    return consumeToken(b, QUOTED_TEXT);
  }

  /* ********************************************************** */
  // SOFTWARE_SYSTEM_KEYWORD nameArgument descriptionArgument? tagsArgument? eol
  public static boolean softwareSystem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "softwareSystem")) return false;
    if (!nextTokenIs(b, SOFTWARE_SYSTEM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SOFTWARE_SYSTEM_KEYWORD);
    r = r && nameArgument(b, l + 1);
    r = r && softwareSystem_2(b, l + 1);
    r = r && softwareSystem_3(b, l + 1);
    r = r && eol(b, l + 1);
    exit_section_(b, m, SOFTWARE_SYSTEM, r);
    return r;
  }

  // descriptionArgument?
  private static boolean softwareSystem_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "softwareSystem_2")) return false;
    descriptionArgument(b, l + 1);
    return true;
  }

  // tagsArgument?
  private static boolean softwareSystem_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "softwareSystem_3")) return false;
    tagsArgument(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // workspace | workspaceSection | modelSectionElements
  static boolean structurizrDSLFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structurizrDSLFile")) return false;
    boolean r;
    r = workspace(b, l + 1);
    if (!r) r = workspaceSection(b, l + 1);
    if (!r) r = modelSectionElements(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // argument
  public static boolean tagsArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagsArgument")) return false;
    if (!nextTokenIs(b, "<tags argument>", QUOTED_TEXT, UNQUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAGS_ARGUMENT, "<tags argument>");
    r = argument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNQUOTED_TEXT
  static boolean unquotedArgument(PsiBuilder b, int l) {
    return consumeToken(b, UNQUOTED_TEXT);
  }

  /* ********************************************************** */
  // VIEWS_KEYWORD BRACE1 eol BRACE2 eol
  public static boolean viewsSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewsSection")) return false;
    if (!nextTokenIs(b, VIEWS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VIEWS_KEYWORD, BRACE1);
    r = r && eol(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    r = r && eol(b, l + 1);
    exit_section_(b, m, VIEWS_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // workspaceDefinition (BRACE1 eol workspaceElements? BRACE2)? eol
  public static boolean workspace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspace")) return false;
    if (!nextTokenIs(b, WORKSPACE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = workspaceDefinition(b, l + 1);
    r = r && workspace_1(b, l + 1);
    r = r && eol(b, l + 1);
    exit_section_(b, m, WORKSPACE, r);
    return r;
  }

  // (BRACE1 eol workspaceElements? BRACE2)?
  private static boolean workspace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspace_1")) return false;
    workspace_1_0(b, l + 1);
    return true;
  }

  // BRACE1 eol workspaceElements? BRACE2
  private static boolean workspace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE1);
    r = r && eol(b, l + 1);
    r = r && workspace_1_0_2(b, l + 1);
    r = r && consumeToken(b, BRACE2);
    exit_section_(b, m, null, r);
    return r;
  }

  // workspaceElements?
  private static boolean workspace_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspace_1_0_2")) return false;
    workspaceElements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WORKSPACE_KEYWORD nameArgument? descriptionArgument?
  static boolean workspaceDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceDefinition")) return false;
    if (!nextTokenIs(b, WORKSPACE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WORKSPACE_KEYWORD);
    r = r && workspaceDefinition_1(b, l + 1);
    r = r && workspaceDefinition_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nameArgument?
  private static boolean workspaceDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceDefinition_1")) return false;
    nameArgument(b, l + 1);
    return true;
  }

  // descriptionArgument?
  private static boolean workspaceDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceDefinition_2")) return false;
    descriptionArgument(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (modelSection viewsSection?) | (viewsSection modelSection?)
  static boolean workspaceElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceElements")) return false;
    if (!nextTokenIs(b, "", MODEL_KEYWORD, VIEWS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = workspaceElements_0(b, l + 1);
    if (!r) r = workspaceElements_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // modelSection viewsSection?
  private static boolean workspaceElements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceElements_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modelSection(b, l + 1);
    r = r && workspaceElements_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // viewsSection?
  private static boolean workspaceElements_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceElements_0_1")) return false;
    viewsSection(b, l + 1);
    return true;
  }

  // viewsSection modelSection?
  private static boolean workspaceElements_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceElements_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = viewsSection(b, l + 1);
    r = r && workspaceElements_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // modelSection?
  private static boolean workspaceElements_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceElements_1_1")) return false;
    modelSection(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // modelSection | viewsSection
  static boolean workspaceSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "workspaceSection")) return false;
    if (!nextTokenIs(b, "", MODEL_KEYWORD, VIEWS_KEYWORD)) return false;
    boolean r;
    r = modelSection(b, l + 1);
    if (!r) r = viewsSection(b, l + 1);
    return r;
  }

}
