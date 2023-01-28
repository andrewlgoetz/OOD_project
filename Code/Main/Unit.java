package Main;

public interface Unit {
  // Home, Spies, and Field Bases need to send and receive messages
  public void send(String text, Unit dest);

  public void receive(iMessage m);
}
