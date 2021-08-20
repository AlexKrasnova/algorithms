package ru.alexkrasnovasoft.algorithms.lesson7;

import java.util.List;
import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    List<String> findShortPathViaBfs(String startLabel, String finishLabel);

}
