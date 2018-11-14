package com.vladavekin.logic.controller.syntax;

import com.vladavekin.logic.controller.Parser;
import com.vladavekin.logic.controller.syntax.TextItalicSyntax;
import com.vladavekin.logic.controller.syntax.TextThumbnailSyntax;
import com.vladavekin.logic.controller.syntax.TextUnderlinedSyntax;
import com.vladavekin.logic.model.MyMap;
import com.vladavekin.logic.model.TransforAvenTextAtHTML;
import com.vladavekin.logic.view.Print;

import java.util.ArrayList;
import java.util.List;

public class TextCharSyntax implements TransforAvenTextAtHTML{

    private MyMap myMap = new MyMap();
    private TransforAvenTextAtHTML tatah;

    private TransforAvenTextAtHTML textPor = new TextSyntax();

    private List<String> list = new ArrayList<>();

    @Override
    public String direct(String text) {

        // TODO допилить тесты и проверки

        if (validLine.isEmpty(text)) {
            if ((text.charAt(0) != '#') &&
                    (text.charAt(0) != '<') &&
                    (text.charAt(0) != '!') &&
                    (text.charAt(0) != '-') &&
                    (text.charAt(0) != '~') &&
                    (text.charAt(0) != '[') &&
                    (text.charAt(0) != '\'')) {

                final String[] val = parser.splitArray(text, " ");

                for (int i = 0; i < val.length; i++) {

                    list.add(val[i]);

                    if (val[i].equals("~")) {
                        myMap.add("~", i);
                    }
                    if (val[i].equals("~~")) {
                        myMap.add("~~", i);
                    }
                    if (val[i].equals("~~~")) {
                        myMap.add("~~~", i);
                    }
                }

                //Print print = new Print();
                //print.print(list);

                text("~");
                text("~~");
                text("~~~");

                //print.print(list);

                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).equals("")) {
                        builder.append(list.get(i) + " ");
                    }
                }

                //System.out.println(builder);

                return textPor.direct(String.valueOf(builder));
            }
        }

        return "";
    }

    @Override
    public String reverse(String text) {
        return null;
    }

    private void text(String key){

        for (int i = 0; i < myMap.getKeySize(key); i += 2) {

            String tex = "";

            for (int j = myMap.getList(key).get(i); j < myMap.getList(key).get(i + 1) + 1; j++) {
                tex += list.get(j) + " ";
            }

            //System.out.println(tex);

            listRemove(myMap.getList(key).get(i), myMap.getList(key).get(i + 1) + 1);

            if (key.equals("~"))
                tatah = new TextItalicSyntax();
            if (key.equals("~~"))
                tatah = new TextThumbnailSyntax();
            if (key.equals("~~~"))
                tatah = new TextUnderlinedSyntax();
//
            list.add(myMap.getList(key).get(i), tatah.direct(tex));

        }

    }

    private void listRemove(int from, int befor){
        int var = befor - from;
        for (int i = 0; i < var; i++) {
            list.remove(from);
        }
        for (int i = 0; i < var - 1; i++) {
            list.add(i + from, "");
        }
    }

}
