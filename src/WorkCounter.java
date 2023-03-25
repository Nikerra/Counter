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

    //  Работа счетчика
    public  int work() {


        CounterService.counter =  new CounterService().fileExists();//вызов метода для проверки наличия файла и получения состояния счетчика
        System.out.println("Счетчик загружен, значение \'" + CounterService.counter + "\'");
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
                    CounterService.counter++;
                    new CounterService().print();
                }
                case STOP -> {
                    new CounterService().print();
                    System.out.println("\"Завершаю работу\"");
                    new CounterService().save(CounterService.counter);
                    flag = false;
                }
                case RESET -> {
                    CounterService.counter = 0;
                    new CounterService().print();
                }
                default -> System.out.println("Команда не найдена");

            }
        }
        return CounterService.counter;
    }
}
