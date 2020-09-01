// This is a generated file. Not intended for manual editing.
package ua.com.miltrex.openhab.language.things.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ua.com.miltrex.openhab.language.things.psi.ThingsTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ua.com.miltrex.openhab.language.things.psi.*;

public class ThingsThingItemImpl extends ASTWrapperPsiElement implements ThingsThingItem {

  public ThingsThingItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ThingsVisitor visitor) {
    visitor.visitThingItem(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ThingsVisitor) accept((ThingsVisitor)visitor);
    else super.accept(visitor);
  }

}
