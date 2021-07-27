package ru.alexkrasnovasoft.algorithms.lesson2.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sorter {

    public enum SortType {
        QUICK_SORT
    }

    public static <T extends Comparable<? super T>> List<T> quickSort(List<T> list) {

        if (list.isEmpty()) {
            return list;
        }

        T base = list.get(0);

        List<T> left = new LinkedList<>();
        List<T> middle = new LinkedList<>();
        List<T> right = new LinkedList<>();

        for (T element : list) {
            if (element.equals(base)) {
                middle.add(element);
            } else if (element.compareTo(base) < 0) {
                left.add(element);
            } else {
                right.add(element);
            }
        }

        /*System.out.println(left);
        System.out.println(middle);
        System.out.println(right);*/

        left = quickSort(left);
        right = quickSort(right);

        left.addAll(middle);
        left.addAll(right);

        return left;

    }

    public static <T extends Comparable<? super T>> void sort(T[] array, SortType sortType) {
        List<T> list = Arrays.asList(array);
        if (sortType == SortType.QUICK_SORT) {
            quickSort(list).toArray(array);
        }

    }

}
