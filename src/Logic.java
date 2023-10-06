import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    static public void disagree(){
        System.out.println("Пока пока!");
    }
}

class GettingRandomWord {
    public static void GettingRandomWord() throws java.io.FileNotFoundException {
        File file = new File("Words");
        Scanner scanner = new Scanner(file);
        String worldsLine = scanner.nextLine();
        String [] wordsArray = worldsLine.split(" ");

        Random random = new Random();
        int randomInxex = random.nextInt(wordsArray.length);

        String word = wordsArray[randomInxex];
        System.out.println(word);
    }


    public static void main(String[] args) throws java.io.FileNotFoundException {
        GettingRandomWord();
    }
}
