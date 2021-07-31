package ru.alexkrasnovasoft.algorithms.lesson3.queue;

public interface Queue<T> {

    void add(T element);

    T poll();

    T peek();

    boolean isEmpty();

    void display();
}
