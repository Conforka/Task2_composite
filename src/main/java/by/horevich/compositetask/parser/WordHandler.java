package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.CharacterLeaf;
import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;

public class WordHandler extends AbstractTextHandler {

  @Override
  public void parse(String text, TextComposite parent) {
    for (char c : text.toCharArray()) {
      parent.add(new CharacterLeaf(c, TextType.LETTER));
    }
  }
}
