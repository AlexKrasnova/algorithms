package ru.alexkrasnovasoft.algorithms.lesson4.deque;

import ru.alexkrasnovasoft.algorithms.lesson3.deque.Deque;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedList;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedListImpl;

public class LinkedListDequeImpl<E> implements Deque<E> {

    DoublyLinkedList<E> data;

    public LinkedListDequeImpl() {
        data = new DoublyLinkedListImpl<>();
    }

    @Override
    public void insertLeft(E value) {
        data.insertFirst(value);
    }

    @Override
    public void insertRight(E value) {
        data.insertLast(value);
    }

    @Override
    public E removeLeft() {
        if(isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        if(isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return data.removeLast();
    }

    @Override
    public E peekLeft() {
        if(isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return data.getFirst();
    }

    @Override
    public E peekRight() {
        if(isEmpty()) {
            throw new IllegalStateException("Очередь пуста.");
        }
        return data.getLast();
    }

    @Override
    public void insert(E value) {
        insertRight(value);
    }

    @Override
    public E remove() {
        return removeLeft();
    }

    @Override
    public E peekFront() {
        return peekLeft();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString(){
        return "LinkedListDequeImpl{" + "data=" + data + '}';
    }
}
