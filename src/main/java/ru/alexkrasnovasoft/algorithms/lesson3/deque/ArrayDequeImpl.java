package ru.alexkrasnovasoft.algorithms.lesson3.deque;

import ru.alexkrasnovasoft.algorithms.lesson3.queue.ArrayQueueImpl;

public class ArrayDequeImpl<E> extends ArrayQueueImpl<E> implements Deque<E> {

    public ArrayDequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insertLeft(E value) {
        if (isFull()) {
            throw new IllegalStateException("Очередь переполнена.");
        }
        if (isEmpty()) {
            first = 0;
            last = 0;
        } else {
            if (first == 0) {
                first = elements.length - 1;
            } else {
                first--;
            }
        }
        elements[first] = value;
        size++;
    }

    @Override
    public void insertRight(E value) {
        super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        E result = peekRight();
        elements[last] = null;
        size--;
        if (isEmpty()) {
            first = -1;
            last = -1;
        } else {
            if (last == 0) {
                last = elements.length - 1;
            } else {
                last--;
            }
        }
        return result;
    }

    @Override
    public E peekLeft() {
        return peekFront();
    }

    @Override
    public E peekRight() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return elements[last];
    }
}
