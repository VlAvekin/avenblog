package com.vladavekin.logic.model;

import com.vladavekin.logic.controller.Parser;
import com.vladavekin.logic.controller.Replacement;
import com.vladavekin.logic.controller.check.ValidationLinesCheck;

public interface TransforAvenTextAtHTML {

    Parser parser = new Parser();
    Replacement replacement = new Replacement();
    ValidationLinesCheck validLine = new ValidationLinesCheck();

    //            прямое
    public String direct(final String text);

    //            обратное
    public String reverse(final String text);

}
