package com.vladavekin.logic.model;

import java.util.ArrayList;
import java.util.List;

public class FileMy {

    private String fileName = "";
    private List<String> text = new ArrayList<>();

    public FileMy() {
    }

    public FileMy(final String fileName) {
        this.fileName = fileName;
    }

    public FileMy(String fileName, List<String> text) {
        this.fileName = fileName;
        this.text = text;
    }

    public String get(final int index) {
        return text.get(index);
    }

    public void add(final String text) {
        this.text.add(text);
    }

    public void set(final int index,
                       final String element) {
       text.set(index, element);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(final List<String> text) {
        this.text = text;
    }
}
