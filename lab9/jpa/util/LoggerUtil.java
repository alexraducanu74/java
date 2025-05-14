package org.example.jpa.util;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0) {
            try {
                Handler fileHandler = new FileHandler("application.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                fileHandler.setLevel(Level.ALL);
                logger.addHandler(fileHandler);

                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler.setLevel(Level.ALL);
                logger.addHandler(consoleHandler);

                logger.setLevel(Level.ALL);
            } catch (IOException e) {
                System.out.println("logger setup failed: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return logger;
    }
}
