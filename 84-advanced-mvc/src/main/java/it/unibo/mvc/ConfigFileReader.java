package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads a configuration file and builds a Configuration object from it.
 */
public class ConfigFileReader {

    private final Configuration conf;

    /**
     * Initializes a new configuration from a file.
     * @param configFile
     */
    ConfigFileReader(final String configFile) {

        final Configuration.Builder buildConf = new Configuration.Builder();

        try (var contents = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(configFile)))) {
            for (var configLine = contents.readLine(); configLine != null; configLine = contents.readLine()) {
                final String[] lineElements = configLine.split(":");
                if (lineElements.length == 2) {
                    final int value = Integer.parseInt(lineElements[1].trim());
                    if (lineElements[0].contains("max")) {
                        buildConf.setMax(value);
                    } else if (lineElements[0].contains("min")) {
                        buildConf.setMin(value);
                    } else if (lineElements[0].contains("attempts")) {
                        buildConf.setAttempts(value);
                    }
                } else {
                    throw new IllegalArgumentException("I cannot understand \"" + configLine + '"');
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); //NOPMD: allowed as it is just exercise
        }
        conf = buildConf.build();
    }

    /**
     * Returns the configuration built by the constructor if it's consistent or a
     * standard one otherwise.
     * @return a Configuration
     */
    public Configuration getConfiguration() {
        return conf.isConsistent() ? conf : new Configuration.Builder().build();
    }
}
