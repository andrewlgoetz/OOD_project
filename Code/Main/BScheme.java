package Main;

public class BScheme extends Scheme {
  public int key;

  public BScheme(int key) {
    this.key = key;
  }

  @Override
  public iMessage encrypt(iMessage input, int key) {
    return new Message(
      "[Encrypted with BScheme(" + key + "): " + input.data + "]"
    );
  }

  @Override
  public iMessage decrypt(iMessage input, int key) {
    return new Message(
      "[Decrypted with BScheme(" + key + "): " + input.data + "]"
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
