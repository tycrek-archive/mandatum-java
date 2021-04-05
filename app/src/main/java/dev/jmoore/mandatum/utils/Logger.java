package dev.jmoore.mandatum.utils;

public class Logger {
    private static final String DEBUG = "[DEBUG] ";
    private static final String INFO = "[INFO] ";
    private static final String WARN = "[WARN] ";
    private static final String ERROR = "[ERROR] ";

    public static void debug(String message) {
        Logger.debug(message, new Object[0]);
    }

    public static void debug(String message, Object... args) {
        log(DEBUG, message, args);
    }

    public static void info(String message) {
        Logger.info(message, new Object[0]);
    }

    public static void info(String message, Object... args) {
        log(INFO, message, args);
    }

    public static void warn(String message) {
        Logger.warn(message, new Object[0]);
    }

    public static void warn(String message, Object... args) {
        log(WARN, message, args);
    }

    public static void error(String message) {
        Logger.error(message, new Object[0]);
    }

    public static void error(String message, Object... args) {
        log(ERROR, message, args);
    }

    private static void log(String logType, String message, Object... args) {
        System.out.println(String.format(logType + message.trim(), args).trim());
    }
}
