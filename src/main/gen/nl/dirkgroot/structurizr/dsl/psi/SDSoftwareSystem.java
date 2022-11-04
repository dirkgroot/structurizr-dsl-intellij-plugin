// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import java.util.Set;

public interface SDSoftwareSystem extends SDElementWithName, SDElementWithDescription, SDElementWithTags {

  @Nullable
  SDDescriptionArgument getDescriptionArgument();

  @NotNull
  SDNameArgument getNameArgument();

  @Nullable
  SDTagsArgument getTagsArgument();

  @NotNull
  String getElementName();

  @Nullable
  String getElementDescription();

  @NotNull
  Set<String> getElementTags();

}
