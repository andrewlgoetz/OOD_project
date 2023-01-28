package Main;

public class CSchemeDec extends SchemeDecorator {

    public CSchemeDec(Scheme s) {
        super(s);
        
    }
    

    @Override //Wrap one encrypted message with antoher
    public iMessage encrypt(iMessage input, int key) {
        
        return new Message(
            "[Encrypted with CScheme(" + key + "): " + wrap.encrypt(input, key).data + "]");
    }


    @Override // wrap encryped messages but in reverse order to decrypt.
    public iMessage decrypt(iMessage input, int key) {
        return new Message(
            wrap.decrypt(new Message("[Decrypted with CScheme(" + key + "):" + input.data + "]"), key).data);
            
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
