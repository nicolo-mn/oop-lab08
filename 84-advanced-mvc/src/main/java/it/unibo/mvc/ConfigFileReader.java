package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConfigFileReader {

    static {
        
        try (BufferedReader r = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(null, StandardCharsets.UTF_8)
            )
        )) {

        }
    }

    private static final int MIN;
    private static final int MAX;
    private static final int ATTEMPTS;

    static public int getMinimumNumber() {
        return MIN;
    }

    static public int getMaximumNumber() {
        return MAX;
    }

    static public int getAttemptsNumber() {
        return ATTEMPTS;
    }
}
