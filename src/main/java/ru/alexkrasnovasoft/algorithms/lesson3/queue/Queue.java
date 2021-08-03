package ru.alexkrasnovasoft.algorithms.lesson3.queue;

public interface Queue<E> {

    void insert(E value);

    E remove();

    E peekFront();

    int size();

    boolean isFull();

    boolean isEmpty();

    void display();
}
