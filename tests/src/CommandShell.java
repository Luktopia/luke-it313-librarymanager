// Luke Laricy
// Project 5b - CommandShell.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


import java.util.Scanner;

public class CommandShell {

    public static void main(String[] args) {


        // Create a Scanner for user input and a LibraryManager to manage library items
        Scanner s = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();


        // Set a random boolean to true to control the menu loop
        boolean running = true;

        while (running) {

            // Display the menu options to the user
            System.out.println("LibraryManager Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add CD");
            System.out.println("3. Show All Items");
            System.out.println("4. Get Item by Catalog Number");
            System.out.println("5. Get Items by Year");
            System.out.println("6. Show Checked Out Items");
            System.out.println("7. Show Count of Items");
            System.out.println("8. Load Items from Disk");
            System.out.println("9. Save Items to Disk");
            System.out.println("10. Quit");
            System.out.print("Enter choice (1-10): ");


            // Read the user's choice and trim any leading/trailing whitespace
            String choice = s.nextLine().trim();


            /*
            Handle the user's choice using a series of if-else statements.
            I didn't want to use a case statement because I wanted to be able to easily
            add more options in the future without having to worry about fall-through cases.
            I also wanted to be able to easily add more complex logic for each option if needed.
            */

            // If the user chooses to add a book, prompt for book details and create a new Book object
            if (choice.equals("1")) {

                System.out.print("Catalog Number: ");
                String bCat = s.nextLine();

                System.out.print("Title: ");
                String bTitle = s.nextLine();

                int bYear = readValidYear(s);

                System.out.print("Author: ");
                String bAuthor = s.nextLine();

                System.out.print("Publisher: ");
                String bPub = s.nextLine();

                Book book = new Book(bCat, bTitle, bYear, bAuthor, bPub);
                manager.addItem(book);

                System.out.println("Book added.\n");
            }


            // If the user chooses to add a CD, prompt for CD details and create a new MusicCD object
            else if (choice.equals("2")) {

                System.out.print("Catalog Number: ");
                String cCat = s.nextLine();

                System.out.print("Title: ");
                String cTitle = s.nextLine();

                int cYear = readValidYear(s);

                System.out.print("Artist: ");
                String cArtist = s.nextLine();

                System.out.print("Composer: ");
                String cComposer = s.nextLine();

                System.out.print("Label: ");
                String cLabel = s.nextLine();

                MusicCD cd = new MusicCD(cCat, cTitle, cYear, cArtist, cComposer, cLabel);
                manager.addItem(cd);

                System.out.println("CD added.\n");
            }


            // If the user chooses to show all items, retrieve and display all items from the LibraryManager
            else if (choice.equals("3")) {
                for (LibraryItem item : manager.getAll()) {
                    System.out.println(item);
                }
                System.out.println();
            }

            // If the user chooses to get an item by catalog number, prompt for the catalog number and display the corresponding item
            else if (choice.equals("4")) {
                System.out.print("Enter catalog number: ");
                String cat = s.nextLine();
                System.out.println(manager.getByCatalogNum(cat));
                System.out.println();
            }

            // If the user chooses to get items by year, prompt for the year and display all items from that year
            else if (choice.equals("5")) {
                int year = readValidYear(s);
                for (LibraryItem item : manager.getByYear(year)) {
                    System.out.println(item);
                }
                System.out.println();
            }


            // If the user chooses to show checked out items, retrieve and display all checked out items from the LibraryManager
            else if (choice.equals("6")) {
                for (LibraryItem item : manager.getCheckedOut()) {
                    System.out.println(item);
                }
                System.out.println();
            }


            // If the user chooses to show the count of items, retrieve and display the total count of items from the LibraryManager
            else if (choice.equals("7")) {
                System.out.println("Total items: " + manager.getCount());
                System.out.println();
            }


            // If the user chooses to load items from disk, call the load method of the LibraryManager and display a confirmation message
            else if (choice.equals("8")) {
                manager.load();
                System.out.println("Loaded.\n");
            }


            // If the user chooses to save items to disk, call the save method of the LibraryManager and display a confirmation message
            else if (choice.equals("9")) {
                manager.save();
                System.out.println("Saved.\n");
            }


            // If the user chooses to quit, set the running variable to false and exit the loop and display a goodbye message
            else if (choice.equals("10")) {
                running = false;
                System.out.println("Exiting Command Shell.");
            }

            // If the user enters an invalid choice, display an error message and prompt again
            else {
                System.out.println("Invalid choice.\n");
            }
        }

        s.close();
    }


    // Helper method to read a valid integer year from the user, prompting until a valid input is received
    // Otherwise the program just crashes and that's no fun for anyone
    private static int readValidYear(Scanner s) {
        while (true) {
            System.out.print("Year: ");
            String input = s.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid integer.\n");
            }
        }
    }
}