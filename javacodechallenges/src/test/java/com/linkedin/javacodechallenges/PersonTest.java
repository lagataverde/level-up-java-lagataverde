package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PersonTest 
{
    @Test
    public void testPersonConstructorIsValid()
    {
        Person partner = new Person("Ross", "Simpson", 33);
        assertEquals("Ross", partner.getName());
        assertEquals("Simpson", partner.getLastname());
        assertEquals(33, partner.getAge());
    }

    @Test
    public void testPersonConstructorWithInvalidName() {
        try {
            Person person = new Person("", "Simpson", 33);
        } catch (IllegalArgumentException e) {
            assertEquals("Name can't be null or empty", e.getMessage());
        }
    }
}
