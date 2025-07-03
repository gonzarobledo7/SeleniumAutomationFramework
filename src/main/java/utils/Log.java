package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);
    public static void info(String message){
        logger.info(message);
        //Display General Information
    }

    public static void warm(String message){
        logger.warn(message);
        //Display Warnings
    }

    public static void error(String message){
        logger.error(message);
        //Display Errors
    }

    public static void debug(String message){
        logger.debug(message);
        //Debugging details
    }

}
