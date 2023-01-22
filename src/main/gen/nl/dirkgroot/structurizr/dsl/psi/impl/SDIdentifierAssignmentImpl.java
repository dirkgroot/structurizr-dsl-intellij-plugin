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

public class SDIdentifierAssignmentImpl extends ASTWrapperPsiElement implements SDIdentifierAssignment {

  public SDIdentifierAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitIdentifierAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SDVisitor) accept((SDVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SDBlockStatement getBlockStatement() {
    return findChildByClass(SDBlockStatement.class);
  }

  @Override
  @NotNull
  public SDIdentifierName getIdentifierName() {
    return findNotNullChildByClass(SDIdentifierName.class);
  }

  @Override
  @Nullable
  public SDPropertyBlockStatement getPropertyBlockStatement() {
    return findChildByClass(SDPropertyBlockStatement.class);
  }

  @Override
  @Nullable
  public SDSingleLineStatement getSingleLineStatement() {
    return findChildByClass(SDSingleLineStatement.class);
  }

}
