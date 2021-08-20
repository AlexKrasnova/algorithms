package ru.alexkrasnovasoft.algorithms.lesson7;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    public boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
        adjMatrix[endIndex][startIndex] = true;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    @Override
    public Stack<String> findShortPathViaBfs(String startLabel, String finishLabel) {
        Stack<String> shortPath = new Stack<>();
        if (startLabel.equals(finishLabel)) {
            shortPath.add(startLabel);
            return shortPath;
        }

        List<Stack<String>> allPaths = findAllPaths(startLabel, finishLabel);
        //System.out.println(allPaths);
        int shortPathLength = adjMatrix.length + 1;
        for (Stack<String> path : allPaths) {
            if (path.size() < shortPathLength) {
                shortPathLength = path.size();
                shortPath = path;
            }
        }

        return shortPath;
    }

    private List<Stack<String>> findAllPaths(String startLabel, String finishLabel) {

        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Неверный лейбл: " + startLabel + " или " + finishLabel);
        }
        List<Stack<String>> paths = new LinkedList<>();
        List<Stack<String>> result = new LinkedList<>();
        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        queue.add(vertex);
        paths.add(new Stack<>());
        paths.get(0).add(vertex.getLabel());
        List<Vertex> nearVertices;
        while (!queue.isEmpty()) {
            nearVertices = findAllNearVertices(queue.peek());
            for (Vertex vertex1 : nearVertices) {
                if (tryToAddVertexToPaths(vertex1, queue.peek(), paths)) {
                    queue.add(vertex1);
                }
            }
            List<Stack<String>> removedPaths = new LinkedList<>();
            for (Stack<String> stack : paths) {
                if (stack.peek().equals(finishLabel)) {
                    result.add(stack);
                    removedPaths.add(stack);

                } else if (stack.peek().equals(queue.peek().getLabel())) {
                    removedPaths.add(stack);
                }
            }
            for (Stack<String> stack : removedPaths) {
                paths.remove(stack);
            }
            queue.remove();
        }

        return result;
    }

    private boolean tryToAddVertexToPaths(Vertex vertex, Vertex previousVertex, List<Stack<String>> paths) {
        boolean isVertexAdded = false;
        List<Stack<String>> addedPaths = new LinkedList<>();
        for (Stack<String> stack : paths) {
            if (stack.peek().equals(previousVertex.getLabel()) && !stack.contains(vertex.getLabel())) {
                Stack<String> newStack = new Stack<>();
                newStack.addAll(stack);
                newStack.add(vertex.getLabel());
                addedPaths.add(newStack);
                isVertexAdded = true;
            }
        }
        paths.addAll(addedPaths);
        return isVertexAdded;
    }

    private List<Vertex> findAllNearVertices(Vertex vertex) {
        List<Vertex> nearVertices = new ArrayList<>();
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i]) {
                nearVertices.add(vertexList.get(i));
            }
        }
        return nearVertices;

    }

}
