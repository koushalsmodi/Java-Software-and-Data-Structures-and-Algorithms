package Lab1; // Library.java is part of the Lab1 folder I've created

/*
 * Library.java has 2 classes:
 * UserLibrary class which handles adding books to the user's inventory, lists books in the user's inventory, facilitates the user to 
 * purchase books, allows reading 20 lines, and partial matching
 * and
 * Library class populates with all of the books, returns all books in the library, lists all books, and searches for books
 */

import java.util.ArrayList; // this is the data stucture I've used to store books
import java.io.BufferedReader; // for better performance for larger files and for more specific error throwing
import java.io.FileReader; // file reading purposes
import java.io.IOException; // throw exceptions
import java.util.Scanner; // scanner is better for parsing, here we need it for "Enter" 
import java.util.Comparator; // for comparing (for frequency ordering as well as reversing)
import java.util.Collections; // for sorting (for frequency)

// The list can then be sorted based on the frequencies of the words.
class WordFrequency {
    // create a list of objects that contains words and frequencies
    private String word;
    private int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;

    }

    /*
     * getters and setters for Word
     */
    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /*
     * getters and setters for Frequency
     */
    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}

class CountWords {
    // storing stop words in the array list, creation
    private ArrayList<String> stopWords;
    // array list of object word frequency
    private ArrayList<WordFrequency> wordFrequencies;

    public CountWords() {
        // initialization
        stopWords = new ArrayList<>();
        wordFrequencies = new ArrayList<>();
        readStopWords();

    }

    // getter for getWordFrequencies
    public ArrayList<WordFrequency> getWordFrequencies() {
        return wordFrequencies;
    }

    // reading the stop words present in the Lab1 folder
    public void readStopWords() {
        // where the stop words are stored
        String document = "/Users/koushalsmodi/Desktop/cs245/Lab1/NLTK's list of english stopwords";
        try (BufferedReader reader = new BufferedReader(new FileReader(document))) {
            String word; // every line is has only word so read that word and remove any blank space
            // as long as we did not reach end of the file of stop words
            while ((word = reader.readLine()) != null) {
                stopWords.add(word.trim()); // add stop words
            }
        } catch (IOException e) {
            System.out.println("error reading stopwords document: " + e); // raise exception if stopwords document not
                                                                          // found
        }

    }

    // reading the the book all at once
    public void readUserBookAllAtOnce(String title) {
        try (BufferedReader reader = new BufferedReader(new FileReader(title))) {
            String line;
            ArrayList<String> BookAllAtOnce = new ArrayList<>(); // storing all lines in the BookAllAtOnce array list
            // as long as book has not ended
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s++"); // find one or more white space and then break into words
                BookAllAtOnce.add(line); // add line to the array list
                for (String word : words) {
                    word = word.toLowerCase(); // converting words to lowercase which will help to compare against those
                                               // stop words which are all lowercase
                    if (!stopWords.contains(word) && !word.isEmpty()) {
                        addFrequency(word); // add the frequency for the word only if it isn't contained in the
                                            // stopWords and is not empty, that is, has at least 1 character
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading book " + e); // else raise exception for reading the book
        }
    }

    // for the word (which is not a stop word)
    public void addFrequency(String word) {
        for (WordFrequency wordfreq : wordFrequencies) {
            // if the wordFrequencies's objects word matches the word read, increase the
            // frequency by 1
            if (wordfreq.getWord().equals(word)) {
                wordfreq.setFrequency(wordfreq.getFrequency() + 1);
                return;
            }
        }
        // if a new word, add a new word
        wordFrequencies.add(new WordFrequency(word, 1));
    }

    public void listTop10(ArrayList<WordFrequency> wordFrequencies) {
        // got idea from Professor Alark Joshi: "It is similar to sorting a list with
        // integers,
        // except your comparison has to be a comparison of frequencies rather than just
        // comparing the contents of an integer list."
        // learnt using Comparators from here:
        // https://stackoverflow.com/questions/2839137/how-to-use-comparator-in-java-to-sort
        // idea is from the above link, code is mine
        Comparator<WordFrequency> comparator = Comparator.comparingInt(WordFrequency::getFrequency).reversed();
        Collections.sort(wordFrequencies, comparator);
        // storing top 10 words
        ArrayList<WordFrequency> top10 = new ArrayList<>();
        // size of sublist
        int size = 10;
        top10.addAll(wordFrequencies.subList(0, size));
        for (WordFrequency wordFreq : top10) {
            System.out.println("Word: " + wordFreq.getWord() + ", Frequency: " + wordFreq.getFrequency());
        }

    }

}

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
        // read the book forwards
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
        // read the book backwards
        try (BufferedReader reader = new BufferedReader(new FileReader(title))) {
            ArrayList<String> backwardReading = new ArrayList<>();
            // store the book in backwardReading
            // add lines as long as end of book not reached
            String line;
            while ((line = reader.readLine()) != null) {
                backwardReading.add(line);

            }
            int start = backwardReading.size() - 1; // start from the last index
            Scanner sc = new Scanner(System.in); // for enter
            // start from the end of the book and move 20 lines up
            for (int i = start; i >= 0; i -= 20) {
                int stop = Math.max(i - 19, 0);
                // start from the end of the book and move 20 lines up, one line at a time
                for (int j = i; j >= stop; j--) {
                    System.out.println(backwardReading.get(j));
                }
                // after 20 lines, ask for enter
                System.out.println("Press Enter to continue: ");
                sc.nextLine();
            }
            sc.close();
        }
        // if the book cannot be read
        catch (IOException e) {
            System.err.println("Error reading file: " + e);
        }
    }

