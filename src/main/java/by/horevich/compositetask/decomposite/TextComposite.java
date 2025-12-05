package by.horevich.compositetask.decomposite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

  private List<TextComponent> components = new ArrayList<>();

  private TextType type;

  public TextComposite(TextType type){ this.type = type; }

  public TextType getType() {
    return type;
  }

  public boolean add(TextComponent textComponent){
    return components.add(textComponent);
  }

  public List<TextComponent> getComponents() {
    return components;
  }

  @Override
  public String textRebuild() {
    StringBuilder text = new StringBuilder();

    for (TextComponent component : components) {
      text.append(component.textRebuild());

      if (type == TextType.SENTENCE && component instanceof TextComposite
              && ((TextComposite) component).getType() == TextType.LEXEME) {
        text.append(" ");
      }

      if (type == TextType.PARAGRAPH && component instanceof TextComposite
              && ((TextComposite) component).getType() == TextType.SENTENCE) {
        text.append(" ");
      }
    }

    if (text.length() > 0 && text.charAt(text.length() - 1) == ' ') {
      text.deleteCharAt(text.length() - 1);
    }

    return text.toString();
  }

  @Override
  public int count() {
    int counter = 0;
    for (TextComponent component : components){
      counter += component.count();
    }
    return counter;
  }
}
