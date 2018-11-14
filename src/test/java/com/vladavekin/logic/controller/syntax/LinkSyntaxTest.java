package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkSyntaxTest {

    TransforAvenTextAtHTML tatah;

    @Test
    public void direct() {

        final String inputValue = "<GitHub VlAvekin~https://github.com/VlAvekin>";
        final String expectedValue = "<a href=\"https://github.com/VlAvekin\"> GitHub VlAvekin </a>";

        tatah = new LinkSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct1() {

        final String inputValue = "!<GitHub VlAvekin~https://github.com/VlAvekin>";
        final String expectedValue = "";

        tatah = new LinkSyntax();

        final String actualValue =  tatah.direct(inputValue);

        //System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct2() {

        final String inputValue = "";
        final String expectedValue = "";

        tatah = new LinkSyntax();

        final String actualValue =  tatah.direct(inputValue);

        //System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }
}