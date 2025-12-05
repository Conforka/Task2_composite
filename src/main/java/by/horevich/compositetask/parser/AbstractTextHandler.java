package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;

public abstract class AbstractTextHandler {
  protected AbstractTextHandler nextSuccessor;

  public abstract void parse(String text, TextComposite composite);

  public void setSuccessor(AbstractTextHandler successor) {
    this.nextSuccessor = successor;
  }
  public AbstractTextHandler getSuccessor() {
    return nextSuccessor;
  }

}
