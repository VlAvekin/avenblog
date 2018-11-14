package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import org.junit.Test;

import static org.junit.Assert.*;

public class BulletSyntaxTest {

    private TransforAvenTextAtHTML tatah;

    @Test
    public void directBullet1Test() {
        final String inputValue = "- bullet\n";
        final String expectedValue = "<div>&#8226; bullet</div>";

        tatah = new BulletSyntax();

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void directBullet2Test() {

        final String inputValue = "";
        final String expectedValue = "";

        tatah = new BulletSyntax();

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void directBullet3Test() {
        final String inputValue = "123";
        final String expectedValue = "";

        tatah = new BulletSyntax();

        final String actualValue =  tatah.direct(inputValue);

        assertEquals(expectedValue, actualValue);
    }
}