import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Memory {

    public static void main(String[] args)  {

        Memory memory = new Memory();
        memory.getPlayerResponse();
    }
    public void getPlayerResponse(){

        Path path = Paths.get("src/words/Words.txt");

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(System.out::println);
        } catch (IOException ex) {
            // Handle exception
        }
    }

}
