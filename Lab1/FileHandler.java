package Lab1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// compile: javac Lab1/FileHandler.java
// run: java -cp . Lab1.FileHandler

public class FileHandler {
    public static void main(String[] args){
        String filename = "/Users/koushalsmodi/Desktop/cs245/Lab1/Krishna.txt";
        readTextFile(filename);

    }

    public static void readTextFile(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.err.println("Error reading file: " + e);
        }
    }
    
}
