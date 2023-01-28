package Main;

public class AScheme extends Scheme {
  private int key;

  public AScheme(int key) {
    this.key = key;
  }

  @Override
  public iMessage encrypt(iMessage input, int key) {
    return new Message(
      "[Encrypted with AScheme(" + key + "): " + input.data + "]"
    );
  }

  @Override
  public iMessage decrypt(iMessage input, int key) {
    return new Message(
      "[Decrypted with AScheme(" + key + "): " + input.data + "]"
    );
  }

  @Override
  public int getKey() {
    return key;
  }

  @Override
  public void setKey(int key) {
    this.key = key;
  }
}
