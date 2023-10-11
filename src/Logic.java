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

    public static String maska(String word){
        String mask = "*".repeat(word.length());
        return mask;
    }

    String mask_test = "";
    static String used = "";
    public static void game(String word, String maska) throws java.io.FileNotFoundException{
        System.out.println(word);

        System.out.println("Ваше слово: " + maska);
        System.out.println("Введите букву");
        int counterOfMistakes = 0;
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next().toLowerCase(Locale.ROOT);
        System.out.println(answer);



        if (answer.length()>1 || !answer.matches("[а-яА-Я]")){
            System.out.println("Неккоректный ответ, введите букву на кириллице!");
        } else if (word.contains(answer) && !used.contains(answer)){
            used +="'"+answer+"'";
            System.out.println("буквы, которые вы использовали: "+ used);
            int indexToReplace = word.indexOf(answer);
            maska = maska.substring(0, indexToReplace) + answer + maska.substring(indexToReplace+1);
            System.out.println(indexToReplace);
            System.out.println(maska);
            game(word,maska);
            right();
        } else if (used.contains(answer)) {
            System.out.println("Вы уже использовали данную букву!");
            System.out.println("буквы, которые вы использовали: "+ used);
            game(word,maska);
        } else {
            used += "'"+answer+"'";
            counterOfMistakes++;
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
