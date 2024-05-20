package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {

        List<String> incompleteStudents = new ArrayList<String>();
        List<String> namesFromAttendees = attendeesMapping.values()
                .stream()
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());

        students.forEach(student -> {
            if (getNumberOfEventsAttended(student, namesFromAttendees) < 2) {
                incompleteStudents.add(student);
            }
        });

        return incompleteStudents;
    }

    public static int getNumberOfEventsAttended(String student, List<String> attendees) {
        if (!attendees.contains(student)) {
            return 0;
        }
        return Collections.frequency(attendees, student);
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
