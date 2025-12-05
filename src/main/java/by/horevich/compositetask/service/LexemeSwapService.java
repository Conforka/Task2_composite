package by.horevich.compositetask.service;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextComponent;
import by.horevich.compositetask.decomposite.TextType;

import java.util.ArrayList;
import java.util.List;

public class LexemeSwapService {

  public void swapFirstAndLastLexemes(TextComposite text) {
    if (text.getType() != TextType.TEXT) return;

    for (TextComponent paragraphComp : text.getComponents()) {
      if (!(paragraphComp instanceof TextComposite)) continue;
      TextComposite paragraph = (TextComposite) paragraphComp;
      if (paragraph.getType() != TextType.PARAGRAPH) continue;

      for (TextComponent sentenceComp : paragraph.getComponents()) {
        if (!(sentenceComp instanceof TextComposite)) continue;
        TextComposite sentence = (TextComposite) sentenceComp;
        if (sentence.getType() != TextType.SENTENCE) continue;

        List<TextComposite> lexemes = new ArrayList<>();
        for (TextComponent comp : sentence.getComponents()) {
          if (comp instanceof TextComposite && ((TextComposite) comp).getType() == TextType.LEXEME) {
            lexemes.add((TextComposite) comp);
          }
        }

        if (lexemes.size() > 1) {
          TextComposite first = lexemes.get(0);
          TextComposite last = lexemes.get(lexemes.size() - 1);

          List<TextComponent> sentenceComponents = sentence.getComponents();
          int firstIndex = sentenceComponents.indexOf(first);
          int lastIndex = sentenceComponents.indexOf(last);

          sentenceComponents.set(firstIndex, last);
          sentenceComponents.set(lastIndex, first);
        }
      }
    }
  }
}
