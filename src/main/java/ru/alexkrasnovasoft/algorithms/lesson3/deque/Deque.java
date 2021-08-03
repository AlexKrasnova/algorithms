package ru.alexkrasnovasoft.algorithms.lesson3.deque;

import ru.alexkrasnovasoft.algorithms.lesson3.queue.Queue;

public interface Deque<E> extends Queue<E> {

    void insertLeft(E value);

    void insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekLeft();

    E peekRight();

}
