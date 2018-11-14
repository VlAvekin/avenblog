package com.vladavekin.logic.controller;

import com.vladavekin.logic.controller.syntax.*;
import com.vladavekin.logic.model.TransforAvenTextAtHTML;

public class Editor {

    private Parser parser = new Parser();

    private TransforAvenTextAtHTML headline = new HeadlineSyntax();
    private TransforAvenTextAtHTML bullet = new BulletSyntax();
    private TransforAvenTextAtHTML textItalic = new TextItalicSyntax();
    private TransforAvenTextAtHTML textUnderlined = new TextUnderlinedSyntax();
    private TransforAvenTextAtHTML textThumbnail = new TextThumbnailSyntax();
    private TransforAvenTextAtHTML image = new ImageSyntax();
    private TransforAvenTextAtHTML link = new LinkSyntax();

    public String direct(final String line){

        final String par[] = parser.splitArray(line);


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < par.length; i++) {

            builder.append(headline.direct(par[i]));

            builder.append(bullet.direct(par[i]));

            TextCharSyntax text = new TextCharSyntax();

            builder.append(text.direct(par[i]));
            builder.append(textItalic.direct(par[i]));
            builder.append(textUnderlined.direct(par[i]));
            builder.append(textThumbnail.direct(par[i]));

            builder.append(image.direct(par[i]));

            builder.append(link.direct(par[i]));

            if (par[i].charAt(0) == 13){
                builder.append("<br>");
            }

            builder.append("\n");

        }
        return String.valueOf(builder);

    }

}
