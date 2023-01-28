package Main;

public class MessagingMachine {
  private Scheme scheme;
  private int key;

  // Each Machine has an encryptor (scheme) and a key.
  // We only handle absatrct message type.
  public MessagingMachine(Scheme s) {
    this.scheme = s;
    this.key = s.getKey();
  }
  
  
  public iMessage encrypt(iMessage m) {
    return scheme.encrypt(m, key);
  }

  public iMessage decrypt(iMessage m) {
    return scheme.decrypt(m, key);
  }

  // change scheme info of this particular machine
  public void updateScheme(Scheme update) {
    this.scheme = update;
    this.key = update.getKey();
  }

  // send message type to another unit - automatically encrypt first
  public void send(iMessage m, Unit dest) {
    iMessage tosend = this.encrypt(m);
    System.out.println("Message sent. ");
    dest.receive(tosend);
    
  }
  // a unit receives messages through the machine - decrpyt and display
  public void receive(iMessage m) {
    iMessage text = this.decrypt(m);
    System.out.println("Message Received: " + text.data);
  }
  
  // retrieve current scheme in machine
  public Scheme getScheme() {
    return scheme;
  }
}
