// Luke Laricy
// Project 5b - LibraryManager.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026

import java.io.*;
import java.util.*;

/**
 * LibraryManager manages a collection of library items (books, CDs, etc.).
 * It provides functionality to add items, retrieve items by various criteria,
 * and persist/restore the collection to/from disk.
 *
 * The class implements Iterable to allow iteration over all items in the collection
 * and Serializable to allow the collection to be saved to and loaded from disk.
 *
 * @author Luke Laricy
 * @version 1.0
 */
public class LibraryManager implements Iterable<LibraryItem>, Serializable {

    /** The HashMap collection storing all library items, keyed by catalog number. */
    private HashMap<String, LibraryItem> col;

    /**
     * Constructor to initialize an empty LibraryManager.
     * Creates a HashMap with an initial capacity of 500 and load factor of 0.6.
     */
    public LibraryManager() {
        col = new HashMap<>(500, 0.6f);
    }

    /**
     * Adds a library item to the collection using its catalog number as the key.
     * If an item with the same catalog number already exists, it will be replaced.
     *
     * @param theBook the LibraryItem to add to the collection
     */
    public void addItem(LibraryItem theBook) {
        col.put(theBook.getCatalogNum(), theBook);
    }

    /**
     * Returns a sorted ArrayList of all library items in the collection.
     * The items are sorted alphabetically by title.
     *
     * @return an ArrayList of all LibraryItems sorted by title
     */
    public ArrayList<LibraryItem> getAll() {
        ArrayList<LibraryItem> allItems = new ArrayList<>(col.values());
        Collections.sort(allItems);
        return allItems;
    }

    /**
     * Retrieves a library item from the collection by its catalog number.
     *
     * @param catalogNum the catalog number of the item to retrieve
     * @return the LibraryItem with the specified catalog number, or null if not found
     */
    public LibraryItem getByCatalogNum(String catalogNum) {
        return col.get(catalogNum);
    }

    /**
     * Returns a sorted ArrayList of all library items from the specified year.
     * The items are sorted alphabetically by title.
     *
     * @param year the year to filter by
     * @return an ArrayList of LibraryItems from the specified year, sorted by title
     */
    public ArrayList<LibraryItem> getByYear(int year) {
        ArrayList<LibraryItem> itemsByYear = new ArrayList<>();
        for (LibraryItem item : col.values()) {
            if (item.getYear() == year) {
                itemsByYear.add(item);
            }
        }
        Collections.sort(itemsByYear);
        return itemsByYear;
    }

    /**
     * Returns a sorted ArrayList of all library items that are currently checked out.
     * The items are sorted alphabetically by title.
     *
     * @return an ArrayList of all checked-out LibraryItems, sorted by title
     */
    public ArrayList<LibraryItem> getCheckedOut() {
        ArrayList<LibraryItem> checkedOutItems = new ArrayList<>();
        for (LibraryItem item : col.values()) {
            if (item.isCheckedOut()) {
                checkedOutItems.add(item);
            }
        }
        Collections.sort(checkedOutItems);
        return checkedOutItems;
    }

    /**
     * Returns the total number of items in the collection.
     *
     * @return the count of all LibraryItems in the collection
     */
    public int getCount() {
        return col.size();
    }

    /**
     * Returns an iterator over the library items in the collection.
     * This is required by the Iterable interface.
     *
     * @return an Iterator over LibraryItems in the collection
     */
    @Override
    public Iterator<LibraryItem> iterator( ) {
        return col.values( ).iterator( );
    }

    /**
     * Deserializes the library item collection from the file "library-items.ser" on disk.
     * If the load operation fails, an error message is printed to the console.
     */
    public void load() {
        try {
            FileInputStream fis = new FileInputStream("library-items.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            col = (HashMap<String, LibraryItem>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Load failed: " + e.getMessage());
        }
    }

    /**
     * Serializes the library item collection to the file "library-items.ser" on disk.
     * If the save operation fails, an error message is printed to the console.
     */
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("library-items.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(col);
            oos.close();
        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of all library items in the collection.
     * Each item is displayed on a separate line, sorted alphabetically by title.
     *
     * @return a string representation of all items in the collection
     */
    @Override
    public String toString() {
        String output = "";
        for (LibraryItem item : getAll()) {
            output += item.toString() + "\n";
        }
        return output;
    }
}
