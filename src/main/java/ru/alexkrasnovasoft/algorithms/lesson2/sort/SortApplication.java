package ru.alexkrasnovasoft.algorithms.lesson2.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortApplication {
    public static void main(String[] args) {
        NotebookArray notebookArray = new NotebookArray(10);
        Notebook[] array = notebookArray.getNotebooks();
        System.out.println(Arrays.toString(array));

        Sorter.sort(array, Sorter.SortType.QUICK_SORT);

        System.out.println(Arrays.toString(array));
    }

}
