package by.horevich.compositetask.decomposite;

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
  public String textRebuild() {
    return String.valueOf(character);
  }

  @Override
  public int count(){ return 1; }

}
