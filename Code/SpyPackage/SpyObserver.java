package SpyPackage;

import Main.*;

public interface SpyObserver extends Unit {
  public void die();

  public boolean getIsDead();

  public boolean getIsReg();

  public void register();

  public void getUpdate(Scheme s);

  public void send(String text, Unit dest);

  public void receive(iMessage m);
}
