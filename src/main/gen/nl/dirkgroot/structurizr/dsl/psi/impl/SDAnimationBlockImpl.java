// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.dirkgroot.structurizr.dsl.psi.SDTypes.*;
import nl.dirkgroot.structurizr.dsl.psi.*;

public class SDAnimationBlockImpl extends SDStatementImpl implements SDAnimationBlock {

  public SDAnimationBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitAnimationBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SDVisitor) accept((SDVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SDAnimationKeyword getAnimationKeyword() {
    return findNotNullChildByClass(SDAnimationKeyword.class);
  }

  @Override
  @NotNull
  public List<SDStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SDStatement.class);
  }

}
