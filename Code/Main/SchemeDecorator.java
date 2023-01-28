package Main;

public abstract class SchemeDecorator extends Scheme {
    protected Scheme wrap;

    public SchemeDecorator(Scheme s){
        this.wrap = s;

    }

    @Override
    public abstract iMessage encrypt(iMessage input, int key);
    @Override
    public abstract iMessage decrypt(iMessage input, int key);

    @Override
    public abstract int getKey();

    @Override
    public abstract void setKey(int key);


}
