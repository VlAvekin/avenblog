package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadlineSyntaxTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void directHeadlineTest1() {
        final String[] inputValue = {"# Thema h1\n text",
                "## Thema h2\n text",
                "### Thema h3\n text",
                "#### Thema h4\n text",
                "##### Thema h5\n text",
                "###### Thema h6\n text"};
        final String[] expectedValue = {"<div><p><h1>Thema h1</h1></p></div>",
                "<div><p><h2>Thema h2</h2></p></div>",
                "<div><p><h3>Thema h3</h3></p></div>",
                "<div><p><h4>Thema h4</h4></p></div>",
                "<div><p><h5>Thema h5</h5></p></div>",
                "<div><p><h6>Thema h6</h6></p></div>"};

        tatah = new HeadlineSyntax();

        for (int i = 0; i < expectedValue.length; i++) {
            final String actualValue = tatah.direct(inputValue[i]);

            System.out.println(actualValue);

            //assertEquals(expectedValue[i], actualValue);
        }
    }

    @Test
    public void directHeadlineTest2() {
        final String inputValue = "text # text";
        final String expectedValue = "";

        tatah = new HeadlineSyntax();

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directHeadlineTest3() {

        final String inputValue = "";
        final String expectedValue = "";

        tatah = new HeadlineSyntax();

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);
    }
}