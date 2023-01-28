package HomePackage;

import FieldPackage.Field;
import Main.Scheme;
import Main.Unit;

public interface HomeSubject extends Unit {
  // update all observers
  public void updateAll();

  //update specific observer
  public void sendUpdate(Field fb);

  //change scheme
  public void setScheme(Scheme a);

  // Field bas go dark
  public void unsub(Field f);

  //field base re-register
  public void subscribe(Field f);

  //get scheme info
  public Scheme getScheme();
}
