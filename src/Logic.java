import java.io.File;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;



public class Logic {
    static public void disagree(){
        System.out.println("Пока пока!");
    }


    public static String agree() throws java.io.FileNotFoundException {
        String word = GettingRandomWord.GettingRandomWord();
//        System.out.println(word);
        return word;


    }

    public static void game(String word) throws java.io.FileNotFoundException{
        System.out.println(word);
        String mask = "*".repeat(word.length());
        String maskAfter = "";

        System.out.println("Ваше слово: " + mask);
        System.out.println("Введите букву");
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next().toLowerCase(Locale.ROOT);
        System.out.println(answer);

        String used = "аоуюои";

        if (answer.length()>1 || !answer.matches("[а-яА-Я]")){
            System.out.println("Неккоректный ответ, введите букву на кириллице!");
        } else if (answer.contains(answer) && !used.contains(answer)){
            used +=answer;
            int indexToReplace = word.indexOf(answer);
            mask = mask.substring(0, indexToReplace) + answer + mask.substring(indexToReplace+1);
            System.out.println(indexToReplace);
            game(word);
            right();
        } else if (used.contains(answer)) {
            System.out.println("Вы уже использовали данную букву!");
            game(word);
        } else {
            wrond();
        }
    }

    public static void right(){
        System.out.println("right");

    }

    public static void wrond(){
        System.out.println("wrong");
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
