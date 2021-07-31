package ru.alexkrasnovasoft.algorithms.lesson3.queue;

public class ArrayQueueImpl<T> implements Queue<T> {

    private T[] elements;
    int first;
    int last;
    int size;

    @SuppressWarnings("unchecked")
    public ArrayQueueImpl(int maxSize) {
        elements = (T[]) new Object[maxSize];
        last = -1;
        first = -1;
        size = 0;
    }

    @Override
    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Очередь переполнена.");
        }
        if(isEmpty()) {
            first = 0;
        }
        if(last == elements.length - 1) {
            last = 0;
        } else {
            last++;
        }
        elements[last] = element;
        size++;
    }

    @Override
    public T poll() {
        T result = peek();
        elements[first] = null;
        first++;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Очередь пуста.");
        }
        return elements[first];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size >= elements.length;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        if (first<last) {
            for (int i = first; i< last; i++) {
                sb.append(elements[i] + ", ");
            }

        } else {
            for (int i = first; i<elements.length; i++) {
                sb.append(elements[i] + ", ");
            }

            for (int i = 0; i<last; i++) {
                sb.append(elements[i] + ", ");
            }


        }
        sb.append(elements[last] + "]");
        System.out.println(sb.toString());
    }
}
