package by.horevich.compositetask.service;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;
import by.horevich.compositetask.parser.ParagraphHandler;
import by.horevich.compositetask.parser.SentenceHandler;
import by.horevich.compositetask.parser.LexemeHandler;
import by.horevich.compositetask.parser.WordHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexemeSorterTest {

  private static Stream<Arguments> textProvider() {
    return Stream.of(
            Arguments.of(
                    "Hello world! This is amazing.",
                    List.of("Hello world!", "This is amazing.")
            ),
            Arguments.of(
                    "A. B, c! D e f.",
                    List.of("A.", "B, c!", "D e f.")
            )
    );
  }


  @ParameterizedTest
  @MethodSource("textProvider")
  void testSortSentencesByWordCount(String input, List<String> expectedOrder) {
    TextComposite text = new TextComposite(TextType.TEXT);
    TextComposite paragraph = new TextComposite(TextType.PARAGRAPH);
    text.add(paragraph);

    ParagraphHandler paragraphHandler = new ParagraphHandler();
    SentenceHandler sentenceHandler = new SentenceHandler();
    LexemeHandler lexemeHandler = new LexemeHandler();
    WordHandler wordHandler = new WordHandler();

    paragraphHandler.setSuccessor(sentenceHandler);
    sentenceHandler.setSuccessor(lexemeHandler);
    lexemeHandler.setSuccessor(wordHandler);

    paragraphHandler.parse(input, paragraph);

    SentenceLexemeSorter sorter = new SentenceLexemeSorter();
    List<TextComposite> sortedSentences = sorter.sortSentencesByWordCount(text);

    for (int i = 0; i < expectedOrder.size(); i++) {
      assertEquals(expectedOrder.get(i), sortedSentences.get(i).textRebuild());
    }
  }
}
