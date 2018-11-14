package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class ImageSyntax implements TransforAvenTextAtHTML {
    @Override
    public String direct(String text) {

        if (validLine.isEmpty(text)) {
            if (text.charAt(0) == '!') {

                final String teg  = parser.split(text, "<", "~");
                final String val = parser.split(text, "~", ">");


                if (teg.equals("center")){
                    return "<div class=\"text-center\">\n" +
                            "<img src=\"" +
                            val +
                            "\" class=\"rounded\" alt=\"\">\n" +
                            "</div>";
                } else {
                    return "<img src=\"" +
                            val +
                            "\" class=\"rounded float-" +
                            teg +
                            "\" alt=\"...\">";
                }
            }
        }

        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
