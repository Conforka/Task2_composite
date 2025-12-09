package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;
import by.horevich.compositetask.decomposite.CharacterLeaf;

public class LexemeHandler extends AbstractTextHandler {


  @Override
  public void parse(String text, TextComposite parent) {

    TextComposite lexemeComposite = new TextComposite(TextType.LEXEME);
    parent.add(lexemeComposite);

    StringBuilder wordBuffer = new StringBuilder();

    for (char c : text.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        wordBuffer.append(c);
      } else {
        if (wordBuffer.length() > 0) {
          getSuccessor().parse(wordBuffer.toString(), lexemeComposite);
          wordBuffer.setLength(0);
        }
        lexemeComposite.add(new CharacterLeaf(c, TextType.PUNCTUATION));
      }
    }

    if (wordBuffer.length() > 0) {
      getSuccessor().parse(wordBuffer.toString(), lexemeComposite);
    }
  }

}
