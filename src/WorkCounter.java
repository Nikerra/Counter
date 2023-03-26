import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class WorkCounter {
    private final static String INC = "/inc";
    private final static String STOP = "/stop";
    private final static String RESET = "/reset";
    private static boolean flag = true;
    private static String command = "";

    private  int counter;
    //  Работа счетчика
    public void work() {

        CounterService counterService = new CounterService();
        counter =  counterService.fileExists();//вызов метода для проверки наличия файла и получения состояния счетчика
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
                    new CounterService().print(counter);
                }
                case STOP -> {
                    new CounterService().print(counter);
                    System.out.println("\"Завершаю работу\"");
                    new CounterService().save(counter);
                    flag = false;
                }
                case RESET -> {
                    counter = 0;
                    new CounterService().print(counter);
                }
                default -> System.out.println("Команда не найдена");

            }
        }
    }
}
