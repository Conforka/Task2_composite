package by.horevich.compositetask.service;

import by.horevich.compositetask.decomposite.TextComponent;
import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SentenceLexemeSorter {

  public List<TextComposite> sortSentencesByWordCount(TextComposite text) {
    List<TextComposite> sentences = new ArrayList<>();

    for (TextComponent paragraphComp : text.getComponents()) {
      if (!(paragraphComp instanceof TextComposite paragraph)) continue;
      if (paragraph.getType() != TextType.PARAGRAPH) continue;

      for (TextComponent sentenceComp : paragraph.getComponents()) {
        if (!(sentenceComp instanceof TextComposite sentence)) continue;
        if (sentence.getType() == TextType.SENTENCE) {
          sentences.add(sentence);
        }
      }
    }

    sentences.sort(Comparator.comparingInt(this::countWordsInSentence));

    return sentences;
  }

  private int countWordsInSentence(TextComposite sentence) {
    int count = 0;
    for (TextComponent comp : sentence.getComponents()) {
      if (comp instanceof TextComposite lexeme && lexeme.getType() == TextType.LEXEME) {
        if (!lexeme.textRebuild().isBlank()) {
          count++;
        }
      }
    }
    return count;
  }

}
