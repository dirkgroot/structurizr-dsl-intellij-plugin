// This is a generated file. Not intended for manual editing.
package nl.dirkgroot.structurizr.dsl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SDImplicitRelationshipStatement extends SDStatement {

  @NotNull
  List<SDArgument> getArgumentList();

  @Nullable
  SDBlock getBlock();

  @NotNull
  SDRelationshipDestination getRelationshipDestination();

  @NotNull
  SDRelationshipKeyword getRelationshipKeyword();

}
