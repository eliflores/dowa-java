package com.uabc.dowa.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {
    private static final String CHAR_SET_NAME = "UTF-8";
    private static final String FILE_TO_WRITE_NAME = "file_to_write.txt";
    private static final String FILE_TO_READ = "chewie.txt";

    public static int countNumberOfOccurrencesInFile(char character) {
        int count = 0;
        try (InputStream in = FileUtils.class.getResourceAsStream(FILE_TO_READ);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (character == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return count;
    }

    //Method not being used yet.
    @SuppressWarnings("UnusedDeclaration")
    private static void writeToFile(String message) {
        URL messagesFile = FileUtils.class.getResource(FILE_TO_WRITE_NAME);
        try (FileOutputStream out = new FileOutputStream(messagesFile.getPath(), true);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, CHAR_SET_NAME))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static List<String> getLinesFromFile(String fileToRead) {
        List<String> messages = new ArrayList<>();
        try (InputStream in = FileUtils.class.getResourceAsStream(fileToRead);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.add(line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return messages;
    }

    public static List<String> getLinesInReverseOrder() {
        List<String> linesFromFile = getLinesFromFile(FILE_TO_READ);
        Collections.reverse(linesFromFile);
        return linesFromFile;
    }
}
