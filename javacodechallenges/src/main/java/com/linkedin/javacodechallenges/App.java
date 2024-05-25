package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class App {

    private static List<TicketHolder> ticketHolders;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Théâtre des Vampires!\n\n" + //
                "Please enter the file with the ticket holders for tonight...");

        loadTicketHolders(scanner.nextLine());

        if (ticketHolders != null) {
            System.out.println("\nWhat name is the ticket under?");
            String name = scanner.nextLine();
            Integer ticketQuantity = retrieveTicketHolder(name);

            if (ticketQuantity == 0) {
                System.out.println("\nSorry! There are no tickets under that name.");
            } else {
                System.out.println("\nWhat's your party size?");
                Integer partySize = Integer.valueOf(scanner.nextLine());

                if (ticketQuantity >= partySize) {
                    System.out.println("\nWe have fang you. Please come in!");
                } else {
                    System.out.println("\nYou only have " + ticketQuantity.toString() + " tickets available." +
                            " Select your victims *cough* *cough* guests.");
                }
            }
        }
    }

    public static void loadTicketHolders(String path) {
        File CSVfile = new File(path);
        FileReader CSVfileReader;
        try {
            CSVfileReader = new FileReader(CSVfile);
            CSVParser csvParser = new CSVParser(
                    CSVfileReader, CSVFormat.DEFAULT
                            .withHeader("Name:", "Quantity:")
                            .withIgnoreHeaderCase()
                            .withSkipHeaderRecord()
                            .withTrim());
            ticketHolders = csvParser.getRecords().stream()
                    .map(r -> new TicketHolder(r))
                    .collect(Collectors.toList());
            csvParser.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (IOException e) {
            System.out.println("Unable to parse file.");
        }
    }

    public static Integer retrieveTicketHolder(String name) {
        for (TicketHolder ticketHolder : ticketHolders) {
            if (ticketHolder.getName().equalsIgnoreCase(name))
                return ticketHolder.getTicketQuantity();
        }
        return 0;
    }
}