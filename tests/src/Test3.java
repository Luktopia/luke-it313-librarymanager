// Luke Laricy
// Project 5b - Test3.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026



public class Test3 {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Testing LibraryManager class:");
        System.out.println();

        // Create LibraryManager
        LibraryManager manager = new LibraryManager();

        // Create sample items
        Book book = new Book("BK2707", "Maniac Magee", 1990,
                "Jerry Spinelli", "Little, Brown and Company");

        MusicCD cd = new MusicCD("CD2080", "The Downward Spiral", 1994,
                "Nine Inch Nails", "Trent Reznor", "Nothing Records");

        MusicCD cd2 = new MusicCD("CD1990", "Mama Said Knock You Out", 1990,
                "LL Cool J", "Marley Marl", "Def Jam Recordings");

        LibraryItem mf = new LibraryItem("LI8687", "Microfiche 19240121", 1924);



        // Test addItem method
        manager.addItem(book);
        manager.addItem(cd);
        manager.addItem(cd2);
        manager.addItem(mf);

        // Test getAll method
        System.out.println("All items in the library:");
        for (LibraryItem item : manager.getAll()) {
            System.out.println(item);
        }

        // Test getByCatalogNum method
        System.out.println();
        System.out.println("Get item by catalog number 'CD2080':");
        System.out.println(manager.getByCatalogNum("CD2080"));

        // Test getByYear method
        System.out.println();
        System.out.println("Get and sort items by year 1990:");
        for (LibraryItem item : manager.getByYear(1990)) {
            System.out.println(item);
        }

        // Test getCheckedOut method
        System.out.println();
        System.out.println("Checking out Maniac Magee...");
        book.checkOut(); // Check out the book to test this method
        System.out.println("Get checked out items:");
        for (LibraryItem item : manager.getCheckedOut()) {
            System.out.println(item);
        }
        book.checkIn();

        // Test getCount method
        System.out.println();
        System.out.println("Total count of items in the library: " + manager.getCount());

        // Test iterator
        System.out.println();
        System.out.println("Iterating through items in the library:");
        for (LibraryItem item : manager) {
            System.out.println(item);
        }

        // Test Save method
        System.out.println();
        System.out.println("Saving library items to disk...");
        manager.save();

        // Test Load method
        System.out.println();
        System.out.println("Loading collection into a new LibraryManager...");
        LibraryManager manager2 = new LibraryManager();
        manager2.load();

        System.out.println("\nLoaded items:");
        System.out.println(manager2);

        System.out.println("Testing complete.");
        System.out.println();

    }

}
