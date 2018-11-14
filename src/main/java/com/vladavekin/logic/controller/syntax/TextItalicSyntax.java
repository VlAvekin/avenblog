package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class TextItalicSyntax implements TransforAvenTextAtHTML {

    @Override
    public String direct(String text) {

        if (validLine.isEmpty(text)) {
           if ((text.charAt(0) == '~') &&
                   (text.charAt(1) == ' ')) {
               return "<i>" +
                       parser.split(text, "~ ", " ~") +
                       "</i>";
           }
        }
        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
