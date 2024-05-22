package com.linkedin.javacodechallenges;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.io.PrintStream;

public class App {
    public static void main(String[] args) {
        Team team1 = new Team("Sally", "Roger");
        Team team2 = new Team("Eric", "Rebecca");
        Team team3 = new Team("Tony", "Shannon");

        // List<Team> teams = List.of(team1, team2, team3);
        // int numberOfRounds = 4;

        // TeamUtils.generateTeamsScores(teams, numberOfRounds);

        // TeamUtils.revealResults(teams);

        List<Team> teams = List.of(team1, team2, team3);
        team1.getScores().addAll(List.of(3, 4, 2, 5));
        team2.getScores().addAll(List.of(1, 4, 2, 3));
        team3.getScores().addAll(List.of(5, 0, 3, 2));

        PrintStream originalStream = System.out;
        ByteArrayOutputStream printOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printOut));
        TeamUtils.revealResults(teams);
        String myResponse = printOut.toString();
        System.setOut(originalStream);

        String testResponse = "Now for the results, the WINNER is...\n" +
                "With 14 points, it's team Sally and Roger!\n" +
                "\n" +
                "Then we have... \n" +
                "It's a TIE!\n" +
                "With 10 points, it's team Eric and Rebecca!\n" +
                "With 10 points, it's team Tony and Shannon!\n" +
                "\n";

        if (testResponse.equals(myResponse)) {
            System.out.println("The same");
        } else {
            System.out.println("Test is crazy");
        }
    }
}
