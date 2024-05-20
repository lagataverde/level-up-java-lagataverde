package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void fastFoward100DaysTest()
    {
        LocalDate inOneHundredDays = App.fastFoward100Days();
        assertEquals(2024, inOneHundredDays.getYear());
        assertEquals(8, inOneHundredDays.getMonth().getValue());
        assertEquals(28, inOneHundredDays.getDayOfMonth());
    }
}
