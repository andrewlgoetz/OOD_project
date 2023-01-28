package FieldPackage;

import Main.*;
import SpyPackage.*; // needs access to spy Data

public class AField implements Field {
  // allows access to select Home functionality
  private HomeShell homeShell;
  // denotes Field Gone Dark
  private boolean goneDark;
  // For sending Messages
  private MessagingMachine messenger;

  // subject attribute, List of Observers
  private iContactList<SpyObserver> spies;

  // AField Constructor
  // takes in a homeshell
  // creates Observer list
  // gets a messenger from HomeShell
  // subscribes to Home
  public AField(HomeShell home) {
    this.homeShell = home;
    spies = new Contacts<SpyObserver>();
    this.messenger = new MessagingMachine(homeShell.getScheme());
    homeShell.subscribe(this);
  }

  @Override // recevie SCheme from home
  public void getUpdate(Scheme s) {
    this.messenger.updateScheme(s);
    updateAll();
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

  @Override // unregister from home
  public void goDark() {
    if (!goneDark) {
      homeShell.unsub(this);
      goneDark = true;
    }
  }

  @Override // re-register to home
  public void sub() {
    if (goneDark) {
      homeShell.subscribe(this);
      goneDark = false;
    }
  }

  ////////// Subject methods

  // Accept a new spy
  // if spy is alive and unregistered:
  // give spy scheme info & add to observer list
  // return boolean to spy so spy knows that it has been registered
  @Override
  public boolean regSpy(SpyObserver agent) {
    if ((!agent.getIsDead()) && (!agent.getIsReg())) {
      spies.add(agent);
      sendUpdate(agent);
      System.out.println("Spy registered to Field Base.");
      return true;
    } else return false;
  }

  @Override // Spy dies - unregister
  public void killSpy(SpyObserver agent) {
    spies.remove(agent);
  }

  @Override // scheme getter
  public Scheme getScheme() {
    return messenger.getScheme();
  }

  // Same Update all as Home but with Spies as observers
  // call send update on every observer in the contact list
  @Override
  public void updateAll() { // -1 zero indexed
    if (this.spies.length() > 0) {
      for (int index = 0; index < spies.length(); index++) {
        sendUpdate(spies.getAt(index));
      }
    } //else System.out.println("No spies to notify.");
  }

  // call an individual Spies's update method
  public void sendUpdate(SpyObserver s) {
    s.getUpdate(this.getScheme());
  }
}
