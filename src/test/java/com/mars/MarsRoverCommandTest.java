package com.mars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverCommandTest {

    private MarsRoverCommand marsRoverCommand = new MarsRoverCommand();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void executeInstructions() {
        String actualOutput = marsRoverCommand.executeInstructions("55", "12N", "LMLMLMLMM");
        assertEquals("13N", actualOutput);

        String actualOutput2 = marsRoverCommand.executeInstructions("55", "33E", "MMRMMRMRRM");
        assertEquals("51E", actualOutput2);
    }
}