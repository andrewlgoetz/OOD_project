package SpyPackage;

import FieldPackage.AField;
import Main.*;

public class FieldShell {
  //subject methods for field shell - limits spy access to AField Class
  private AField field; // - use to call field methods

  // pass in Full Field instance - interface segregation
  public FieldShell(AField f) {
    this.field = f;
  }

  // Below are the Field Mthods that Spies are given Access to:

  public Scheme getScheme() {
    return field.getScheme();
  }

  public void killSpy(SpyObserver agent) {
    field.killSpy(agent);
  }

  public boolean regSpy(SpyObserver agent) {
    return field.regSpy(agent);
  }
}
