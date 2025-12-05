package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;

public class TextHandler extends AbstractTextHandler {

  private static final String REGEX_PARAGRAPH_SPLIT = "\\n\\n";

  public TextHandler(AbstractTextHandler nextSuccessor) {
    this.nextSuccessor = nextSuccessor;
  }

  @Override
  public void parse(String text, TextComposite composite) {

    String[] paragraphs = text.split(REGEX_PARAGRAPH_SPLIT);

    for (String paragraphText : paragraphs) {
      TextComposite paragraphComposite = new TextComposite(TextType.PARAGRAPH);
      composite.add(paragraphComposite);
      getSuccessor().parse(paragraphText, paragraphComposite);
    }
  }
}
