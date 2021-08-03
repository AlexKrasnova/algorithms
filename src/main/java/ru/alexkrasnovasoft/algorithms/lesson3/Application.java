package ru.alexkrasnovasoft.algorithms.lesson3;

import ru.alexkrasnovasoft.algorithms.lesson3.deque.ArrayDequeImpl;
import ru.alexkrasnovasoft.algorithms.lesson3.deque.Deque;
import ru.alexkrasnovasoft.algorithms.lesson3.queue.ArrayQueueImpl;
import ru.alexkrasnovasoft.algorithms.lesson3.queue.Queue;
import ru.alexkrasnovasoft.algorithms.lesson3.search.MyArray;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {


        testDeque();
        testQueue();
        testSearch();
    }

    private static void testDeque() {
        System.out.println("Тестирование двусторонней очереди:");
        Deque<Integer> deque = new ArrayDequeImpl<Integer>(5);

        deque.insertRight(2);
        deque.insertRight(3);
        deque.display();

        deque.insertLeft(1);
        deque.insertLeft(0);
        deque.display();

        System.out.println("removeLeft() = " + deque.removeLeft());
        deque.display();

        System.out.println("remove() = " + deque.remove());
        deque.display();

        System.out.println("peekLeft() = " + deque.peekLeft());
        System.out.println("peekRight() = " + deque.peekRight());

        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);
        deque.display();

        System.out.println("removeRight() = " + deque.removeRight());
        System.out.println("removeRight() = " + deque.removeRight());
        deque.display();

        System.out.println();
    }

    private static void testQueue() {
        System.out.println("Тестирование очереди:");
        Queue<Integer> queue = new ArrayQueueImpl<Integer>(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.display();

        System.out.println("peekFront() = " + queue.peekFront());
        queue.display();

        System.out.println("remove() = " + queue.remove());
        queue.display();

        queue.insert(5);
        queue.insert(6);
        queue.display();

        System.out.println();
    }

    private static void testSearch() {
        System.out.println("Тестирование поиска: ");
        Integer[] a1 = MyArray.generateArray(10);
        System.out.println(Arrays.toString(a1));
        System.out.println(MyArray.findSkippedElement(a1));
        System.out.println();
    }
}
