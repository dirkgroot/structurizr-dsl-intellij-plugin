// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SDVisitor extends PsiElementVisitor {

  public void visitAnimationBlock(@NotNull SDAnimationBlock o) {
    visitBlock(o);
  }

  public void visitAnimationKeyword(@NotNull SDAnimationKeyword o) {
    visitKeyword(o);
  }

  public void visitAnimationStatement(@NotNull SDAnimationStatement o) {
    visitStatement(o);
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

  public void visitExplicitRelationshipStatement(@NotNull SDExplicitRelationshipStatement o) {
    visitStatement(o);
  }

  public void visitIdentifierAssignmentStatement(@NotNull SDIdentifierAssignmentStatement o) {
    visitStatement(o);
  }

  public void visitIdentifierReference(@NotNull SDIdentifierReference o) {
    visitPsiElement(o);
  }

  public void visitIdentifierReferencesStatement(@NotNull SDIdentifierReferencesStatement o) {
    visitStatement(o);
  }

  public void visitImplicitRelationshipStatement(@NotNull SDImplicitRelationshipStatement o) {
    visitStatement(o);
  }

  public void visitKeyword(@NotNull SDKeyword o) {
    visitPsiElement(o);
  }

  public void visitLineCommentStatement(@NotNull SDLineCommentStatement o) {
    visitStatement(o);
  }

  public void visitPropertiesBlock(@NotNull SDPropertiesBlock o) {
    visitBlock(o);
  }

  public void visitPropertiesKeyword(@NotNull SDPropertiesKeyword o) {
    visitKeyword(o);
  }

  public void visitPropertiesStatement(@NotNull SDPropertiesStatement o) {
    visitStatement(o);
  }

  public void visitPropertyDefinition(@NotNull SDPropertyDefinition o) {
    visitPsiElement(o);
  }

  public void visitPropertyDefinitionPart(@NotNull SDPropertyDefinitionPart o) {
    visitPsiElement(o);
  }

  public void visitRawBlockStatement(@NotNull SDRawBlockStatement o) {
    visitStatement(o);
  }

  public void visitRelationshipDestination(@NotNull SDRelationshipDestination o) {
    visitPsiElement(o);
  }

  public void visitRelationshipKeyword(@NotNull SDRelationshipKeyword o) {
    visitKeyword(o);
  }

  public void visitRelationshipSource(@NotNull SDRelationshipSource o) {
    visitPsiElement(o);
  }

  public void visitScriptBlock(@NotNull SDScriptBlock o) {
    visitBlock(o);
  }

  public void visitScriptKeyword(@NotNull SDScriptKeyword o) {
    visitKeyword(o);
  }

  public void visitScriptStatement(@NotNull SDScriptStatement o) {
    visitStatement(o);
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
