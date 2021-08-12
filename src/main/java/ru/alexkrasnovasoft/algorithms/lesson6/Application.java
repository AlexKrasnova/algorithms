package ru.alexkrasnovasoft.algorithms.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        findAndPrintPercentOfUnbalancedTrees();
    }

    private static void findAndPrintPercentOfUnbalancedTrees() {
        final int NUMBER_OF_TREES = 1000;
        final int MAX_LEVEL = 6;
        final int LEFT_BOUNDARY = -100;
        final int RIGHT_BOUNDARY = 100;
        List<Tree<Integer>> trees = generateTreeArray(NUMBER_OF_TREES, MAX_LEVEL, LEFT_BOUNDARY, RIGHT_BOUNDARY);

        int numberOfBalancedTrees = 0;
        for (Tree<Integer> tree : trees) {
            boolean isBalanced = tree.isBalanced();
            if (isBalanced) {
                numberOfBalancedTrees++;
            }
        }
        System.out.println("Процент сбалансированных деревьев = " + numberOfBalancedTrees * 100. / NUMBER_OF_TREES + " %");
    }

    public static List<Tree<Integer>> generateTreeArray(int number, int maxLevel, int leftBoundary, int rightBoundary) {
        List<Tree<Integer>> trees = new ArrayList<>();
        Random random = new Random();
        int value;
        boolean added;
        for (int i = 0; i < number; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevel);
            added = true;
            while (added) {
                value = random.nextInt(rightBoundary - leftBoundary + 1) + leftBoundary;
                if (!tree.contains(value)) {
                    added = tree.add(value);
                }
            }
            trees.add(tree);
        }
        return trees;
    }
}
