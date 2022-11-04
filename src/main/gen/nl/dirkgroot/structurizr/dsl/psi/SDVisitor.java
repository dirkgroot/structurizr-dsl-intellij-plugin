// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SDVisitor extends PsiElementVisitor {

  public void visitDescriptionArgument(@NotNull SDDescriptionArgument o) {
    visitPsiElement(o);
  }

  public void visitModelSection(@NotNull SDModelSection o) {
    visitPsiElement(o);
  }

  public void visitNameArgument(@NotNull SDNameArgument o) {
    visitPsiElement(o);
  }

  public void visitSoftwareSystem(@NotNull SDSoftwareSystem o) {
    visitElementWithName(o);
    // visitElementWithDescription(o);
    // visitElementWithTags(o);
  }

  public void visitTagsArgument(@NotNull SDTagsArgument o) {
    visitPsiElement(o);
  }

  public void visitViewsSection(@NotNull SDViewsSection o) {
    visitPsiElement(o);
  }

  public void visitWorkspace(@NotNull SDWorkspace o) {
    visitElementWithName(o);
    // visitElementWithDescription(o);
  }

  public void visitElementWithName(@NotNull SDElementWithName o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
