package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextUnderlinedSyntaxTest {

    TransforAvenTextAtHTML tatah = new TextUnderlinedSyntax();

    @Test
    public void direct() {
        final String inputValue = "~~~ text ~~~\n";
        final String expectedValue = "<u>text</u>";

        final String actualValue =  tatah.direct(inputValue);


        assertEquals(expectedValue, actualValue);
    }
}