package ru.alexkrasnovasoft.algorithms.lesson4;

import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedList;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.DoublyLinkedListImpl;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.LinkedList;
import ru.alexkrasnovasoft.algorithms.lesson4.lindedlist.SinglyLinkedListImpl;

public class Application {
    public static void main(String[] args) {

        testSinglyLinkedList();
        testDoublyLinkedList();
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

        System.out.println("doublyLinkedList.contains(6) = " + doublyLinkedList.contains(6));
        System.out.println("doublyLinkedList.removeFirst() = " + doublyLinkedList.removeFirst());
        System.out.println("doublyLinkedList.remove(3) = " + doublyLinkedList.remove(3));
        doublyLinkedList.display();
        System.out.println("doublyLinkedList.getLast() = " + doublyLinkedList.getLast());
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
