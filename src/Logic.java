import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Logic {
    static public void disagree(){
        System.out.println("Пока пока!");
    }


    public static String agree() throws java.io.FileNotFoundException {
        String word = GettingRandomWord.GettingRandomWord();
        System.out.println(word);
        return word;


    }

    public static void game(String word) throws java.io.FileNotFoundException{
        System.out.println(word);
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();




        if (answer.length()>1 || !answer.matches("[а-яА-Я]")){
            System.out.println("Неккоректный ответ, введите букву!");
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

}
