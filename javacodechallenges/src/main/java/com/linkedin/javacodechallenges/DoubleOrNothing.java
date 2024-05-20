package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {
  
  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What's your name?: ");
    String name = scanner.nextLine();

    int points = 10;

    System.out.println("You have " + points + " points, " + name);
    System.out.println("Enter Y if you want to take a chance at double your points, or any other letter if you're done...");
    String answer = scanner.nextLine();

    while (answer.equalsIgnoreCase("Y") && points != 0) {

      if (new Random().nextBoolean()) {
        points *= 2;
        System.out.println("Congrats! You double your points! New balance: " + points);
        System.out.println(
            "Enter Y if you want to take a chance at double your points, or any other letter if you're done...");
        answer = scanner.nextLine();
      } else {
        System.out.println("You have lost all your points!");
        points = 0;
      }

    }

    System.out.println("Thanks for playing. Goodbye!");
    scanner.close();
  }
}