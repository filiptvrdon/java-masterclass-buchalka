package sk.filiptvrdon;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {

       try{

//          Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//          Path destination = FileSystems.getDefault().getPath("Examples", "file1.txt");
//          Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile);


           Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
           Files.deleteIfExists(fileToDelete);




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