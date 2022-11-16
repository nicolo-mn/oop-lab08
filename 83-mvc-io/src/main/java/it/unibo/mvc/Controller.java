package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Sets next string to be printed.
     * @param string
     */
    void setNextString(String string);

    /**
     * Gets next string to be printed.
     * @return next string to be printed
     */
    String getNexString();

    /**
     * Gets the history of the printed strings.
     * @return a list containing the printed strings
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     */
    void printString(); 
}
