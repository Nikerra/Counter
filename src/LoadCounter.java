import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LoadCounter implements Serializable {
    public static int loadCounter() {
        int counter;
        try(ObjectInputStream objIstr = new ObjectInputStream(new FileInputStream("serial"))) {
            counter = objIstr.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }
}
