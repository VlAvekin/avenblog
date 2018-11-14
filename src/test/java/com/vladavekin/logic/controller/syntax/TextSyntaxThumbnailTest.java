package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextSyntaxThumbnailTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void directTextThumbnail1() {
        // * курсив текста *
        final String inputValue = "~~ жырный текста";
        final String expectedValue = "<b>жырный текста</b>";

        tatah = new TextThumbnailSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directTextThumbnail2() {
        // * курсив текста *
        final String inputValue = "~~жырный текста";
        final String expectedValue = "";

        tatah = new TextThumbnailSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directTextThumbnail3() {
        // * курсив текста *
        final String inputValue = "~~~ жырный текста";
        final String expectedValue = "";

        tatah = new TextThumbnailSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directTextThumbnail4() {
        // * курсив текста *
        final String inputValue = "~ жырный текста";
        final String expectedValue = "";

        tatah = new TextThumbnailSyntax();

        final String actualValue =  tatah.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }
}