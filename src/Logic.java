import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Logic {
    static public void disagree(){
        System.out.println("Пока пока!");
    }


    public static void agree() throws java.io.FileNotFoundException {
        String word = GettingRandomWord.GettingRandomWord();
        System.out.println(word);
        String mask = "*".repeat(word.length());
        System.out.println("Ваше слово: " + mask);

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.length()>1 || !answer.matches("[а-яА-Я]")){
            System.out.println("Неккоректный ответ, введите букву!");

        } else {
            ;
        }
    }

}

class GettingRandomWord {
    public static String GettingRandomWord() throws java.io.FileNotFoundException {
        File file = new File("Words");
        Scanner scanner = new Scanner(file);
        String worldsLine = scanner.nextLine();
        String [] wordsArray = worldsLine.split(" ");

        Random random = new Random();
        int randomInxex = random.nextInt(wordsArray.length);
        String word = wordsArray[randomInxex];
        return word;
    }


    public static void main(String[] args) throws java.io.FileNotFoundException {

    }
}
