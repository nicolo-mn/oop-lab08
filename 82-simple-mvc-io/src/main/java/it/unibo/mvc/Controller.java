package it.unibo.mvc;

import java.io.File;

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

    void saveToFile(String line) {
    }

}
