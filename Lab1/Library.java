package Lab1; // Library.java is part of the Lab1 folder I've created

/*
 * Library.java has 2 classes:
 * UserLibrary class which handles adding books to the user's inventory, lists books in the user's inventory, facilitates the user to 
 * purchase books, and allows reading 20 lines 
 * and
 * Library class populates with all of the books, returns all books in the library, lists all books, and searches for books
 */

import java.util.ArrayList; // this is the data stucture I've used to store books
import java.io.BufferedReader; // for better performance for larger files and for more specific error throwing
import java.io.FileReader; // file reading purposes
import java.io.IOException; // throw exceptions
import java.util.Scanner; // scanner is better for parsing, here we need it for "Enter" 

class UserLibrary {
    private ArrayList<Book> UserLibraryBooks; // creating an array list of object type of Book in order to match with
                                              // the code from BookDemo.java
    private Library library; // for populating books
    /*
     * constructor which creates a new array list for all books the user has
     * purchased
     * and the library is populated from the Library class
     */

    public UserLibrary(Library library) {
        this.library = library;
        UserLibraryBooks = new ArrayList<>(); // empty array list, gets more populated as and when a new book is added
    }

    public void readUserBookForward(String title) {
        // try and catch statements
        // read the book
        try (BufferedReader reader = new BufferedReader(new FileReader(title))) {
            String line; // line stored

            Scanner sc = new Scanner(System.in); // scanner class for keyboard input from user

            // loop as long as true
            while (true) {
                int index = 0; // need to ensure 20 lines are presented on the screen
                while ((line = reader.readLine()) != null && index < 20) {
                    System.out.println(line); // print the line
                    index++; // increment the count by 1 after every line
                }
                if (index < 20) {
                    break; // break the loop if less than 20 lines

                }
                // taking user input for enter
                System.out.println("Press Enter to continue: ");
                sc.nextLine();

            }
            sc.close(); // closing the scanner
        } catch (IOException e) {
            System.err.println("Error reading file: " + e); // graceful error handling
        }
    }
    public void readUserBookBackward(String title) {
        // try and catch statements
        // read the book
        try (BufferedReader reader = new BufferedReader(new FileReader(title))) {
            ArrayList<String> backwardReading= new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                backwardReading.add(line);

            }
            int start = backwardReading.size() - 1;
            Scanner sc = new Scanner(System.in);
            for (int i = start; i >=0; i-=20){
                int stop = Math.max(i-19, 0);
                for (int j = i; j >= stop; j--){
                    System.out.println(backwardReading.get(j));
                }
                System.out.println("Press Enter to continue: ");
                sc.nextLine();
            }
        
        }
        
        catch (IOException e){
                System.err.println("Error reading file: " + e);
        }
    }

    // which book and what word needs to be checked for
    public void onlySearchLines(String title, String match){
        try (BufferedReader reader = new BufferedReader(new FileReader(title))){
            String line;
            while ((line = reader.readLine()) != null){
                // // print if word match found
                if (line.contains(match)){
                    System.out.println(line); 
                }
                
            }
        } catch (IOException e){
            System.err.println("Error reading file: " + e);
        }
    
    }
    // adding 1 book at a time to user's library
    public void addToUserLibrary(Book book) {
        UserLibraryBooks.add(book);
    }

    // listing ALL books present in the user's library
    public void listUserLibrary() {
        for (Book book : UserLibraryBooks) {
            System.out.println(book);
            System.out.println();
        }
    }

    // user purchasing a book with book title
    public void purchaseBook(String title) {
        boolean found = false; // boolean whether or not a book is found

        for (Book book : library.getAllBooks()) {
            // if the title entered by user matches that of the book's title the user will
            // be able to purchase the book
            if (title.equals(book.getTitle())) {
                // if found the book, turn boolean flag on add the book to the user library,
                addToUserLibrary(book);
                found = true;
                return;
            }
        }
        // if did not find the book, return error saying title not found
        if (!found) {
            System.err.println("Title: " + title + " not found");
        }
    }
}

public class Library {

    private ArrayList<Book> allBooks; // array list for all books in the library
    // constructor

    public Library() {
        allBooks = new ArrayList<>(); // initializing
        // adding books as per the format in BookDemo.java's Book class
        // title, author, publisher, and EbookNo
        allBooks.add(new Book("The Mahabharata of Krishna-Dwaipayana Vyasa Vana Parva, Part 1", "Vyasa", "John B. Hare",
                "11894"));
        allBooks.add(new Book("The Ramayana, Volume 2. Aranya, Kishkindha, and Sundara Kandam", "Valmiki",
                "Dutt, Manmatha Nath", "57826"));
        allBooks.add(new Book("Vikram and the Vampire", "Burton, Richard Francis, Sir", "David Widger", "2400"));
        allBooks.add(new Book("The Yoga Sutras of Patanjali: The Book of the Spiritual Man", "Patanjali", "J. C. Byers",
                "2526"));
        allBooks.add(new Book("Kate Bonnet: The Romance of a Pirate's Daughter", "Frank R. Stockton", "Suzanne Shell",
                "17053"));
        allBooks.add(new Book("Autobiography of a Yogi", "Paramahansa Yogananda", "Richard Tonsing", "7452"));
        allBooks.add(new Book("Pride and Prejudice", "Jane Austen", "Chuck Greif", "1342"));
        allBooks.add(new Book("Frankenstein; Or, The Modern Prometheus", "Mary Wollstonecraft Shelley", "Judith Boss",
                "84"));
    }

    // return the array list that has all books, this is required for the
    // UserLibrary, especially in the for loop to check for purchasing
    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    // add a book if the user wants to in the library (not his personal)
    public void addBook(Book book) {
        allBooks.add(book);

    }

    // list all the books in the library
    public void listAllBooks() {

        for (Book book : allBooks) {
            System.out.println(book);
            System.out.println();
        }
    }

    // search for books by title of the book
    public void searchBooks(String title) {

        for (Book book : allBooks) {
            if (title.equals(book.getTitle())) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Library l1 = new Library();
        // adding a book
        // l1.addBook(new Book("Romeo and Juliet", "William Shakespeare", "PG Shakespeare Team", "1513"));
        // l1.listAllBooks();
        // l1.searchBooks("Autobiography of a Yogi"); // search for the book
        // System.out.println("cleared library now user library");

        UserLibrary l2 = new UserLibrary(l1); // populating the library books, helpful in the for loop for checking the
                                              // book
        // user wants to buy the following books
        // l2.purchaseBook("Vikram and the Vampire");
        // l2.listUserLibrary(); // list books the user has in his own library
        // l2.purchaseBook("The Mahabharata of Krishna-Dwaipayana Vyasa Vana Parva, Part 1");
        // String filename = "/Users/koushalsmodi/Desktop/cs245/Lab1/Krishna.txt";
        // l2.readUserBook("/Users/koushalsmodi/Desktop/cs245/Lab1/Krishna.txt");
        // l2.listUserLibrary(); // list books the user has in his own library
        // l2.onlySearchLines("/Users/koushalsmodi/Desktop/cs245/Lab1/Krishna.txt", "cow");
        l2.readUserBookBackward("/Users/koushalsmodi/Desktop/cs245/Lab1/Krishna.txt"); // 21957


    }

}
