package by.horevich.compositetask.chainparser;

import by.horevich.compositetask.textcomponents.impl.TextComposite;

public abstract class AbstractTextHandler {
  protected AbstractTextHandler nextsuccessor;

  public abstract void parse(String text, TextComposite composite);

  public void setSuccessor(AbstractTextHandler successor) {
    this.nextsuccessor = successor;
  }
  public AbstractTextHandler getSuccessor() {
    return nextsuccessor;
  }

}
