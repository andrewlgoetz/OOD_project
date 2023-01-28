package SpyPackage;

import Main.*;

public class Spy implements SpyObserver {
    // spies start out alive -
    private boolean isDead = false;
    // Fieldshel used to call field methods and get updates
    private FieldShell field;
    // spy gets is registered status once it recives confirmation from a Field Base
    private boolean isReg;
    // for sending messages:
    private MessagingMachine messenger;

  public Spy(FieldShell f) {
    this.field = f; //how does this work
    this.messenger = new MessagingMachine(new AScheme(14));
    //this.s = f.getScheme();
    isReg = false; //true?
    isDead = false;
    register();
  }

  // send and receive functions from Unit interface
  @Override
  public void send(String text, Unit dest) {
    if (isDead) return;
    iMessage a = new Message(text);
    this.messenger.send(a, dest);
  }

  @Override
  public void receive(iMessage m) {
    if (isDead) return;
    this.messenger.receive(m);
  }
// when a spy dies they unregister (kill spy method in FieldShell)
  // nowhere spy isdead to go from true to false
  @Override
  public void die() {
    isDead = true;
    field.killSpy(this);
  }

  @Override
  public boolean getIsDead() {
    return isDead;
  }

  @Override
  public boolean getIsReg() {
    return isReg;
  }

  // called in constructo - assign spy a field base, 
  //and set isreg to result of registration 

  @Override 
  public void register() {
    if (!isReg && !isDead) {
      isReg = field.regSpy(this);
    }
    //System.out.println("spy registered status = " + isReg);
  }

  //update encryption/scheme info in local messagingMachine
  @Override
  public void getUpdate(Scheme s) {
    
    this.messenger.updateScheme(s);
    

  }
}
