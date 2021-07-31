package ru.alexkrasnovasoft.algorithms.lesson3.search;

import java.util.Arrays;

public class SearchApplication {
    public static void main(String[] args) {

        testSearch();
    }

    private static void testSearch() {
        Integer[] a1 = MyArray.generateArray(10);
        System.out.println(Arrays.toString(a1));
        System.out.println(MyArray.findSkippedElement(a1));
    }
}
