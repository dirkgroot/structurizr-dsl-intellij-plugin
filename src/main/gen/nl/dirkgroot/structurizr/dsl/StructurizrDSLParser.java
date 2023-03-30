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
  // !<<eof>>
  public static boolean rootElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rootElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, ROOT_ELEMENT, "<root element>");
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // rootElement
  static boolean structurizrDSLFile(PsiBuilder b, int l) {
    return rootElement(b, l + 1);
  }

}
