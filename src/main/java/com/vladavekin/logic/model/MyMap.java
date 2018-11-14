package com.vladavekin.logic.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMap {

    private Map<String, List<Integer>> map;

    public MyMap() {
        map = new HashMap<>();
    }

    public MyMap(Map<String, List<Integer>> map) {
        this.map = map;
    }

    public List<Integer> getList(String key) {
        return map.get(key);
    }

    public int getKeySize(String key) {

        if (map.get(key) != null){
            return map.get(key).size();
        }

        return -1;
    }

    public void add(String key, Integer var) {

        List<Integer> temp = new ArrayList<>();

        if (map.get(key) != null){
            temp = map.get(key);
        }

        temp.add(var);

        map.put(key, temp);

    }

    public Map<String, List<Integer>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Integer>> map) {
        this.map = map;
    }
}
