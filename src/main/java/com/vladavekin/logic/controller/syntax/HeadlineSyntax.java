package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class HeadlineSyntax implements TransforAvenTextAtHTML {

    //            прямое
    @Override
    public String direct(final String text) {
        int colTeg = 0;

        if (validLine.isEmpty(text)) {
            if (text.charAt(0) == '#') {

                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == '#') {
                        colTeg++;
                    }
                }

                return String.format("<div><p><h%s>" +
                        parser.split(text, "# ", "\n") +
                        "</h%s></p></div>", colTeg, colTeg);
            }
        }
        return "";
    }

    //            обратное
    @Override
    public String reverse(final String text) {
        return null;
    }
}
