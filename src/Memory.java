import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Memory {

    public static void main(String[] args) throws FileNotFoundException {

        File words = new File("src/words/Words.txt");

        Scanner s = new Scanner(words);
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());

        s.close();

        }
    public void getPlayerResponse(){


    }
}
