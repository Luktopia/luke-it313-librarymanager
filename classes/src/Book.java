// Luke Laricy
// Project 5b - Book.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


/**
 * Book is a concrete subclass of LibraryItem that represents a book in the library.
 * It extends LibraryItem with book-specific properties such as author and publisher.
 *
 * @author Luke Laricy
 * @version 1.0
 */
public class Book extends LibraryItem {

    /** The author of the book. */
    private String author;

    /** The publisher of the book. */
    private String publisher;

    /**
     * Constructor to initialize a Book with catalog number, title, year, author, and publisher.
     *
     * @param catalogNum the unique catalog number for the book
     * @param title the title of the book
     * @param year the year the book was published
     * @param author the author of the book
     * @param publisher the publisher of the book
     */
    public Book(String catalogNum, String title, int year, String author, String publisher) {
        super(catalogNum, title, year);
        this.author = author;
        this.publisher = publisher;
    }

    /**
     * Gets the author of this book.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the publisher of this book.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns a string representation of this book including
     * its catalog number, title, author, year, publisher, and checkout status.
     *
     * @return a string representation of this book
     */
    @Override
    public String toString() {
        return getCatalogNum() + ": " + getTitle() + " by " + author + " (" + getYear() + ") " + publisher + " - " + (isCheckedOut() ? "Checked Out" : "Available");
    }
}
