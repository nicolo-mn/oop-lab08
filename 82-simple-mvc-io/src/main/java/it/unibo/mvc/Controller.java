package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    static private final String DEFAULT_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt";
    
    File currentFile;

    public Controller() {
        currentFile = new File(DEFAULT_FILE);
    }

    void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    File getCurrentFile() {
        return this.currentFile;
    }

    String getCurrentFilePath() {
        return this.currentFile.getPath();
    }

    void saveToFile(String line){
        try (PrintStream ps = new PrintStream(this.currentFile, StandardCharsets.UTF_8)) {
            ps.print(line);
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }

}
