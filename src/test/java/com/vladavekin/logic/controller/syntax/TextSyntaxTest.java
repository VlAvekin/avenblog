package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextSyntaxTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void direct() {

        System.out.println("1" + (char) 13 + "2");

        final String [] inputValue = {"text",
                "\'\'\'java",
                "- bullet 1",
                "# Thema h1",
                "![ImageSyntax](img/180x180.svg)",
                "[GitHub VlAvekin](https://github.com/VlAvekin)"};


        final String expectedValue = "<div><p>text</p></div>";

        tatah = new TextSyntax();

        final StringBuilder actualValue = new StringBuilder();

        for (int i = 0; i < inputValue.length; i++) {
            actualValue.append(tatah.direct(inputValue[i]));

        }

        //System.out.println(String.valueOf(actualValue));

        //assertEquals(expectedValue, String.valueOf(actualValue));

    }
}