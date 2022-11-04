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

public class SDWorkspaceImpl extends ASTWrapperPsiElement implements SDWorkspace {

  public SDWorkspaceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitWorkspace(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SDVisitor) accept((SDVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SDDescriptionArgument getDescriptionArgument() {
    return findChildByClass(SDDescriptionArgument.class);
  }

  @Override
  @Nullable
  public SDModelSection getModelSection() {
    return findChildByClass(SDModelSection.class);
  }

  @Override
  @Nullable
  public SDNameArgument getNameArgument() {
    return findChildByClass(SDNameArgument.class);
  }

  @Override
  @Nullable
  public SDViewsSection getViewsSection() {
    return findChildByClass(SDViewsSection.class);
  }

  @Override
  @NotNull
  public String getElementName() {
    return SDPsiImplUtil.getElementName(this);
  }

  @Override
  @Nullable
  public String getElementDescription() {
    return SDPsiImplUtil.getElementDescription(this);
  }

}
