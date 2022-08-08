import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Memory {



    private static String[][] board = new String[2][4];
    private static String[][] cards = new String[2][4];
    private static int chances = 10;


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        printBoard();
        System.out.println("");
        randomWords();

        while (true){
            System.out.println("Type EASY for easy mode, type HARD for hard mode");
            String easyHard = scanner.nextLine();
            if(easyHard.equals("EASY")){
                randomWords();
                for (int i = 0; i<2;i++){
                    for (int j = 0; j<4;j++){
                        board[i][j] = "X";
                    }
                }
                printBoard();
                --chances;
                checkInput(cards);
                break;

            }else if(easyHard.equals("HARD")){
                randomWords();
                for (int i =0; i<2; i++){
                    for (int j = 0; j<8;j++){
                        board[i][j] = "X";
                    }
                }

            }

        }

    }
        public static void randomWords(){
            ArrayList<String> listOfStrings;
            String filename = "src/words/Words.txt";
            try {
                listOfStrings = (ArrayList<String>) Files.readAllLines(Path.of(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] array = listOfStrings.toArray(new String[4]);


            Random random = new Random();

            int index;

            for (int i = 0; i<4; i++){
                //for(int j = 0; j<4; j++){
                    index = random.nextInt(array.length);

                    cards[0][i] = array[index];
                    cards[1][i] = array[index];

//
               // }
            }
        }


    public static void printBoard(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
            }

            System.out.println(" left chances: " +  chances);
        }
    }

    public static void checkInput(String[][] cards){
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!gameOver()){
                System.out.println("row A to B, column 1 to 4");
                int rowA = scanner.nextInt();
                int column1 = scanner.nextInt();

                if (!board[rowA - 1][column1-1].equals("X")){
                    System.out.println("Already entered");
                    System.out.println();

                    printBoard();
                    --chances;
                    continue;
                }else {
                    board[rowA-1][column1-1] = " " + cards[rowA-1][column1-1] + " ";
                    printBoard();
                }

                System.out.println("row A - B");
                int rowB = scanner.nextInt();
                System.out.println("column1-4");
                int column2 = scanner.nextInt();


                if(!board[rowB-1][column2-1].equals("X")){
                    System.out.println("already entered");
                    board[rowA-1][column1-1] = "X";
                    System.out.println();
                    --chances;
                            printBoard();

                }else{
                    board[rowB-1][column2-1] = " " + cards[rowB-1][column2-1]+ " ";

                    if(board[rowA-1][column1-1].equals(board[rowB-1][column2-1])){
                        --chances;
                        printBoard();
                        System.out.println("ok");
                    }else {
                        printBoard();
                        System.out.println("false");
                        board[rowA-1][column1-1] = "X";
                        board[rowB-1][column2-1] = "X";
                        --chances;
                        printBoard();

                    }
                }

            }else {
                System.out.println("Game over");
                break;
            }
        }
    }
    public static boolean gameOver(){
        if (chances == 0){
            return true;

        }
        for (int i = 0; i<2; i++){
            for (int j = 0; j<4;j++){
                if(board[i][j].equals("X")){
                    return false;
                }
            }
        }
        return true;
    }


}
