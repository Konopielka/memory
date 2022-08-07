import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Memory {

    private static String[][] board = new String[2][4];
    private static String[][] cards = new String[2][4];


    public static void main(String[] args) {

        Memory memory = new Memory();
        //memory.readFile();
        printBoard();
        System.out.println("");
        randomWord();
    }
        public static String randomWord (){
            List<String> listOfStrings = new ArrayList<String>();
            String filename = "C:\\Users\\Jakub Szwaj\\IdeaProjects\\memory\\memory\\src\\words\\Words.txt";
            try {
                listOfStrings = Files.readAllLines(Path.of(filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] array = listOfStrings.toArray(new String[0]);

            Random random = new Random();

            int index = random.nextInt(array.length);
            System.out.println(array[index]);


            for (int i =0; i<2; i++){
                for(int j = 0; j<4; j++){

                    cards[i][j] = array[index];
                    Arrays.stream(array).toList().remove(index);
                }
            }

            return array[index];
        }

        public static void checkInput(String [][] cards){

        }


        /*for (String eachString : array){
            System.out.println(eachString);
        }*/


    /*public void readFile() {

        Path path = Paths.get("C:\\Users\\Jakub Szwaj\\IdeaProjects\\memory\\memory\\src\\words\\Words.txt");
        ArrayList<String> result = new ArrayList<>();

        try (Stream<String> st = Files.lines(path, StandardCharsets.UTF_8)) {
            Random random = new Random();
            st.toList().size();

            for (int i = 0; i < st.toList().size(); i++) {
                st.forEach(System.out::println);

            }
            st.forEach(System.out::println);

           *//* for (int i = 0; i < st.toArray().length; i++) {
                st.toList().get(random.nextInt(st.toArray().length));
            }
            int randomIndex = (int) (Math.random() * st.toList().size());
            return st.toList().get(randomIndex);*//*

        } catch (IOException ex) {
            System.out.println("Unable to read" + path);
        */



    public static void printBoard(){
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.print("A ");
            }
            System.out.print("B ");

            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
