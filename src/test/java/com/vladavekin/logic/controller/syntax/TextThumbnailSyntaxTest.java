package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextThumbnailSyntaxTest {

    TransforAvenTextAtHTML tatah = new TextThumbnailSyntax();

    @Test
    public void direct() {
        final String inputValue = "~~ text ~~\n";
        final String expectedValue = "<b>text</b>";

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);
    }
}