package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString(String string) throws NullPointerException;

    String getNexString();

    List<String> getHistory();

    void printString() throws IllegalStateException; 
}
