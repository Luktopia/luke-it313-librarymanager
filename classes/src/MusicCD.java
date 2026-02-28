// Luke Laricy
// Project 5b - MusicCD.java
// Due Date: March 7, 2026
// Submission Date: February 27, 2026


/**
 * MusicCD is a concrete subclass of LibraryItem that represents a music CD in the library.
 * It extends LibraryItem with music-specific properties such as artist, composer, and label.
 *
 * @author Luke Laricy
 * @version 1.0
 */
public class MusicCD extends LibraryItem {

    /** The performing artist of the music CD. */
    private String artist;

    /** The composer of the music on the CD. */
    private String composer;

    /** The record label that published the CD. */
    private String label;

    /**
     * Constructor to initialize a MusicCD with catalog number, title, year, artist, composer, and label.
     *
     * @param catalogNum the unique catalog number for the CD
     * @param title the title of the CD
     * @param year the year the CD was released
     * @param artist the performing artist of the CD
     * @param composer the composer of the music on the CD
     * @param label the record label that published the CD
     */
    public MusicCD(String catalogNum, String title, int year, String artist, String composer, String label) {
        super(catalogNum, title, year);
        this.artist = artist;
        this.composer = composer;
        this.label = label;
    }

    /**
     * Gets the performing artist of this music CD.
     *
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the composer of the music on this CD.
     *
     * @return the composer
     */
    public String getComposer() {
        return composer;
    }

    /**
     * Gets the record label that published this CD.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Returns a string representation of this music CD including
     * its catalog number, title, artist, year, label, composer, and checkout status.
     *
     * @return a string representation of this music CD
     */
    @Override
    public String toString() {
        return getCatalogNum() + ": " + getTitle() + " by " + artist + " (" + getYear() + ") " + label + ", Composed by " + composer + " - " + (isCheckedOut() ? "Checked Out" : "Available");
    }
}
