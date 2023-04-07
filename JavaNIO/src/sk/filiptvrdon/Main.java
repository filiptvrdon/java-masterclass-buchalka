package sk.filiptvrdon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.writeString(dataPath, "\nLine 5", StandardOpenOption.APPEND);


            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}