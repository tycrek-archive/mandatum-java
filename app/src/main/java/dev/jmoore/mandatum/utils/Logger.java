package dev.jmoore.mandatum.utils;

import java.io.PrintStream;

public class Logger {
    private enum LogType {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public static void debug(String message) {
        Logger.debug(message, new Object[0]);
    }

    public static void debug(String message, Object... args) {
        log(LogType.DEBUG, message, args);
    }

    public static void info(String message) {
        Logger.info(message, new Object[0]);
    }

    public static void info(String message, Object... args) {
        log(LogType.INFO, message, args);
    }

    public static void warn(String message) {
        Logger.warn(message, new Object[0]);
    }

    public static void warn(String message, Object... args) {
        log(LogType.WARN, message, args);
    }

    public static void error(String message) {
        Logger.error(message, new Object[0]);
    }

    public static void error(String message, Object... args) {
        log(LogType.ERROR, message, args);
    }

    private static void log(LogType logType, String message, Object... args) {
        message = String.format("[" + logType + "] " + message.trim(), args).trim();
        PrintStream stream = (logType == LogType.WARN || logType == LogType.ERROR ? System.err : System.out);
        stream.println(message);
    }
}
