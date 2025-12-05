package by.horevich.compositetask.parser;

import by.horevich.compositetask.decomposite.TextComposite;
import by.horevich.compositetask.decomposite.TextType;
import by.horevich.compositetask.reader.BaseTextReader;
import by.horevich.compositetask.reader.impl.BaseTextReaderImpl;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

  @Test
  public void testParse() throws Exception {
    BaseTextReader reader = new BaseTextReaderImpl();
    List<String> lines = reader.read("textfile/file.txt");
    String original = String.join("\n", lines);

    WordHandler wordHandler = new WordHandler();
    LexemeHandler lexemeHandler = new LexemeHandler();
    lexemeHandler.setSuccessor(wordHandler);

    SentenceHandler sentenceHandler = new SentenceHandler();
    sentenceHandler.setSuccessor(lexemeHandler);

    ParagraphHandler paragraphHandler = new ParagraphHandler();
    paragraphHandler.setSuccessor(sentenceHandler);

    TextHandler textHandler = new TextHandler(paragraphHandler);

    TextComposite root = new TextComposite(TextType.TEXT);
    textHandler.parse(original, root);

    String rebuilt = root.textRebuild();

    Files.writeString(Paths.get("parser_output.txt"), rebuilt);

    assertEquals(original, rebuilt);
  }
}
