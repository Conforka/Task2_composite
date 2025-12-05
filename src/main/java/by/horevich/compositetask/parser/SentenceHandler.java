package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;

public class SentenceHandler extends AbstractTextHandler{

  private static final String REGEX_LEXEME_SPLIT = "\\s+";

  @Override
  public void parse(String text, TextComposite parent) {

    String[] lexems = text.split(REGEX_LEXEME_SPLIT);

    for (String lexeme : lexems) {
      TextComposite lexemeComposite = new TextComposite(TextType.LEXEME);
      parent.add(lexemeComposite);
      getSuccessor().parse(lexeme, lexemeComposite);
    }
  }
}
