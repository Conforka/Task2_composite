package by.horevich.compositetask.textcomponents.impl;
import by.horevich.compositetask.textcomponents.TextComponent;

public class CharacterLeaf implements TextComponent {

  private char character;
  private TextType type;

  public CharacterLeaf(char character) {
    this.character = character;
  }

  public CharacterLeaf (char character, TextType type) {
    this.character = character;
    this.type = type;
  }

  @Override
  public String textrebuild() {
    return String.valueOf(character);
  }

  @Override
  public int count(){ return 1; }

}
