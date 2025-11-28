package by.horevich.compositetask.chainparser;

import by.horevich.compositetask.textcomponents.impl.TextComposite;
import by.horevich.compositetask.textcomponents.impl.TextType;

public class TextHandler extends AbstractTextHandler {

  public TextHandler(AbstractTextHandler nextsuccessor) {
    this.nextsuccessor = nextsuccessor;
  }

  @Override
  public void parse(String text, TextComposite composite) {

    if (!text.isEmpty()) {
      String[] paragraphs = text.split("\\n\\n");

      for (String paragraphText : paragraphs) {
        TextComposite paragraphComposite = new TextComposite(TextType.PARAGRAPH);
        composite.add(paragraphComposite);

        if (getSuccessor() != null) {
          getSuccessor().parse(paragraphText, paragraphComposite);
        }
      }
    }
  }
}
