package Main;

import java.util.ArrayList;

  // Simple Array list implementation that takes a generic type T

public class Contacts<T> implements iContactList<T> {
  private ArrayList<T> contacts;

  public Contacts() {
    this.contacts = new ArrayList<T>();
  }

  @Override
  public void add(T add) {
    contacts.add(add);
  }

  @Override
  public void remove(T remove) {
    contacts.remove(remove);
  }

  @Override
  public T getAt(int index) {
    return contacts.get(index);
  }

  @Override
  public int length() {
    return contacts.size();
  }
}
