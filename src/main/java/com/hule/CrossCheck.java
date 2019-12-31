package com.hule;

import java.util.ArrayList;
import java.util.List;

public class CrossCheck {
    public List<String> sort(List<String> source) {
        for (int i = 0; i < source.size(); i++) {
            for (int j = i + 1; j < source.size(); j++) {
                if (source.get(i).compareTo(source.get(j)) > 0) {
                    String temp = source.get(j);
                    source.set(j, source.get(i));
                    source.set(i, temp);
                }

            }
        }
        return source;
    }

    public List<String> add(List<String> source, String test) {
        ArrayList<String> results = new ArrayList<>(source);
        results.add(test);
        return results;
    }
}
