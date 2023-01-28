package FieldPackage;

import HomePackage.Home;
import Main.*;

public class HomeShell {
  private Home home;

  // retrieve Home instance upon init - to call home functions
  // - interface segregation
  public HomeShell() {
    this.home = Home.getInstance();
  }

// Below are the Home Mthods that Field bases are given Access to:

  public void subscribe(Field f) {
    home.subscribe(f);
  }

  public void unsub(Field f) { //(unsub)
    home.unsub(f);
  }

  public Scheme getScheme() {
    return home.getScheme();
  }
}
