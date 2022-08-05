import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Memory {

    public static void main(String[] args)  {

        Memory memory = new Memory();
        memory.readFile();
        board();


    }
    public void readFile() {
        Path path = Paths.get("src/words/Words.txt");
        ArrayList<String> result = new ArrayList<>();

        try (Stream<String> st = Files.lines(path, StandardCharsets.UTF_8)){
            Random random = new Random();
            //st.collect(Collectors.toList()).size();

//            for (int i = 0; i< st.toList().size(); i++){
//                st.forEach(System.out::println);
//
//            }
            st.forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println("Unable to read" + path);
        }

    }
    public static void board(){
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.print("A");
            }else{
                System.out.println("B");
            }
            for (int j = 0; j < 4; j++) {
                System.out.print("X");
            }
        }


    }

}
