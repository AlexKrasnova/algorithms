package ru.alexkrasnovasoft.algorithms.lesson4.lindedlist;

public class DoublyLinkedListImpl<E> extends SinglyLinkedListImpl<E> implements DoublyLinkedList<E> {

    Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        } else {
            firstElement.next.previous = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        } else {
            firstElement.previous = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            current.previous = null;
            previous.next = null;
        } else {
            previous.next = current.next;
            current.next.previous = previous;
        }

        current.next = null;
        current.previous = null;
        size--;
        return true;
    }
}
