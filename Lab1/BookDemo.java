package Lab1;
/*
 * BookDemo.java creates a Book class 
 * with the following methods: 
 * getTitle(), getAuthor(), getPublisher(), getEbookNo(), their respective setters,
 * and toString()
 */


// compile: javac Lab1/BookDemo.java 
// run: java -cp . Lab1.BookDemo
class Book {
    // attributes / properties of the book

    private String title;
    private String author;
    private String publisher;
    private String EbookNo;

    // Book object takes in title of the book, author name, publisher name, and EbookNo
    public Book(String title, String author, String publisher, String EbookNo) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.EbookNo = EbookNo;
    }

    /*
     * getters and setters for Title of the book
     */

    public String getTitle() {
        return this.title;

    }

    public void setTitle(String title) {
        this.title = title;

    }

    /*
     * getters and setters for Author name
     */

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    /*
     * getters and setters for Publisher name
     */

    public String getPublisher() {
        return this.publisher;

    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;

    }

    /*
     * getters and setters for EbookNo
     */

    public String getEbookNo() {
        return this.EbookNo;
    }

    public void setEbookNo(String EbookNo) {
        this.EbookNo = EbookNo;

    }

    // toString() method that returns the title, author name, publisher, and EbookNo
    public String toString() {
        return "Title: " + title + "\n" + "Author: " + author + "\n" + "Publisher: " + publisher + "\n" + "EbookNo: "
                + EbookNo;
    }

}

public class BookDemo {
    public static void main(String[] args) {
        Book book1 = new Book("The Mahabharata of Krishna-Dwaipayana Vyasa Vana Parva, Part 1", "Vyasa", "John B. Hare",
                "11894");
        System.out.println(book1.getTitle());
        System.out.println(book1);

    }
}

/*
 * the following are print statements for checking and debugging code
 * // System.out.println();
 * // Book book2 = new
 * Book("The Ramayana, Volume 2. Aranya, Kishkindha, and Sundara Kandam",
 * "Valmiki", "Dutt, Manmatha Nath", "57826");
 * // System.out.println(book2);
 * // System.out.println();
 * // Book book3 = new Book("Vikram and the Vampire",
 * "Burton, Richard Francis, Sir", "David Widger", "2400");
 * // System.out.println(book3);
 * // System.out.println();
 * // Book book4 = new
 * Book("The Yoga Sutras of Patanjali: The Book of the Spiritual Man",
 * "Patanjali", "J. C. Byers", "2526");
 * // System.out.println(book4);
 * // System.out.println();
 */
