// Luke Laricy
// Project 5b - Test2.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class Test2 {

    // Instance variables for the test class
    private LibraryManager manager;
    private Book book;
    private MusicCD cd;
    private MusicCD cd2;
    private LibraryItem mf;

    // Set up method to initialize the LibraryManager and sample items before each test
    @BeforeEach
    void setUp() {
        manager = new LibraryManager();

        book = new Book("BK2707", "Maniac Magee", 1990,
                "Jerry Spinelli", "Little, Brown and Company");

        cd = new MusicCD("CD2080", "The Downward Spiral", 1994,
                "Nine Inch Nails", "Trent Reznor", "Nothing Records");

        cd2 = new MusicCD("CD1990", "Mama Said Knock You Out", 1990,
                "LL Cool J", "Marley Marl", "Def Jam Recordings");

        mf = new LibraryItem("LI8687", "Microfiche 19240121", 1924);

        manager.addItem(book);
        manager.addItem(cd);
        manager.addItem(cd2);
        manager.addItem(mf);
    }



    // Test method to verify that items are added correctly and the count is accurate
    @Test
    void testAddItemAndGetCount() {
        assertEquals(4, manager.getCount());
    }



    // Test method to verify that getAll returns items in sorted order by title
    @Test
    void testGetAllSize() {
        assertEquals(4, manager.getAll().size());
    }

    @Test
    void testGetAllFirstItem() {
        assertEquals("Mama Said Knock You Out", manager.getAll().get(0).getTitle());
    }

    @Test
    void testGetAllSecondItem() {
        assertEquals("Maniac Magee", manager.getAll().get(1).getTitle());
    }

    @Test
    void testGetAllThirdItem() {
        assertEquals("Microfiche 19240121", manager.getAll().get(2).getTitle());
    }

    @Test
    void testGetAllFourthItem() {
        assertEquals("The Downward Spiral", manager.getAll().get(3).getTitle());
    }




    // Test method to verify that getByCatalogNum returns the correct item or null if not found
    @Test
    void testGetByCatalogNumFound() {
        assertEquals(cd, manager.getByCatalogNum("CD2080"));
    }

    @Test
    void testGetByCatalogNumNotFound() {
        assertNull(manager.getByCatalogNum("BAD0000"));
    }


    // Test method to verify that getByYear returns items from the specified year and is sorted by title
    @Test
    void testGetByYearSize() {
        assertEquals(2, manager.getByYear(1990).size());
    }

    @Test
    void testGetByYearFirstItemSorted() {
        assertEquals("Mama Said Knock You Out", manager.getByYear(1990).get(0).getTitle());
    }

    @Test
    void testGetByYearSecondItemSorted() {
        assertEquals("Maniac Magee", manager.getByYear(1990).get(1).getTitle());
    }

    @Test
    void testGetByYearEmpty() {
        assertEquals(0, manager.getByYear(1800).size());
    }




    // Test method to verify that getCheckedOut returns only checked-out items
    @Test
    void testGetCheckedOutInitiallyEmpty() {
        assertEquals(0, manager.getCheckedOut().size());
    }

    @Test
    void testGetCheckedOutAfterCheckout() {
        book.checkOut();
        assertEquals(1, manager.getCheckedOut().size());
    }



    // Test iterator to verify that it iterates through all items
    @Test
    void testIteratorCount() {
        int count = 0;
        for (LibraryItem item : manager) {
            count++;
        }
        assertEquals(4, count);
    }



    // Test method to verify that save and load work correctly
    @Test
    void testSaveLoadCount() {
        manager.save();
        LibraryManager manager2 = new LibraryManager();
        manager2.load();
        assertEquals(4, manager2.getCount());
    }

    @Test
    void testSaveLoadHasBook() {
        manager.save();
        LibraryManager manager2 = new LibraryManager();
        manager2.load();
        assertNotNull(manager2.getByCatalogNum("BK2707"));
    }

    @Test
    void testSaveLoadHasCD() {
        manager.save();
        LibraryManager manager2 = new LibraryManager();
        manager2.load();
        assertNotNull(manager2.getByCatalogNum("CD2080"));
    }

    @Test
    void testSaveLoadHasMicrofiche() {
        manager.save();
        LibraryManager manager2 = new LibraryManager();
        manager2.load();
        assertNotNull(manager2.getByCatalogNum("LI8687"));
    }


    // Test toString
    @Test
    void testToStringContainsBook() {
        assertTrue(manager.toString().contains("Maniac Magee"));
    }

    @Test
    void testToStringContainsCD() {
        assertTrue(manager.toString().contains("The Downward Spiral"));
    }

    @Test
    void testToStringContainsMicrofiche() {
        assertTrue(manager.toString().contains("Microfiche 19240121"));
    }

    @Test
    void testToStringContainsCD2() {
        assertTrue(manager.toString().contains("Mama Said Knock You Out"));
    }


}