package com.vladavekin.logic.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileMyTest {

    private FileMy fileMy;

    @Test
    public void getFileNameTrue() {
        final String inputValue = "fileName";

        final String expectedValue = "fileName";

        fileMy = new FileMy(inputValue, null);

        final String actualValue = fileMy.getFileName();

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void getFileNameFalse() {
        final String inputValue = "fileName";

        final String expectedValue = "nameFile";

        fileMy = new FileMy(inputValue, null);

        final String actualValue = fileMy.getFileName();

        assertNotEquals(expectedValue, actualValue);
    }
    @Test
    public void getFileNameNull() {

        final String inputValue = "fileName";

        fileMy = new FileMy(inputValue, null);

        final String actualValue = fileMy.getFileName();

        assertNotNull(actualValue);
    }

//    @Test
//    public void getValuesTrue() {
//        final String inputValue = "values";
//
//        final String expectedValue = "values";
//
//        fileMy = new FileMy(null, inputValue);
//
//        final String actualValue = fileMy.getValues();
//
//        assertEquals(expectedValue, actualValue);
//    }
//    @Test
//    public void getValuesFalse() {
//        final String inputValue = "values";
//
//        final String expectedValue = "text";
//
//        fileMy = new FileMy(null, inputValue);
//
//        final String actualValue = fileMy.getValues();
//
//        assertNotEquals(expectedValue, actualValue);
//    }
//    @Test
//    public void getValuesNull() {
//        final String inputValue = "values";
//
//        fileMy = new FileMy(null, inputValue);
//
//        final String actualValue = fileMy.getValues();
//
//        assertNotNull(actualValue);
//    }
}