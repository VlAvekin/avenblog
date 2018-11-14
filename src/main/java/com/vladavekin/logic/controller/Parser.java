package com.vladavekin.logic.controller;

public class Parser {

    public String split(String str, String from, String before) {

        String[] lines = str.split(before);
        lines = lines[0].split(from);
        String resultStr = lines[lines.length-1];

        return  resultStr;
    }

    public String split(String str, String from){

        String[] var = str.split(from);

        return var[var.length-1];
    }

    public String[] splitArray(String str, String from){

        String[] var = str.split(from);

        return var;
    }

    public String[] splitArray(String str){

        String[] var = str.split("\n");

        return var;
    }

}
