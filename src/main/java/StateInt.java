public class StateInt {

    private int value;

    public StateInt(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized int increment() {
        return value++;
    }

    public synchronized void add(int value) {
        this.value += value;
    }

}
