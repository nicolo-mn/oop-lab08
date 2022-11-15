package it.unibo.mvc;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {
    private static final int STANDARD_MIN = 0;
    private static final int STANDARD_MAX = 100;
    private static final int STANDARD_ATTEMPTS = 10;

    private final DrawNumber model;
    private final List<DrawNumberView> views;

    /**
     * @param views
     *            the views to attach
     */
    public DrawNumberApp(final DrawNumberView... views) {
        /*
         * Side-effect proof
         */
        this.views = Arrays.asList(Arrays.copyOf(views, views.length));
        for (final DrawNumberView view: views) {
            view.setObserver(this);
            view.start();
        }
        
        if (ConfigFileReader.getMinimumNumber() <= ConfigFileReader.getMaximumNumber()
            && ConfigFileReader.getAttemptsNumber() > 0) {
                this.model = new DrawNumberImpl(ConfigFileReader.getMinimumNumber(),
                ConfigFileReader.getMaximumNumber(),
                ConfigFileReader.getAttemptsNumber());
        } else {
            this.model = new DrawNumberImpl(STANDARD_MIN, STANDARD_MAX, STANDARD_ATTEMPTS);
        }
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view: views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view: views) {
                view.numberIncorrect();
            }
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        /*
         * A bit harsh. A good application should configure the graphics to exit by
         * natural termination when closing is hit. To do things more cleanly, attention
         * should be paid to alive threads, as the application would continue to persist
         * until the last thread terminates.
         */
        System.exit(0);
    }

    /**
     * @param args
     *            ignored
     * @throws FileNotFoundException 
     */
    public static void main(final String... args) throws FileNotFoundException {
        new DrawNumberApp(
            new DrawNumberViewImpl(), 
            new DrawNumberViewImpl(), 
            new PrintStreamView(System.out),
            new PrintStreamView("log.txt"));
    }

}
