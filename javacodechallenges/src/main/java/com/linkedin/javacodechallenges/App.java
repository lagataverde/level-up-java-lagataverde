package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static final double CCF = 748;
    public static final double MINIMUM_CHARGE = 18.84;
    public static final double MINIMUM_GALLONS = 1496;
    public static final double CCF_COST = 3.90;

    public static double calculateWaterBill(double gallonsUsage) {
        
        if (gallonsUsage <= MINIMUM_GALLONS) {
            return MINIMUM_CHARGE;
        }

        double additionalCffsUsed = Math.ceil((gallonsUsage - MINIMUM_GALLONS)/CCF); 
        double additionalCost = additionalCffsUsed * CCF_COST;

        return MINIMUM_CHARGE + additionalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
