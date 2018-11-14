package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class BulletSyntax implements TransforAvenTextAtHTML {

    @Override
    public String direct(String text) {

        if (validLine.isEmpty(text)) {
            if (text.charAt(0) == '-') {
                return "<div>&#8226; " +
                       parser.split(text, "- ", "\n") +
                       "</div>";
            }
        }
        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }
}
