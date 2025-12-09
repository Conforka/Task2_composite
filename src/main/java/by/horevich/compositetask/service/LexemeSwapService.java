package by.horevich.compositetask.service;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextComponent;
import by.horevich.compositetask.decomposite.TextType;

import java.util.ArrayList;
import java.util.List;

public class LexemeSwapService {

  public void swapInAllSentences(TextComposite text) {
    for (TextComponent paragraphComp : text.getComponents()) {
      TextComposite paragraph = (TextComposite) paragraphComp;

      for (TextComponent sentenceComp : paragraph.getComponents()) {
        TextComposite sentence = (TextComposite) sentenceComp;
        swapLexemesInSentence(sentence);
      }
    }
  }

  private void swapLexemesInSentence(TextComposite sentence) {

    List<TextComposite> wordLexemes = new ArrayList<>();

    for (TextComponent component : sentence.getComponents()) {
      if (component instanceof TextComposite lexeme && lexeme.getType() == TextType.LEXEME) {
        if (!lexeme.textRebuild().isBlank()) {
          wordLexemes.add(lexeme);
        }
      }
    }

    if (wordLexemes.size() < 2) {
      return;
    }

    TextComposite first = wordLexemes.get(0);
    TextComposite last = wordLexemes.get(wordLexemes.size() - 1);

    List<TextComponent> components = sentence.getComponents();
    int firstIndex = components.indexOf(first);
    int lastIndex = components.indexOf(last);

    components.set(firstIndex, last);
    components.set(lastIndex, first);
  }
}
