import java.io.File;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    static public void disagree(){
        System.out.println("Пока пока!");
        System.exit(0);
    }

    public static String agree() throws java.io.FileNotFoundException {
        String word = GettingRandomWord.GettingRandomWord();
        return word;
    }
    public static String createMask(String word){
        String mask = "*".repeat(word.length());
        return mask;
    }

    public static void win(String word) throws java.io.FileNotFoundException{
        System.out.println("ВЫ ПОБЕДИЛИ!!!");
        System.out.println("Загаданное слово: "+ word);
        System.out.println("\uD83D\uDE04");

        System.out.println("Хотите попробовать еще? {Y}   {N}");
        Logic.used = "";
        Logic.counterOfMistakes = 0;
        Main.startGame();
    }

    static String used = "";
    static int counterOfMistakes = 0;
    public static void gameLoop(String word, String maska) throws java.io.FileNotFoundException{

        System.out.println("Использованные буквы: " + used);
        System.out.println("Ваше слово: " + maska);
        System.out.println("Введите букву");


        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next().toLowerCase(Locale.ROOT);

        if (answer.length()>1 || !answer.matches("[а-яА-Я]")){
            System.out.println("Неккоректный ответ, введите одну букву на кириллице!");
            gameLoop(word,maska);
        }  else if (word.contains(answer) && !used.contains(answer)){
            used +="'"+answer+"'";

            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == answer.charAt(0)){
                    maska = maska.substring(0, i) + answer + maska.substring(i+1);
                }
            }
            if(!maska.contains("*")){
                win(word);
            }
            gameLoop(word,maska);
        } else if (used.contains(answer)) {
            System.out.println("Вы уже использовали данную букву!");
            gameLoop(word,maska);
        } else {
            System.out.println("Неправильно!");
            used += "'"+answer+"'";
            counterOfMistakes++;
            GallowPictures.makeMistake(counterOfMistakes, word);
            gameLoop(word,maska);
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
