package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_FILE = System.getProperty("user.home") 
    + System.getProperty("file.separator") + "output.txt";

    private File currentFile;

    /**
     * Default constructor. Initializes currentFile to the default file.
     * 
     */
    public Controller() {
        currentFile = new File(DEFAULT_FILE);
    }

    /**
     * Sets the current file.
     * 
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Gets the current file.
     * 
     * @return currentFile
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Gets the current file path.
     * 
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return this.currentFile.getPath();
    }

    /**
     * Saves a string to the current file.
     * 
     * @param line
     */
    public void saveToFile(final String line) {
        try (PrintStream ps = new PrintStream(this.currentFile, StandardCharsets.UTF_8)) {
            ps.print(line);
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }

}
