package pl.amberteam.antycaptcha.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    public static Logger logger = LogManager.getLogger(Log.class);

    public static synchronized void logInfo(String message) {
        logger.info(message);
    }
}