package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConfigFileReader {

    static {
        final String PATH = System.getProperty("user.dir") + "/src/main/resources/config.yml";
        final int MIN_LINE = 0;
        final int MAX_LINE = 1;
        final int ATTEMPTS_LINE = 2;
        final int TOTALLINES = 3;

        try (BufferedReader r = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(PATH)
            )
        )) {
            for (int i = 0; i < TOTALLINES; i++) {
                StringTokenizer tok = new StringTokenizer(r.readLine(), ": ");
                tok.nextToken();
                int value = Integer.parseInt(tok.nextToken());
                switch (i) {
                    case MIN_LINE:
                        MIN = value;
                        break;
                    case MAX_LINE:
                        MAX = value;
                        break;
                    case ATTEMPTS_LINE:
                        ATTEMPTS = value;
                        break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();

        }
    }

    private static int MIN;
    private static int MAX;
    private static int ATTEMPTS;

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
