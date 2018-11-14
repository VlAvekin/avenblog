package com.vladavekin.logic.controller;

public class Replacement {

    public String rep(final String regex,
                      final int from,
                      final int before){
        return regex.substring(from, before);
    }
}