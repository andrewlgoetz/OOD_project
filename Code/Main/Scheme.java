package Main;

public abstract class Scheme {

  // Scheme holds encryption/decrpytion algorithm
  public abstract iMessage encrypt(iMessage input, int key);

  public abstract iMessage decrypt(iMessage input, int key);
 // must be able to retrieve/set key
  public abstract int getKey();

  public abstract void setKey(int key);
  // this supports decorator part 2
}

