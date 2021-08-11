package ru.alexkrasnovasoft.algorithms.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        findAndPrintPercentOfUnbalancedTrees();

        /*
        // Пример дерева, для которого некорректно работает метод isBalanced()
        Tree<Integer> tree = new TreeImpl<>(6);
        tree.add(-9);
        tree.add(-14);
        tree.add(7);
        tree.add(-19);
        tree.add(-10);
        tree.add(-6);
        tree.add(23);
        tree.add(-17);
        tree.add(-7);
        tree.add(1);
        tree.add(14);
        tree.add(24);
        tree.add(5);
        tree.add(8);
        tree.add(15);
        tree.display();
        tree.isBalanced();
        */


    }

    private static void findAndPrintPercentOfUnbalancedTrees() {
        final int NUMBER_OF_TREES = 1000;
        final int MAX_LEVEL = 5;
        final int LEFT_BOUNDARY = -25;
        final int RIGHT_BOUNDARY = 25;
        List<Tree<Integer>> trees = generateTreeArray(NUMBER_OF_TREES, MAX_LEVEL, LEFT_BOUNDARY, RIGHT_BOUNDARY);

        int numberOfBalancedTrees = 0;
        for(Tree<Integer> tree : trees) {
            //tree.display();
            boolean isBalanced = tree.isBalanced();
            //todo: Поправить работу метода isBalanced(), в данный момент в некоторых случаях работает некорректно.
            //System.out.println("isBalanced() = " + tree.isBalanced());
            if (isBalanced) {
                tree.display();
                numberOfBalancedTrees++;
            }
        }
        System.out.println("Процент сбалансированных деревьев = " + numberOfBalancedTrees*100./NUMBER_OF_TREES + " %");
    }

    public static List<Tree<Integer>> generateTreeArray(int number, int maxLevel, int leftBoundary, int rightBoundary) {
        List<Tree<Integer>> trees = new ArrayList<>();
        Random random = new Random();
        int value;
        boolean added;
        for (int i = 0; i<number; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevel);
            added = true;
            while (added) {
                value = random.nextInt(rightBoundary-leftBoundary + 1) + leftBoundary;
                if(!tree.contains(value)) {
                    added = tree.add(value);
                }
            }
            trees.add(tree);
        }
        return trees;
    }
}
