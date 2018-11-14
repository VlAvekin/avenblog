package com.vladavekin.logic.controller.check;

public class ValidationLinesCheck {


    public boolean isEmpty(String text){

        if (text != null){
            if (text.length() != 0){
                if (!text.equals(" ")){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
