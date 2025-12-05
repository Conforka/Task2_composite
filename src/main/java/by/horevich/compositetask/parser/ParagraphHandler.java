package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;

public class ParagraphHandler extends AbstractTextHandler {

  private static final String REGEX_SENTENCE_SPLIT = "(?<=[.!?])\\s+";

  @Override
  public void parse(String text, TextComposite parent) {

    String[] sentences = text.split(REGEX_SENTENCE_SPLIT);
    for (String sentence : sentences) {
      TextComposite sentenceComposite = new TextComposite(TextType.SENTENCE);
      parent.add(sentenceComposite);

      getSuccessor().parse(sentence, sentenceComposite);
    }
  }
}
