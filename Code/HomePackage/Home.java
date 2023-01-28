package HomePackage;

import FieldPackage.Field; // only use abstract Field type
import Main.*;

public class Home implements HomeSubject {
  // Singleton instance of HomeBase
  private static Home homeBase;

  // List of Observers
  private iContactList<Field> fieldBases;

  // Used to send messages
  private MessagingMachine messenger;

  // get singleton instance
  public static Home getInstance() {
    if (homeBase == null) {
      homeBase = new Home();
    }
    return homeBase;
  }

  // construct instance if not done yet.
  private Home() {
    fieldBases = new Contacts<Field>();
    messenger = new MessagingMachine(new AScheme(5));
  }

  @Override // send and receive functions from Unit interface
  public void send(String text, Unit dest) {
    iMessage a = new Message(text);
    messenger.send(a, dest);
  }

  @Override
  public void receive(iMessage m) {
    messenger.receive(m);
  }

  //Subscribe accepts field base to add to Observer list
  @Override
  public void subscribe(Field f) {
    fieldBases.add(f);
    sendUpdate(f);
  }

  @Override // - filedbases have unSubMe to go dark
  public void unsub(Field f) {
    fieldBases.remove(f);
  }

  @Override // calls sendUpdate on all Observers.
  public void updateAll() { // length is 1 indexed
    if (this.fieldBases.length() > 0) {
      for (int index = 0; index < fieldBases.length(); index++) {
        sendUpdate(fieldBases.getAt(index));
      }
    } else System.out.println("No field bases to notify.");
  }

  @Override // calls observers getudpate
  public void sendUpdate(Field fb) {
    fb.getUpdate(this.getScheme());
  }

  @Override // changes scheme info
  public void setScheme(Scheme a) {
    this.messenger.updateScheme(a);
    updateAll();
  }

  //retrieve scheme info
  @Override
  public Scheme getScheme() {
    return messenger.getScheme();
  }
}
