package FieldPackage;

import Main.Scheme;
import Main.Unit;
import SpyPackage.SpyObserver;

public interface Field extends Unit {
  //Observer Methods:
  public void getUpdate(Scheme s);

  public void goDark();

  public void sub();

  // Subject Methods:
  public boolean regSpy(SpyObserver agent);

  public void killSpy(SpyObserver agent);

  public Scheme getScheme(); 

  public void updateAll();

  public void sendUpdate(SpyObserver s);
  
}
