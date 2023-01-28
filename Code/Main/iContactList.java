package Main;

public interface iContactList<T> {
  // Necessary List Functionality, on generic type T
  public void add(T add);

  public void remove(T remove);

  public T getAt(int index);

  public int length();

}
