package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageSyntaxTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void direct1() {

        final String inputValue = "!<center~img/800-180.svg>";
        final String expectedValue = "<div class=\"text-center\">\n" +
                "<img src=\"img/800-180.svg\" class=\"rounded\" alt=\"\">\n" +
                "</div>";

        tatah = new ImageSyntax();

        final String actualValue =  tatah.direct(inputValue);

        //System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct2() {

        final String inputValue = "!<left~img/800-180.svg>";
        final String expectedValue = "<img src=\"img/800-180.svg\" class=\"rounded float-left\" alt=\"...\">";

        tatah = new ImageSyntax();

        final String actualValue =  tatah.direct(inputValue);

        //System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct3() {

        final String inputValue = "!<right~img/800-180.svg>";
        final String expectedValue = "<img src=\"img/800-180.svg\" class=\"rounded float-right\" alt=\"...\">";

        tatah = new ImageSyntax();

        final String actualValue =  tatah.direct(inputValue);

        //System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);

    }
}