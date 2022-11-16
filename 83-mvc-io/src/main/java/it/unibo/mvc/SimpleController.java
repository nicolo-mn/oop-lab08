package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String next;
    private final List<String> history;

    /**
     * Initializes the history field as an ArrayList of String.
     */
    public SimpleController() {
        this.history = new ArrayList<>();
    }

    @Override
    public void setNextString(final String string) {
        next = Objects.requireNonNull(string, "The string can't be null!");
    }

    @Override
    public String getNexString() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void printString() {
        if (this.next == null) {
            throw new IllegalStateException("There is no string set");
        }
        this.history.add(this.next);
        System.out.println(this.next); // NOPMD: requested by the exercise to print on stdout
        this.next = null;
    }

}
