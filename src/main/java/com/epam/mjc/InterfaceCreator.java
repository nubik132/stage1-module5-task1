package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String string :
                    x) {
                char firstUpperChar = string.toUpperCase().charAt(0);
                if (string.charAt(0) != firstUpperChar || Character.isDigit(firstUpperChar)){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) x.add(x.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(string -> string.charAt(0) != string.toUpperCase().charAt(0) ||
                    !string.endsWith(".") ||
                    string.split(" ").length <= 3);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String string:
                 x) {
                map.put(string, string.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>(list1);
            newList.addAll(list2);
            return newList;
        };
    }
}
