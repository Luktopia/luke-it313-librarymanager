// Luke Laricy
// Project 5b - LibraryItem.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


import java.io.Serializable;

/**
 * LibraryItem is an abstract base class representing a generic item in the library.
 * It implements Comparable to allow sorting by title and Serializable for persistence.
 *
 * @author Luke Laricy
 * @version 1.0
 */
public class LibraryItem implements Comparable<LibraryItem>, Serializable {

    /** Serial version ID for serialization. */
    private static final long serialVersionUID = 1L;

    /** The catalog number of the library item. */
    private String catalogNum;

    /** The title of the library item. */
    private String title;

    /** The year the item was created or published. */
    private int year;

    /** Flag indicating whether the item is checked out. */
    private boolean checkedOut;

    /**
     * Constructor to initialize a LibraryItem with catalog number, title, and year.
     *
     * @param catalogNum the unique catalog number for the item
     * @param title the title of the item
     * @param year the year the item was created or published
     */
    public LibraryItem(String catalogNum, String title, int year) {
        this.catalogNum = catalogNum;
        this.title = title;
        this.year = year;
        this.checkedOut = false;
    }

    /**
     * Gets the catalog number of this library item.
     *
     * @return the catalog number
     */
    public String getCatalogNum() {
        return catalogNum;
    }

    /**
     * Gets the title of this library item.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the year this library item was created or published.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Checks if the library item is currently checked out.
     *
     * @return true if the item is checked out; false otherwise
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Checks this library item out by marking it as checked out.
     */
    public void checkOut() {
        checkedOut = true;
    }

    /**
     * Checks this library item back in by marking it as available.
     */
    public void checkIn() {
        checkedOut = false;
    }


    /**
     * Compares this library item to another based on title.
     * Used for sorting library items alphabetically by title.
     *
     * @param other the other LibraryItem to compare to
     * @return a negative integer, zero, or a positive integer as this title is less than, equal to, or greater than the other title
     */
    @Override
    public int compareTo(LibraryItem other) {
        return this.title.compareTo(other.title);
    }

    /**
     * Returns a string representation of this library item including
     * its catalog number, title, year, and checkout status.
     *
     * @return a string representation of this library item
     */
    @Override
    public String toString() {
        return catalogNum + ": " + title + " (" + year + ") - " + (checkedOut ? "Checked Out" : "Available");
    }
}
