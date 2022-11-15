package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String next;
    private List<String> history;

    public SimpleController() {
        this.history = new ArrayList<>();
    }

    @Override
    public void setNextString(final String string) {
        if (string.equals(null)) {
            throw new NullPointerException();
        }
        next = string;
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
    public void printString() throws IllegalStateException {
        this.history.add(this.next);
        System.out.println(this.next);
        this.next = null;
    }

}
