import java.io.*;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;


public class CounterService {


    private final static String fileName = "serial";

//Загрузка состояния
     private Integer load() {
        try(ObjectInputStream objIstr = new ObjectInputStream(new FileInputStream(fileName))) {
            return objIstr.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//  Сохранение состояния
    protected void save(int saveCounter) {
        try (ObjectOutputStream objOStr = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objOStr.writeInt(saveCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    protected int fileExists() {
//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска)
        return Optional.of(new File(fileName))
                .filter(File::exists)
                .map(f->load())
                .orElse(0);
//        File file = new File(fileName);
//        if (!file.exists()) {
//            counter = 0;
//        } else {
//            counter = load();
//        }
//        return counter;
        }



    protected void print(int counter){System.out.println("Текущее состояние счетчика \'" + counter + "\'");}

}
