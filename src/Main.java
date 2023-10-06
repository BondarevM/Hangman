import java.util.Scanner;
public class Main {

    public static void Greetings(){
        System.out.println("Вы хотите сыграть в игру? {Y}   {N}");
        startGame();
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("N") || answer.equals("n")){
            Logic.disagree();
        } else if(answer.equals("Y") || answer.equals("y")){
            System.out.println("Пошла игра");
        } else {
            System.out.println("Некорректный ответ");
            Greetings();
        }
        scanner.close();
    }

    public static void main(String[] args) {
    Greetings();
    }
}
