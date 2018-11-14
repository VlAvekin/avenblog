package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class LinkSyntax implements TransforAvenTextAtHTML {
    @Override
    public String direct(String text) {

        if (validLine.isEmpty(text)) {
            if (text.charAt(0) == '<') {

                final String teg  = parser.split(text, "<", "~");
                final String val = parser.split(text, "~", ">");

                return "<a href=\"" +
                        val +
                        "\"> " +
                        teg +
                        " </a>";

            }
        }

        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
