import java.io.File;

public class IsFileCounterSave {

    public int isFileCounterSave() {
//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска
        File file = new File("serial");
        int counter;
        if (!file.exists()) {
            counter = 0;
        } else {
            counter = LoadCounter.loadCounter();
        }
        return counter;
    }
}
