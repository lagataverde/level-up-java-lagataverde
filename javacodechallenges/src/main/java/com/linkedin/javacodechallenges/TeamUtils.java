package com.linkedin.javacodechallenges;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    if (teams.isEmpty() || teams.stream().allMatch(team -> team.getScores().isEmpty())) {
      System.out.println("The game hasn't started yet.");
    } else {
      Map<Integer, List<Team>> scoresToTeams = teams.stream()
          .sorted(Comparator.comparing(Team::sumTotalScore).reversed())
          .collect(Collectors.groupingBy(Team::sumTotalScore, LinkedHashMap::new, Collectors.toList()));

      announceWinnersAndResult(scoresToTeams);
    }
  }

  public static void announceWinnersAndResult(Map<Integer, List<Team>> scoresToTeams) {
    System.out.println("Now for the results, the WINNER is...");

    Iterator<Entry<Integer, List<Team>>> iterator = scoresToTeams.entrySet().iterator();

    while (iterator.hasNext()) {
      List<Team> teams = iterator.next().getValue();

      if (teams.size() > 1) {
        System.out.println("It's a TIE!");
      }

      teams.forEach(Team::announceScore);

      if (iterator.hasNext()) {
        System.out.println("\nThen we have... ");
      } else {
        System.out.println();
      }
    }
  }
}