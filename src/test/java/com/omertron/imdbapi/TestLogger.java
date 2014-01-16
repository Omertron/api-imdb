package com.omertron.imdbapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

    private static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
    private static final String CRLF = "\n";

    private TestLogger() {
        throw new UnsupportedOperationException("Class can not be instantiated");
    }

    /**
     * Configure the logger with a simple in-memory file for the required log level
     *
     * @param level The logging level required
     * @return True if successful
     */
    public static boolean Configure(String level) {
        StringBuilder config = new StringBuilder("handlers = java.util.logging.ConsoleHandler\n");
        config.append(".level = ").append(level).append(CRLF);
        config.append("java.util.logging.ConsoleHandler.level = ").append(level).append(CRLF);
        // Only works with Java 7 or later
        config.append("java.util.logging.SimpleFormatter.format = [%1$tH:%1$tM:%1$tS %4$6s] %2$s - %5$s %6$s%n").append(CRLF);
        // Exclude logging messages
        // Note: This does not work for apache
        config.append("org.apache.http.level = SEVERE").append(CRLF);

        InputStream ins = new ByteArrayInputStream(config.toString().getBytes());
        try {
            LogManager.getLogManager().readConfiguration(ins);
            // Exclude http logging
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
            System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

        } catch (IOException ex) {
            LOG.warn("Failed to configure log manager due to an IO problem", ex);
            return Boolean.FALSE;
        } finally {
            try {
                ins.close();
            } catch (IOException ex) {
                LOG.info("Failed to close input stream", ex);
            }
        }
        LOG.debug("Logger initialized to '{}' level", level);
        return Boolean.TRUE;
    }

    /**
     * Set the logging level to "ALL"
     *
     * @return True if successful
     */
    public static boolean Configure() {
        return Configure("ALL");
    }
}
