import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Book {

    public static ArrayList read(String bookName){ // input
        // operation
        String filename = "/Users/koushalsmodi/Desktop/cs245/Krishna.txt";
        readTextFile(filename);

        ArrayList <String> lines = new ArrayList<String>(20);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            lines.add(line);
        }
        scanner.close();
        return lines;

    }

    public static void readTextFile(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line  = reader.))

        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        switch(input){
            case ("read"):
            System.out.println("Enter book name: ");
            Scanner scan = new Scanner(System.in);
            String bookname = scan.next();
            read(bookname);
            break;
        }
        sc.close();
    }  
}
