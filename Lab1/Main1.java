class Book {
    
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;

    }

    public String getTitle() {
        return this.title;

    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;

    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;

    }

    public String toString(){
        return "Title: " + title + "\n" + "Author: " + author + "\n" + "Publisher: " + publisher;
    }

}

public class Main1 {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "James Bond", "New York Times");
        // book1.author = "James Bond";
        // book1.title = "Harry Potter and the Chambers";
        // book1.publisher = "New York Times";
        // book1.getAuthor();
        // book1.getTitle();
        // book1.getPublisher();
        System.out.println(book1);

    }
}
