package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class TextUnderlinedSyntax implements TransforAvenTextAtHTML {
    @Override
    public String direct(String text) {
        if ((validLine.isEmpty(text)) &&
                (text.length() > 3)) {
            if ((text.charAt(0) == '~') &&
                    (text.charAt(1) == '~')  &&
                    (text.charAt(2) == '~')  &&
                    (text.charAt(3) == ' ')){
                return "<u>" +
                        parser.split(text, "~ ", " ~") +
                        "</u>";
            }
        }
        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
