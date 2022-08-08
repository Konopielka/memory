import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;



public class Memory {



    private static String[][] board = new String[2][4];
    private static String[][] cards = new String[2][4];


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Memory memory = new Memory();
        //memory.readFile();
        printBoard();
        System.out.println("");
        randomWords();

        while (true){
            System.out.println("press n for new game, q for quit");
            String nq = scanner.nextLine();
            if(nq.equals("q")){
                System.out.println("end");
                break;
            }else if(nq.equals("n")){

                randomWords();
                for (int i = 0; i<2;i++){
                    for (int j = 0; j<4;j++){
                        board[i][j] = "X";
                    }
                }
                printBoard();
                checkInput(cards);
                break;

            }else{
                System.out.println("press n for new game, q for quit");
            }

        }

    }
        public static void randomWords(){
            ArrayList<String> listOfStrings;
            String filename = "C:\\Users\\Jakub Szwaj\\IdeaProjects\\memory\\memory\\src\\words\\Words.txt";
            try {
                listOfStrings = (ArrayList<String>) Files.readAllLines(Path.of(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] array = listOfStrings.toArray(new String[4]);

            Random random = new Random();
//            int index = random.nextInt(array.length);
//            System.out.println(array[index]);

            for (int i = 0; i<4; i++){
                //for(int j = 0; j<4; j++){
                    int index = random.nextInt(array.length);

                    cards[0][i] = array[index];



//                    indexArray.add(String.valueOf(index));
                   // int index2 = random.nextInt(indexArray.size());

                    cards[1][i]= array[index];
                    //Arrays.stream(array).toList().remove(index);
                //}
            }
        }


    public static void printBoard(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void checkInput(String[][] cards){
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!gameOver()){
                System.out.println("row AB, column 1-4");
                int rowA = scanner.nextInt();
                int column1 = scanner.nextInt();

                if (!board[rowA - 1][column1-1].equals("X")){
                    System.out.println("Already entered");
                    System.out.println();

                    printBoard();
                    continue;
                }else {
                    board[rowA-1][column1-1] = " " + cards[rowA-1][column1-1] + " ";
                    printBoard();
                }
                System.out.println("rr");
                int rowB = scanner.nextInt();
                System.out.println("column1-4");
                int column2 = scanner.nextInt();

                if(!board[rowB-1][column2-1].equals("X")){
                    System.out.println("already entered");
                    board[rowA-1][column1-1] = "X";
                    System.out.println();

                            printBoard();

                }else {
                    board[rowB-1][column2-1] = " " + cards[rowB-1][column2-1]+ " ";

                    if(board[rowA-1][column1-1].equals(board[rowB-1][column2-1])){
                        printBoard();
                        System.out.println("ok");
                    }else {
                        printBoard();
                        System.out.println("false");
                        board[rowA-1][column1-1] = "X";
                        board[rowB-1][column2-1] = "X";
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
