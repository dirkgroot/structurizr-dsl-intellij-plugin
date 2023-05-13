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

public class SDPropertiesDefinitionImpl extends SDStatementImpl implements SDPropertiesDefinition {

  public SDPropertiesDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull SDVisitor visitor) {
    visitor.visitPropertiesDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SDVisitor) accept((SDVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SDPropertiesBlock getPropertiesBlock() {
    return findNotNullChildByClass(SDPropertiesBlock.class);
  }

  @Override
  @NotNull
  public SDPropertiesKeyword getPropertiesKeyword() {
    return findNotNullChildByClass(SDPropertiesKeyword.class);
  }

}
