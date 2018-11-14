package com.vladavekin.logic.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReplacementTest {

    @Test
    public void rep() {
        final String inputValue = "text1 text2 text3";
        final String expectedValue = "text1 TEXT2 text3";

        Replacement replacement = new Replacement();

        //final String actualValue = replacement.rep(inputValue, "TEXT2", 6, 11);

        //System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);
    }
}