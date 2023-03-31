// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.dirkgroot.structurizr.dsl.psi.SDTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.dirkgroot.structurizr.dsl.psi.*;

public class SDBlockStatementImpl extends ASTWrapperPsiElement implements SDBlockStatement {

  public SDBlockStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitBlockStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SDVisitor) accept((SDVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SDArgument> getArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDArgument.class);
  }

  @Override
  @NotNull
  public List<SDBlockStatement> getBlockStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDBlockStatement.class);
  }

  @Override
  @NotNull
  public List<SDExplicitRelationship> getExplicitRelationshipList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDExplicitRelationship.class);
  }

  @Override
  @Nullable
  public SDIdentifierName getIdentifierName() {
    return findChildByClass(SDIdentifierName.class);
  }

  @Override
  @NotNull
  public List<SDImplicitRelationship> getImplicitRelationshipList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDImplicitRelationship.class);
  }

  @Override
  @NotNull
  public SDKeyword getKeyword() {
    return findNotNullChildByClass(SDKeyword.class);
  }

  @Override
  @NotNull
  public List<SDPropertyBlockStatement> getPropertyBlockStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDPropertyBlockStatement.class);
  }

  @Override
  @NotNull
  public List<SDScriptBlock> getScriptBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDScriptBlock.class);
  }

  @Override
  @NotNull
  public List<SDSingleLineStatement> getSingleLineStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDSingleLineStatement.class);
  }

}
