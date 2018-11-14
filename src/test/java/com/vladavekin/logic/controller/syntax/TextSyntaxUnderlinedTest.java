package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextSyntaxUnderlinedTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void direct() {
        // * курсив текста *
        final String inputValue = "~~~ подчеркнутый текста";
        final String expectedValue = "<u>подчеркнутый текста</u>";

        tatah = new TextUnderlinedSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }
}