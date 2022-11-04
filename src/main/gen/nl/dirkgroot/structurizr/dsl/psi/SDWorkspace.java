// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SDWorkspace extends SDElementWithName, SDElementWithDescription {

  @Nullable
  SDDescriptionArgument getDescriptionArgument();

  @Nullable
  SDModelSection getModelSection();

  @Nullable
  SDNameArgument getNameArgument();

  @Nullable
  SDViewsSection getViewsSection();

  @NotNull
  String getElementName();

  @Nullable
  String getElementDescription();

}
