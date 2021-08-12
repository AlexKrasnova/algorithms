package ru.alexkrasnovasoft.algorithms.lesson5;

import java.util.*;

public class KnapsackProblemSolver {
    public static void main(String[] args) {

        List<Thing> list = new LinkedList<>();
        list.add(new Thing("Книга", 1, 600));
        list.add(new Thing("Бинокль", 2, 5000));
        list.add(new Thing("Аптечка", 4, 1500));
        list.add(new Thing("Ноутбук", 2, 40000));
        list.add(new Thing("Котелок", 1, 500));
        System.out.println(solveKnapsackProblem(list, 4));
    }

    public static Set<Thing> solveKnapsackProblem(List<Thing> list, int knapsackCapacity) {
        Set<Set<Thing>> combinations = getAllCombinations(list);
        Iterator<Set<Thing>> iter = combinations.iterator();
        while (iter.hasNext()) {
            Set<Thing> temp = iter.next();
            if (getMass(temp) > knapsackCapacity) {
                iter.remove();
            }
        }
        return getMostValuableCombination(combinations);
    }

    private static Set<Thing> getMostValuableCombination(Set<Set<Thing>> combinations) {
        Set<Thing> mostValuableCombination = new TreeSet<>();
        Integer maxPrice = 0;
        for (Set<Thing> combination : combinations) {
            if (getPrice(combination) >= maxPrice) {
                maxPrice = getPrice(combination);
                mostValuableCombination = combination;
            }
        }
        return mostValuableCombination;
    }

    private static Integer getMass(Set<Thing> combination) {
        Integer mass = 0;
        for (Thing thing : combination) {
            mass = mass + thing.getMass();
        }
        return mass;
    }

    private static Integer getPrice(Set<Thing> combination) {
        Integer price = 0;
        for (Thing thing : combination) {
            price = price + thing.getPrice();
        }
        return price;
    }

    private static Set<Set<Thing>> getAllCombinations(List<Thing> list) {
        Set<Set<Thing>> results = new HashSet<>();
        for (int i = 1; i < list.size(); i++) {
            results.addAll(getCombinations(i, list));
        }
        return results;
    }

    private static Set<Set<Thing>> getCombinations(int k, List<Thing> list) {
        if (k > list.size()) {
            throw new IllegalArgumentException();
        }
        Set<Set<Thing>> results = new HashSet<>();
        if (k == 0) {
            return results;
        }
        if (k == 1) {
            for (Thing element : list) {
                Set<Thing> result = new TreeSet<>();
                result.add(element);
                results.add(result);
            }
            return results;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Thing> newList = new LinkedList<>(list);
            newList.remove(list.get(i));
            Set<Set<Thing>> sets = getCombinations(k - 1, newList);
            for (Set<Thing> set1 : sets) {
                Set<Thing> newSet1 = new TreeSet<>(set1);
                newSet1.add(list.get(i));
                results.add(newSet1);
            }
        }
        return results;
    }
}
