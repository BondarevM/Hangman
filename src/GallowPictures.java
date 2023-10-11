public  class GallowPictures {
    public static void makeMistake(int n) throws java.io.FileNotFoundException{
        if(n == 1){
            System.out.println("__________\n|        |\n|        O\n|\n|\n|\n|");
        }
        if (n == 2){
            System.out.println("__________\n|        |\n|        O\n|        |\n|        |\n|\n|");
        }
        if (n == 3){
            System.out.println("__________\n|        |\n|        O\n|       /|\n|        |\n|\n|" );
        }
        if (n == 4){
            System.out.println("__________\n|        |\n|        O\n|       /|\\\n|        |\n|\n|" );
        }
        if (n == 5){
            System.out.println("__________\n|        |\n|        O\n|       /|\\\n|        |\n|       /\n|" );
        }
        if (n == 6) {
            System.out.println("__________\n|        |\n|        O\n|       /|\\    GAME OVER\n|        |\n|       / \\\n|" );

            System.out.println("Хотите попробовать еще? {Y}   {N}");
            Logic.used = "";
            Logic.counterOfMistakes = 0;
            Main.startGame();
        }
    }
}
