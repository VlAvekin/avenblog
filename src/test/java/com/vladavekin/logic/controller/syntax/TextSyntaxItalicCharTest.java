package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextSyntaxItalicCharTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void directItalicText1() {
        // * курсив текста *
        final String inputValue = "~ курсив текста";
        final String expectedValue = "<i>курсив текста</i>";

        tatah = new TextItalicSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void directItalicText2() {
        // * курсив текста *
        final String inputValue = "~курсив текста";
        final String expectedValue = "";

        tatah = new TextItalicSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void directItalicText3() {
        // * курсив текста *
        final String inputValue = "~~ курсив текста";
        final String expectedValue = "";

        tatah = new TextItalicSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

}