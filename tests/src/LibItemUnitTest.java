// Luke Laricy
// Project 5b - LibItemUnitTest.java
// Due Date: February 28, 2026
// Submission Date: February 27, 2026

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LibItemUnitTest {


    // Declare instance variables for the tests
    private LibraryItem item1;
    private LibraryItem item2;
    private Book book;
    private MusicCD cd;

    // Set up method to initialize objects before each test
    @BeforeEach
    void setUp() {

        // LibraryItem objects for compareTo tests
        item1 = new LibraryItem("LI8687", "Microfiche 19240121", 1924);
        item2  = new LibraryItem("LI3325", "Microfiche 20240301", 2024);

        // Book object
        book = new Book("BK2707", "Maniac Magee", 1990,
                "Jerry Spinelli", "Little, Brown and Company");

        // MusicCD object
        cd = new MusicCD("CD2080", "The Downward Spiral", 1994,
                "Nine Inch Nails", "Trent Reznor", "Nothing Records");
    }


    // Tests for LibraryItem class
    @Test
    void testGetCatalogNum() {
        assertEquals("LI8687", item1.getCatalogNum());
    }

    @Test
    void testGetTitle() {
        assertEquals("Microfiche 19240121", item1.getTitle());
    }

    @Test
    void testGetYear() {
        assertEquals(1924, item1.getYear());
    }

    @Test
    void testIsCheckedOut() {
        assertFalse(item1.isCheckedOut());
    }

    @Test
    void testCheckOut() {
        item1.checkOut();
        assertTrue(item1.isCheckedOut());
    }

    @Test
    void testCheckIn() {
        item1.checkOut();
        item1.checkIn();
        assertFalse(item1.isCheckedOut());
    }

    @Test
    void testCompareTo() {
        // item1 title comes before item2 title alphabetically
        assertEquals(true, item1.compareTo(item2) < 0);
    }

    @Test
    void testLibraryItemToString() {
        String expected = "LI8687: Microfiche 19240121 (1924) - Available";
        assertEquals(expected, item1.toString());
    }

    // Tests for book class
    @Test
    void testGetAuthor() {
        assertEquals("Jerry Spinelli", book.getAuthor());
    }

    @Test
    void testGetPublisher() {
        assertEquals("Little, Brown and Company", book.getPublisher());
    }

    @Test
    void testBookToString() {
        String expected = "BK2707: Maniac Magee by Jerry Spinelli (1990) Little, Brown and Company - Available";
        assertEquals(expected, book.toString());
    }

    // Tests for MusicCD class
    @Test
    void testGetArtist() {
        assertEquals("Nine Inch Nails", cd.getArtist());
    }

    @Test
    void testGetComposer() {
        assertEquals("Trent Reznor", cd.getComposer());
    }

    @Test
    void testGetLabel() {
        assertEquals("Nothing Records", cd.getLabel());
    }

    @Test
    void testMusicCDToString() {
        String expected = "CD2080: The Downward Spiral by Nine Inch Nails (1994) Nothing Records, Composed by Trent Reznor - Available";
        assertEquals(expected, cd.toString());
    }

}
