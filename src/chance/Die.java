package chance;

public class Die {
    //The instance variables (State)

    private int order;
    private int top;

    //The constructors
    public Die () {
        order = 6;
        top = (int) ( ( Math.random() * 6 ) + 1);
    }
    public Die(int nrOfSides) {
        order = nrOfSides;
        top = (int) ( ( Math.random() * nrOfSides) + 1);
    }
    //The methods (behavior)
    public int top() {
        return  top;
    }
    public void roll() {
        top = (int) ( ( Math.random() * order ) + 1);
    }
}
