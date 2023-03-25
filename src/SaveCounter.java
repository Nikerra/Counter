import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveCounter implements Serializable {
    //Сохранение обьекта со значение счетчика
    public static void saveCounter(int saveCounter) {
        try(ObjectOutputStream objOStr = new ObjectOutputStream(new FileOutputStream("serial"))) {
        Counter counter = new Counter(saveCounter);
        objOStr.writeInt(counter.getCounter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
