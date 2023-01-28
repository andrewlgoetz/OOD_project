package Main;

import FieldPackage.AField;
import FieldPackage.HomeShell;
import HomePackage.Home;
import SpyPackage.FieldShell;
import SpyPackage.Spy;

public class Runner {

  public static void main(String[] args) {
    
    //Field b = new AField(h);

    // Runner uses full home not home shell

    /* 
    AField london = new AField(hs);
    FieldShell londonShell = new FieldShell(london);

    Spy buddy = new Spy(londonShell);
    buddy.send("Hello World", h);
    london.goDark();
    AField Munich = new AField(hs);
    FieldShell MunichShell = new FieldShell(Munich);
    //give units a username they pass into messenger upon init
    // messenger prints username upon receive
    Spy john = new Spy(MunichShell);
    Scheme blue = new BScheme(5);
    london.sub();
    h.setScheme(blue);
    h.setScheme(new BScheme(88));
    john.send("Hello Buddy", buddy);

        buddy.send("Hello World", h);
        buddy.die();
        h.setScheme(new BScheme(76));
        john.send("Hello Buddy", london);
        london.send("Wya", Home.getInstance());
        
    // buddy shoudnt send here - test if he can recieve
    buddy.send("Hello World", h);
    london.sub();
    london.send("test", h);
                            */
    System.out.println("\n ------- Part 1:\n");  
    // generate home & shell instance
    Home h = Home.getInstance();
    HomeShell hs = new HomeShell();

    //create two field bases (and shells) for testing
    AField munich = new AField(hs);
    FieldShell munichShell = new FieldShell(munich);
    AField london = new AField(hs);
    FieldShell londonShell = new FieldShell(london);

    //create Spies
    Spy craig = new Spy(munichShell);
    Spy brosnan = new Spy(munichShell);
    Spy connery = new Spy(londonShell);
    Spy dalton = new Spy(londonShell);


    h.setScheme(new AScheme(12));
    // Send messages

    //home to spy:
    h.send("First Message", dalton);

    //spy to home:
    craig.send("Second Message", h);  

    //change scheme
    h.setScheme(new BScheme(54));

    //home to field:
    h.send("Third Message", london);

    // Field Base go dark & change key:
    munich.goDark();
    h.setScheme(new BScheme(0));

    //field to field:
    //encryption should not match (munich went dark)
    munich.send("Fourth Message", london); 

    //re-register Field Base
    munich.sub();

    //field to spy:
    //Munich should have up to date scheme info after having re-registered
    munich.send("Fifth Message", brosnan);
    
    // kill spy:
    connery.die();

    //spy to field:
    // spy dead - should not send
    connery.send("This Message is from a dead spy", munich);

    // spy cannot re-register , so the message wont send the second time either
    connery.register();
    connery.send("This Message is from a dead spy", munich);
    
    //spy to spy:
    //we will get message sent notif - 
    //  but it will not print as connery is dead he cannot receive it.
    brosnan.send("Come over, sweetheart.", connery);

    //field to spy:
    london.send("Final Message, Part 1.", dalton);
    


    System.out.println("\n\n ------- Part 2: \n\n");
    
    // wrap scheme
    Scheme wrapped = new BScheme(10);
    wrapped = new DSchemeDec(wrapped);
    
    // set scheme, create spy, and send message
    h.setScheme(wrapped);
    Spy burrito = new Spy(munichShell);
    burrito.send("Test Decorator", h);

    // wrap again and sned
    wrapped = new CSchemeDec(wrapped);
    h.setScheme(wrapped);
    burrito.send("One more layer...", h);

    // wrap again and send
    wrapped = new DSchemeDec(wrapped);
    h.setScheme(wrapped);
    burrito.send("Now, this is EPIC!", h);
 


    }

}