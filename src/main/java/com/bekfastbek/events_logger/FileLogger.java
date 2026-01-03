package com.bekfastbek.events_logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private static final Path COMMANDS_FILE = Paths.get("logs/user_commands.txt");
    private static final Path MESSAGES_FILE = Paths.get("logs/user_messages.txt");
    private static final Path ADVANCEMENTS_FILE = Paths.get("logs/user_advancements.txt");
    private static final Path DEATHS_FILE = Paths.get("logs/user_deaths.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static {
        try {
            Files.createDirectories(COMMANDS_FILE.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logCommand(String username, String command) {
        writeToFile(COMMANDS_FILE, String.format("[%s] [%s] /%s%n", 
            LocalDateTime.now().format(FORMATTER), username, command));
    }

    public static void logMessage(String username, String message) {
        writeToFile(MESSAGES_FILE, String.format("[%s] [%s] %s%n", 
            LocalDateTime.now().format(FORMATTER), username, message));
    }

    public static void logAdvancements(String username, String advancement) {
        writeToFile(ADVANCEMENTS_FILE, String.format("[%s] [%s] %s%n",
            LocalDateTime.now().format(FORMATTER), username, advancement));
    }

    public static void logDeaths(String username, String deathMessage) {
        writeToFile(DEATHS_FILE, String.format("[%s] [%s] %s%n",
            LocalDateTime.now().format(FORMATTER), username, deathMessage));
    }

    private static void writeToFile(Path file, String content) {
        try (FileWriter writer = new FileWriter(file.toFile(), true)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}