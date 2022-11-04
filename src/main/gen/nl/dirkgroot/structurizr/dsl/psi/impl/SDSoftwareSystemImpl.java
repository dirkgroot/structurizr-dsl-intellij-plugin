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
import java.util.Set;

public class SDSoftwareSystemImpl extends ASTWrapperPsiElement implements SDSoftwareSystem {

  public SDSoftwareSystemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitSoftwareSystem(this);
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
  @NotNull
  public SDNameArgument getNameArgument() {
    return findNotNullChildByClass(SDNameArgument.class);
  }

  @Override
  @Nullable
  public SDTagsArgument getTagsArgument() {
    return findChildByClass(SDTagsArgument.class);
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

  @Override
  @NotNull
  public Set<String> getElementTags() {
    return SDPsiImplUtil.getElementTags(this);
  }

}
