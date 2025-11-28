package by.horevich.compositetask.chainparser;

import by.horevich.compositetask.textcomponents.impl.TextComposite;
import by.horevich.compositetask.textcomponents.impl.TextType;

public class ParagraphHandler extends AbstractTextHandler {

  @Override
  public void parse(String text, TextComposite parent) {
    if (text == null || text.isEmpty()) return;

    String[] sentences = text.split("(?<=[.!?])\\s+");
    for (String sentence : sentences) {
      TextComposite sentenceComposite = new TextComposite(TextType.SENTENCE);
      parent.add(sentenceComposite);

      if (getSuccessor() != null) {
        getSuccessor().parse(sentence, sentenceComposite);
      }
    }
  }
}
