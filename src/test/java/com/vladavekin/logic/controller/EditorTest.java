package com.vladavekin.logic.controller;

import com.vladavekin.logic.controller.syntax.*;
import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditorTest {

    private Editor editor = new Editor();

    private TransforAvenTextAtHTML headline = new HeadlineSyntax();
    private TransforAvenTextAtHTML bullet = new BulletSyntax();
    private TransforAvenTextAtHTML text = new TextSyntax();
    private TransforAvenTextAtHTML textItalic = new TextItalicSyntax();
    private TransforAvenTextAtHTML textUnderlined = new TextUnderlinedSyntax();
    private TransforAvenTextAtHTML textThumbnail = new TextThumbnailSyntax();
    private TransforAvenTextAtHTML image = new ImageSyntax();
    private TransforAvenTextAtHTML link = new LinkSyntax();


    @Test
    public void direct() {

        final String inputValue = "# TEXT Theme h1\n\n" +
                "## TEXT Theme h1\n\n" +
                "### TEXT Theme h1\n\n" +
                "#### TEXT Theme h1\n\n" +
                "##### TEXT Theme h1\n\n" +
                "###### TEXT Theme h1\n\n" +
                "~ курсив текста ~\n" +
                "курсив текста, может быть в тексте ~ курсив текста ~ вот так.\n" +
                "~~ жырный текст ~~\n" +
                "жырный текста, может быть в тексте ~~ жырный текст ~~ вот так.\n" +
                "~~~ подчеркнутый текста ~~~\n" +
                "подчеркнутый текста, может быть в тексте ~~~ подчеркнутый текста ~~~ вот так. \n\n" +
                "- bullet 1\n" +
                "- bullet 2\n" +
                "- bullet 3\n\n" +
                "TextSyntax TextSyntax TextSyntax TextSyntax .\n"+
                "TextSyntax TextSyntax TextSyntax TextSyntax TextSyntax .\n"+
                "TextSyntax TextSyntax TextSyntax TextSyntax .\n" +
                "\n<GitHub VlAvekin~https://github.com/VlAvekin>\n\n" +
                "!<center~img/800-180.svg>\n" +
                "!<left~img/180-180.svg>\n" +
                "!<right~img/180-180.svg>\n";



        final String expectedValue = "";

        final String actualValue =  editor.direct(inputValue);

        System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct1() {

        final String inputValue = "\n" +
                "~~~ подчеркнутый текста ~~~\n" +
                "подчеркнутый текста, может быть в тексте ~~~ подчеркнутый текста ~~~ вот так. \n" +
                "\n";

        final String expectedValue = "";

        final String actualValue =  editor.direct(inputValue);

        System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct2() {

        final String inputValue = "";

        final String expectedValue = "";

        final String actualValue =  editor.direct(inputValue);

        System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);

    }

    @Test
    public void direct3() {

        final String inputValue = " ";

        final String expectedValue = "";

        final String actualValue =  editor.direct(inputValue);

        System.out.println(actualValue);

        //assertEquals(expectedValue, actualValue);

    }
}