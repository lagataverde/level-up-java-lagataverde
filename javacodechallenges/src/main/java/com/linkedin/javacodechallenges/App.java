package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person partner = new Person("Ross", "Simpson", 34);
        Person sister = new Person("Sofia", "Lara", 29);
        Person mother = new Person("Vivian", "Duarte", 51);

        partner.introduce();
        sister.introduce();
        mother.introduce();
    }
}
