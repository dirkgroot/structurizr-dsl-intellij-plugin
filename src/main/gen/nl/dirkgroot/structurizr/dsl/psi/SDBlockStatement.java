// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SDBlockStatement extends PsiElement {

  @NotNull
  List<SDArgument> getArgumentList();

  @NotNull
  List<SDBlockStatement> getBlockStatementList();

  @NotNull
  List<SDExplicitRelationship> getExplicitRelationshipList();

  @Nullable
  SDIdentifierName getIdentifierName();

  @NotNull
  List<SDImplicitRelationship> getImplicitRelationshipList();

  @NotNull
  SDKeyword getKeyword();

  @NotNull
  List<SDPropertyBlockStatement> getPropertyBlockStatementList();

  @NotNull
  List<SDScriptBlock> getScriptBlockList();

  @NotNull
  List<SDSingleLineStatement> getSingleLineStatementList();

}
