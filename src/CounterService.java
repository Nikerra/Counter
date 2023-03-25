import java.io.*;
import java.util.Locale;

public class CounterService {
    private final static String INC = "/inc";
    private final static String STOP = "/stop";
    private final static String RESET = "/reset";

    private final static String fileName = "serial";
    private static int counter;
    private static boolean flag = true;
    private static String command = "";

//Загрузка состояния
    private static int load() {
        try(ObjectInputStream objIstr = new ObjectInputStream(new FileInputStream(fileName))) {
            counter = objIstr.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }

//  Сохранение состояния
    private static void save(int saveCounter) {
        try (ObjectOutputStream objOStr = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Counter counter = new Counter(saveCounter);
            objOStr.writeInt(counter.getCounter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//  Работа счетчика
    public static int work() {

            counter =  fileExists();//вызов метода для проверки наличия файла и получения состояния счетчика
            System.out.println("Счетчик загружен, значение \'" + counter + "\'");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Запускаем цикл и ждем команду
// Пока не введена команда /stop

            while (flag) {
                try {
                    command = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                command = command.toLowerCase(Locale.ROOT);//чтобы игнорировать регистр команды

//  В switch проверяем команду и выполняем соответствующие действие;
//  Так же добавляем default чтобы выводить автоответ на все другие
//  варианты ввода в консоль.
                switch (command) {
                    case INC -> {
                        System.out.println("Состояние счетчика увеличенно на одну единицу");
                        counter++;
                        print();
                    }
                    case STOP -> {
                        print();
                        System.out.println("\"Завершаю работу\"");
                        save(counter);
                        flag = false;
                    }
                    case RESET -> {
                        counter = 0;
                        print();
                    }
                    default -> System.out.println("Команда не найдена");

                }
            }
            return counter;
        }


    private static int fileExists() {
//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска)
        File file = new File(fileName);
        //int counter;
        if (!file.exists()) {
            counter = 0;
        } else {
            counter = load();
        }
        return counter;
    }

    private static void print(){System.out.println("Текущее состояние счетчика \'" + counter + "\'");}

}
