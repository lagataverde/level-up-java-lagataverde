package com.linkedin.javacodechallenges;

public class Person {

  private String name;

  private String lastName;

  private int age;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can't be null or empty");
    }
  }

  public String getLastname() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    if (lastName == null || lastName.isEmpty()) {
      throw new IllegalArgumentException("Last name can't be null or empty");
    }

    this.lastName = lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age must be a positive integer");
    }

    this.age = age;
  }

  public Person(String name, String lastName, int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age must be a positive integer");
    } else if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name can't be null or empty");
    } else if (lastName == null || lastName.trim().isEmpty()) {
      throw new IllegalArgumentException("Last name can't be null or empty");
    }

    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }

  public void introduce() {
    System.out.printf("Hello, my name is %s %s and I'm %d years old.\n", name, lastName, age);
  }
}