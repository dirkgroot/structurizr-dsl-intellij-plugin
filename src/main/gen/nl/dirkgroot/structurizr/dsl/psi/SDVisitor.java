// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SDVisitor extends PsiElementVisitor {

  public void visitAnimationBlock(@NotNull SDAnimationBlock o) {
    visitStatement(o);
  }

  public void visitAnimationKeyword(@NotNull SDAnimationKeyword o) {
    visitPsiElement(o);
  }

  public void visitArgument(@NotNull SDArgument o) {
    visitPsiElement(o);
  }

  public void visitBlock(@NotNull SDBlock o) {
    visitPsiElement(o);
  }

  public void visitBlockCommentStatement(@NotNull SDBlockCommentStatement o) {
    visitStatement(o);
  }

  public void visitBlockStatement(@NotNull SDBlockStatement o) {
    visitStatement(o);
  }

  public void visitExplicitRelationship(@NotNull SDExplicitRelationship o) {
    visitStatement(o);
  }

  public void visitIdentifierAssignment(@NotNull SDIdentifierAssignment o) {
    visitStatement(o);
  }

  public void visitIdentifierReference(@NotNull SDIdentifierReference o) {
    visitPsiElement(o);
  }

  public void visitIdentifierReferences(@NotNull SDIdentifierReferences o) {
    visitStatement(o);
  }

  public void visitImplicitRelationship(@NotNull SDImplicitRelationship o) {
    visitStatement(o);
  }

  public void visitKeyword(@NotNull SDKeyword o) {
    visitPsiElement(o);
  }

  public void visitLineCommentStatement(@NotNull SDLineCommentStatement o) {
    visitStatement(o);
  }

  public void visitPropertiesBlock(@NotNull SDPropertiesBlock o) {
    visitPsiElement(o);
  }

  public void visitPropertiesDefinition(@NotNull SDPropertiesDefinition o) {
    visitStatement(o);
  }

  public void visitPropertiesKeyword(@NotNull SDPropertiesKeyword o) {
    visitPsiElement(o);
  }

  public void visitPropertyDefinition(@NotNull SDPropertyDefinition o) {
    visitPsiElement(o);
  }

  public void visitPropertyKey(@NotNull SDPropertyKey o) {
    visitPsiElement(o);
  }

  public void visitPropertyValue(@NotNull SDPropertyValue o) {
    visitPsiElement(o);
  }

  public void visitRelationshipDestination(@NotNull SDRelationshipDestination o) {
    visitPsiElement(o);
  }

  public void visitRelationshipKeyword(@NotNull SDRelationshipKeyword o) {
    visitPsiElement(o);
  }

  public void visitRelationshipSource(@NotNull SDRelationshipSource o) {
    visitPsiElement(o);
  }

  public void visitScriptBlock(@NotNull SDScriptBlock o) {
    visitPsiElement(o);
  }

  public void visitScriptDefinition(@NotNull SDScriptDefinition o) {
    visitStatement(o);
  }

  public void visitScriptKeyword(@NotNull SDScriptKeyword o) {
    visitPsiElement(o);
  }

  public void visitSingleLineStatement(@NotNull SDSingleLineStatement o) {
    visitStatement(o);
  }

  public void visitStatement(@NotNull SDStatement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
