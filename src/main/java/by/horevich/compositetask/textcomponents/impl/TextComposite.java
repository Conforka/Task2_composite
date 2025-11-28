package by.horevich.compositetask.textcomponents.impl;

import by.horevich.compositetask.textcomponents.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

  private List<TextComponent> components = new ArrayList<>();

  private TextType type;

  public TextComposite(TextType type){ this.type = type; }

  public void setType(TextType type){ this.type = type; }

  public TextType getType() {
    return type;
  }

  public boolean add(TextComponent textComponent){
    return components.add(textComponent);
  }

  @Override
  public String textrebuild(){
    String text = "";
    for (TextComponent component : components) {
      text += component.textrebuild();
    }
    return text;
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
