// Luke Laricy
// Project 5b - LibItemTest.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


public class LibItemTest {
    public static void main(String[] args) {




        // Test the LibraryItem class -------------------------------------------------------------------
        System.out.println();
        System.out.println();
        System.out.println("Testing LibraryItem class:");
        LibraryItem item1 = new LibraryItem("LI8819", "Microfiche 19530305", 1953);
        LibraryItem item2 = new LibraryItem("LI3434", "Microfiche 20041208", 2004);

        System.out.println();

        // Test getters
        System.out.println("Catalog Number: " + item1.getCatalogNum());
        System.out.println("Title: " + item1.getTitle());
        System.out.println("Year: " + item1.getYear());
        System.out.println("Checked Out: " + item1.isCheckedOut());

        System.out.println();

        // Test checkOut and checkIn methods
        item1.checkOut();
        System.out.println("Checked Out after checking out: " + item1.isCheckedOut());
        item1.checkIn();
        System.out.println("Checked Out after checking in: " + item1.isCheckedOut());

        System.out.println();

        // Test compareTo method
        int comparison = item1.compareTo(item2);
        if (comparison < 0) {
            System.out.println("\"" + item1 + "\" comes before \"" + item2 + "\"");
        } else if (comparison > 0) {
            System.out.println("\"" + item2 + "\" comes before \"" + item1 + "\"");
        } else {
            System.out.println("\"" + item1 + "\" is the same as \"" + item2 + "\"");
        }

        System.out.println();

        // Test toString method
        System.out.println(item1);

        System.out.println();
        System.out.println();

        // Test the Book class -------------------------------------------------------------------
        System.out.println("Testing Book class:");
        Book book = new Book ("BK7235", "Brave New World", 1932, "Aldous Huxley", "Chatto & Windus");

        // Test getters
        System.out.println();
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println();

        // Test toString method
        System.out.println(book);

        System.out.println();
        System.out.println();

        //Test the MusicCD class -------------------------------------------------------------------
        System.out.println("Testing MusicCD class:");
        MusicCD cd = new MusicCD("CD9923", "Thriller", 1982, "Michael Jackson", "Quincy Jones", "Epic Records");

        // Test getters
        System.out.println();
        System.out.println("Artist: " + cd.getArtist());
        System.out.println("Composer: " + cd.getComposer());
        System.out.println("Label: " + cd.getLabel());
        System.out.println();

        // Test toString method
        System.out.println(cd);

    }
}