    // convert the partial match title to lowercase
    public void partialMatch(String title) {
        title = title.toLowerCase();
        // store all books into a book object array list
        ArrayList<Book> allBooks = library.getAllBooks();
        // boolean flag
        boolean found = false;

        // for every book in the library
        for (Book book : allBooks) {
            // get the book title, making it lowercase so that i can match it with the user
            // entered title
            String bookTitle = book.getTitle().toLowerCase();
            if (bookTitle.contains(title)) { // if the user entered partial title is present in the book title, we found
                                             // a match
                System.out.println("Match found for: " + title); // user entered partial title
                System.out.println("Match is: " + bookTitle); // official title that was converted to lower case
                purchaseBook(book.getTitle()); // allow the user to purchsae the book
                found = true;
                break;
            }
        }
        if (!found) { // if the title wasn't found in the library
            System.err.println(title + " not found");
        }

    }

    // which book and what word needs to be checked for
    public void onlySearchLines(String title, String match) {
        try (BufferedReader reader = new BufferedReader(new FileReader(title))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // // print if word match found
                if (line.contains(match)) {
                    System.out.println(line);
                }

            }
            // else raise error reading file
        } catch (IOException e) {
            System.err.println("Error reading file: " + e);
        }

    }

    // adding 1 book at a time to user's library
    public void addToUserLibrary(Book book) { // store the book into the array list that follows the book object
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
        title = title.toLowerCase();
        for (Book book : library.getAllBooks()) {
            String bookTitle = book.getTitle().toLowerCase();
            // if the title entered by user matches that of the book's title the user will
            // be able to purchase the book
            if (bookTitle.equals(title)) {
                // if found the book, add the book to the user library,
                addToUserLibrary(book);
                System.out.println("Book purchased: " + book.getTitle());
                return;
            }
        }
        // if did not find the book, return error saying title not found
        System.err.println("Title: " + title + " not found");
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
        l1.addBook(new Book("Romeo and Juliet", "William Shakespeare", "PG Shakespeare Team", "1513"));
        
        // listing all books
        l1.listAllBooks();

        // search the following book
        l1.searchBooks("Autobiography of a Yogi"); 
        System.out.println("cleared library now user library");

        UserLibrary l2 = new UserLibrary(l1); // populating the library books, helpful in the for loop for checking the
                                              // book

        // user wants to buy the following books
        l2.purchaseBook("Vikram and the Vampire");

        // // list books the user has in his own library
        l2.listUserLibrary(); 

        // purchase the book
        l2.purchaseBook("The Mahabharata of Krishna-Dwaipayana Vyasa Vana Parva, Part 1");
        String filename = "/Users/koushalsmodi/Desktop/cs245/Lab1/The Mahabharata of Krishna-Dwaipayana Vyasa.txt";
        // read the book forwards
        l2.readUserBookForward(filename);
        // list books the user has in his own library
        l2.listUserLibrary(); 

        // search lines that match "cow"
        l2.onlySearchLines("/Users/koushalsmodi/Desktop/cs245/Lab1/The Mahabharata of Krishna-Dwaipayana Vyasa.txt", "cow");
        
        // read the book backwards 
        l2.readUserBookBackward("/Users/koushalsmodi/Desktop/cs245/Lab1/Ramayana, Volume 2.txt"); // max index: 21957

        // even if partial match, buy the book
        l2.partialMatch("Yogi");

        // read the book and get the top 10 words and their respective frequencies
        CountWords cw = new CountWords();
        cw.readUserBookAllAtOnce("/Users/koushalsmodi/Desktop/cs245/Lab1/YogaSutras.txt");
        cw.listTop10(cw.getWordFrequencies());

    }

}