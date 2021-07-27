package ru.alexkrasnovasoft.algorithms.lesson2.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NotebookArray {

    private Notebook[] notebooks;
    private String[] brands;
    private Random random;

    public NotebookArray(int size) {
        random = new Random();
        initializeBrands();
        notebooks = generateArray(size);
    }

    public Notebook[] getNotebooks() {
        return notebooks;
    }

    private String getBrand() {
        return brands[random.nextInt(4)];
    }

    private Notebook[] generateArray(int size) {
        Notebook[] notebooks = new Notebook[size];
        for (int i = 0; i < size; i++) {
            notebooks[i] = new Notebook(i, 500 + 100 * random.nextInt(6), 4 + 4 * random.nextInt(3), getBrand());
        }
        return notebooks;
    }

    private void initializeBrands() {
        brands = new String[5];
        brands[0] = "Asus";
        brands[1] = "Acer";
        brands[2] = "Lenovo";
        brands[3] = "Mac";
        brands[4] = "Xiaomi";
    }
}
