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
            Logic.agree();
        } else {
            System.out.println("Некорректный ответ");
            greetings();
        }
        scanner.close();
    }

    public static void main(String[] args) throws java.io.FileNotFoundException {
        greetings();
    }
}
