package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class TextThumbnailSyntax implements TransforAvenTextAtHTML {
    @Override
    public String direct(String text) {

        if ((validLine.isEmpty(text)) &&
                (text.length() > 2)) {
            if ((text.charAt(0) == '~') &&
                    (text.charAt(1) == '~')  &&
                    (text.charAt(2) == ' ')){
                return "<b>" +
                        parser.split(text, "~ ", " ~") +
                        "</b>";
            }
        }
        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
