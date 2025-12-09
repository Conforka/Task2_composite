package by.horevich.compositetask.service;

import by.horevich.compositetask.decomposite.*;
import by.horevich.compositetask.parser.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SwapTest {

  private static final String INPUT =
          "Hello world! This is amazing.";
  private static final String EXPECTED =
          "world! Hello amazing. is This";

  @Test
  void testFullParsingAndSwap() {

    TextComposite text = new TextComposite(TextType.TEXT);
    TextComposite paragraph = new TextComposite(TextType.PARAGRAPH);
    text.add(paragraph);

    WordHandler wordHandler = new WordHandler();
    LexemeHandler lexemeHandler = new LexemeHandler();
    SentenceHandler sentenceHandler = new SentenceHandler();
    ParagraphHandler paragraphHandler = new ParagraphHandler();

    paragraphHandler.setSuccessor(sentenceHandler);
    sentenceHandler.setSuccessor(lexemeHandler);
    lexemeHandler.setSuccessor(wordHandler);

    paragraphHandler.parse(INPUT, paragraph);

    new LexemeSwapService().swapInAllSentences(text);

    String result = text.textRebuild();

    assertEquals(EXPECTED, result);
  }
}
