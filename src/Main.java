import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        //Вызов текстового описания программы
        ProgramDescription.programDescription();

        // Вызов класса для работы счетчика и его дальнейшее сохранение
        int counter = WorkCounter.workCounter();
        SaveCounter.saveCounter(counter);
    }
}