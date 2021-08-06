package ru.alexkrasnovasoft.algorithms.lesson3.queue;

public class ArrayQueueImpl<E> implements Queue<E> {

    protected E[] elements;
    protected int first;
    protected int last;
    protected int size;

    public ArrayQueueImpl(int maxSize) {
        elements = (E[]) new Object[maxSize];
        last = -1;
        first = -1;
        size = 0;
    }

    @Override
    public void insert(E value) {
        if (isFull()) {
            throw new IllegalStateException("Очередь переполнена.");
        }
        if (isEmpty()) {
            first = 0;
        }
        if (last == elements.length - 1) {
            last = 0;
        } else {
            last++;
        }
        elements[last] = value;
        size++;
    }

    @Override
    public E remove() {
        E result = peekFront();
        elements[first] = null;
        size--;
        if (isEmpty()) {
            first = -1;
            last = -1;
        } else {
            if (first == elements.length - 1) {
                first = 0;
            } else {
                first++;
            }
        }

        return result;
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return elements[first];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size >= elements.length;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        if (first < last) {
            for (int i = first; i < last; i++) {
                sb.append(elements[i] + ", ");
            }

        } else {
            for (int i = first; i < elements.length; i++) {
                sb.append(elements[i] + ", ");
            }

            for (int i = 0; i < last; i++) {
                sb.append(elements[i] + ", ");
            }


        }
        sb.append(elements[last] + "]");
        System.out.println(sb.toString());
    }


}
