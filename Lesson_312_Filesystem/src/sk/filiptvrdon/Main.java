package sk.filiptvrdon;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
        Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
        try{
            Files.copy(sourceFile, copyFile);
        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }




    }

    private static void printFile(Path path){
        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                System.out.println("*****************");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}