package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class App {
    public static final String REDACTED_FILE = "redacted-sample.txt";
    public static final String REDACTED = "REDACTED";

    public static void redactTextFile(String fileName,
            String[] wordsToredactArray) {
        try {
            File file = new File(fileName);

            if (!fileName.contains(".txt")) {
                System.out.println("This is not a text file.");
                return;
            }

            if (file.canRead()) {
                FileReader fileReader = new FileReader(file);
                FileWriter fileWriter = new FileWriter(REDACTED_FILE);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                List<String> wordsToRedactList = Arrays.asList(wordsToredactArray);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    Iterator<String> iterator = wordsToRedactList.iterator();
                    while (iterator.hasNext()) {
                        line = StringUtils.replaceIgnoreCase(line, iterator.next(), REDACTED);
                    }

                    try {
                        bufferedWriter.write(line + "\n");
                    } catch (IOException e) {
                        System.out.println("Unable to write word to file.");
                        e.printStackTrace();
                    }
                }
                bufferedReader.close();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Redacted file creation has failed.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
