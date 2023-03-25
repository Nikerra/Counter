import java.io.Serializable;

public class Counter implements Serializable {
    public static int counter;


    public Counter(int counter) {
        this.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

}
