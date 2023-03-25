import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkCounter {
    final static String INC = "/inc";
    final static String STOP = "/stop";
    final static String RESET = "/reset";


    public static int workCounter() {

        int counter =  new IsFileCounterSave().isFileCounterSave();//вызов класса для проверки наличия файла и получения состояния счетчика
        boolean flag = true;
        String command = "";
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
            //command = command.toLowerCase(Locale.ROOT);

//  В switch проверяем команду и выполняем соответствующие действие;
//  Так же добавляем default чтобы выводить автоответ на все другие
//  варианты ввода в консоль.
            switch (command) {
                case INC -> {
                    System.out.println("Состояние счетчика увеличенно на одну единицу");
                    counter++;
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                }
                case STOP -> {
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                    System.out.println("\"Завершаю работу\"");
//                    SaveCounter.saveCounter(counter);
                    flag = false;
                }
                case RESET -> {
                    counter = 0;
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                }
                default -> System.out.println("Команда не найдена");

            }
        }
        return counter;
    }
}
