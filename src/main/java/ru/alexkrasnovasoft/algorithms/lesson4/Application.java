package ru.alexkrasnovasoft.algorithms.lesson4;

import ru.alexkrasnovasoft.algorithms.lesson3.deque.Deque;
import ru.alexkrasnovasoft.algorithms.lesson4.deque.LinkedListDequeImpl;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedList;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedListImpl;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.LinkedList;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.SinglyLinkedListImpl;

import java.util.Iterator;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        testSinglyLinkedList();
        testDoublyLinkedList();
        testLinkedListDeque();


    }

    private static void testLinkedListDeque() {
        System.out.println("Тестирование двусторонней очереди:");

        Deque<Integer> deque = new LinkedListDequeImpl<>();
        deque.insert(3);
        deque.insert(4);
        deque.display();
        deque.insertRight(5);
        deque.insertRight(6);
        deque.insertLeft(2);
        deque.insertLeft(1);
        deque.display();
        System.out.println("deque.remove() = " + deque.remove());
        System.out.println("deque.removeRight() = " + deque.removeRight());
        System.out.println("deque.removeLeft() = " + deque.removeLeft());
        System.out.println("deque.peekRight() = " + deque.peekRight());
        System.out.println("deque.peekLeft() = " + deque.peekLeft());
        deque.display();
        System.out.println();
    }

    private static void testDoublyLinkedList() {
        System.out.println("Тестирование двусвязного списка:");

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedListImpl<>();
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertLast(4);
        doublyLinkedList.insertLast(5);
        doublyLinkedList.insertLast(6);
        doublyLinkedList.insertLast(7);
        doublyLinkedList.display();
        System.out.println("Тестирование итератора:");
        for (Integer element : doublyLinkedList) {
            System.out.println(element);
        }
        System.out.println("Окончание тестирования итератора.");

        System.out.println("doublyLinkedList.contains(6) = " + doublyLinkedList.contains(6));
        System.out.println("doublyLinkedList.removeFirst() = " + doublyLinkedList.removeFirst());
        System.out.println("doublyLinkedList.remove(3) = " + doublyLinkedList.remove(3));
        doublyLinkedList.display();
        System.out.println("doublyLinkedList.getLast() = " + doublyLinkedList.getLast());
        System.out.println("doublyLinkedList.removeLast() = " + doublyLinkedList.removeLast());
        System.out.println("doublyLinkedList.removeLast() = " + doublyLinkedList.removeLast());
        doublyLinkedList.display();
        System.out.println();
    }

    private static void testSinglyLinkedList() {
        System.out.println("Тестирование односвязного списка:");

        LinkedList<Integer> list = new SinglyLinkedListImpl<>();
        list.insertFirst(6);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();

        System.out.println("Тестирование итератора:");
        for (Integer element : list) {
            System.out.println(element);
        }
        System.out.println("Окончание тестирования итератора.");

        System.out.println("list.contains(3) = " + list.contains(3));
        list.display();

        System.out.println("list.remove(3) = " + list.remove(3));
        list.display();
        System.out.println("list.remove(3) = " + list.remove(3));


        System.out.println("list.removeFirst() = " + list.removeFirst());
        list.display();
        System.out.println();
    }
}
