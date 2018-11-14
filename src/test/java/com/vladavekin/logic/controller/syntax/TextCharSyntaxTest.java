package com.vladavekin.logic.controller.syntax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCharSyntaxTest {

    TextCharSyntax tcs;

    @Test
    public void direct() {

        final String inputValue = "~ курсив текста1 ~" +
                "курсив текста, может быть в тексте ~ курсив текста1 ~ вот так. ~ курсив текста2 ~ \n" +
                "подчеркнутый текста, может быть в тексте ~~~ подчеркнутый текста ~~~ вот так. \n" +
                "жырный текста, может быть в тексте ~~ жырный текст ~~ вот так.";
        final String expectedValue = "<div><p>курсив текста, может быть в тексте <i>курсив текста1</i> вот так. <i>курсив текста2</i> \n" +
                "подчеркнутый текста, может быть в тексте <u>подчеркнутый текста</u> вот так. \n" +
                "жырный текста, может быть в тексте <b>жырный текст</b> вот так. </p></div>";

        tcs = new TextCharSyntax();

        final String actualValue =  tcs.direct(inputValue);

        System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directSpace() {

        final String inputValue = "";
        final String expectedValue = "";

        tcs = new TextCharSyntax();

        final String actualValue =  tcs.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directSpace1() {

        final String inputValue = " ";
        final String expectedValue = "";

        tcs = new TextCharSyntax();

        final String actualValue =  tcs.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directNull() {

        final String inputValue = "";
        final String expectedValue = "";

        tcs = new TextCharSyntax();

        final String actualValue =  tcs.direct(inputValue);

        System.out.println(actualValue);

        assertEquals(expectedValue, actualValue);
    }
}