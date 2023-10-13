import java.util.Scanner;
public class Main {

    public static void greetings() throws java.io.FileNotFoundException{
        System.out.println("Вы хотите сыграть в игру? {Y}   {N}");
        startGame();
    }

    public static void startGame() throws java.io.FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("N") || answer.equals("n")){
            Logic.disagree();
        } else if(answer.equals("Y") || answer.equals("y")){
            String word =  Logic.agree();
            String mask = Logic.createMask(word);
            Logic.gameLoop(word,mask);
        } else {
            System.out.println("Некорректный ответ");
            System.out.println("Введите Y(y) или N(n)");
            startGame();
        }
        scanner.close();
    }


    public static void main(String[] args) throws java.io.FileNotFoundException {
        greetings();
    }
}
