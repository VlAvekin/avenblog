package com.vladavekin.logic.view;

import java.util.List;

public class Print<T> {

    public void print(List<T> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",\t");
        }
        System.out.println("]");
    }

    public void print(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\n");
        }
        System.out.println("]");
    }
}
