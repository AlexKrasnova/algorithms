package ru.alexkrasnovasoft.algorithms.lesson3.search;

import java.util.Arrays;
import java.util.Random;

public class MyArray {

    public static Integer[] generateArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        int skippedElement = random.nextInt(size) + 1;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < skippedElement) {
                array[i] = i + 1;
            } else {
                array[i] = i + 2;
            }
        }
        return array;
    }

    public static Integer findSkippedElement(Integer[] array) {

        if (!array[0].equals(1)) {
            return 1;
        }

        int start = 0;
        int end = array.length - 1;
        int base = (start + end) / 2;

        while (start != end && !(array[base].equals(base + 1) && array[base + 1].equals(base + 3))) {
            if (array[base].equals(base + 1) && array[base + 1].equals(base + 3)) {
                break;
            } else if (array[base].equals(base + 1)) {
                start = base;
            } else {
                end = base;
            }
            base = (start + end) / 2;
        }

        return array[base] + 1;
    }
}
