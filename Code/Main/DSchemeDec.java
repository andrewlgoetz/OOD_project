package Main;

public class DSchemeDec extends SchemeDecorator {

    public DSchemeDec(Scheme s) {
        super(s);
        
    }
    

    @Override //Wrap one encrypted message with antoher
    public iMessage encrypt(iMessage input, int key) {
        
        return new Message(
            "[Encrypted with DScheme(" + key + "): " + wrap.encrypt(input, key).data + "]");
    }


    @Override // wrap encryped messages but in reverse order to decrypt.
    public iMessage decrypt(iMessage input, int key) {
        return new Message( 
            wrap.decrypt(new Message("[Decrypted with DScheme(" + key + "):" + input.data + "]"), key).data);
            
            
            //"[Decrypted with DScheme(" + key + "): " + wrap.decrypt(input, key).data + "]");
        
        }

    @Override
    public int getKey() {
        
        return wrap.getKey();
    }

    @Override
    public void setKey(int key) {
        wrap.setKey(key);
        
    }

}
