package ru.alexkrasnovasoft.algorithms.lesson5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        testInvolution();

    }

    private static void testInvolution() {
        System.out.println("Тестирование возведения в степень:");
        System.out.println("2 ^ 1 = " + involute(2, 1));
        System.out.println("2 ^ 2 = " + involute(2, 2));
        System.out.println("2 ^ 3 = " + involute(2, 3));
        System.out.println("2 ^ 10 = " + involute(2, 10));
        System.out.println("3 ^ 4 = " + involute(3, 4));
        System.out.println("(-3) ^ 2 = " + involute(-3, 2));
        System.out.println("(-3) ^ 3 = " + involute(-3, 3));
        System.out.println();
    }

    public static Integer involute(Integer a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        }
        return a * involute(a, n - 1);
    }
}
