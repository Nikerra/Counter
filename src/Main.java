import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println(""" 
                            Добрый день я простой счетчик, для моей работы введите в консоли одну из команд:
                            
                            Команда /inc увеличит мое значение на одну единицу
                            Команда /stop остановит мою работу и запомнит мое состояние
                            Команда /reset сбросит мой показатель обратно к нулю
                            """);
        // Вызов класса для работы счетчика
        new WorkCounter().work();

    }
}