package ru.alexkrasnovasoft.algorithms.lesson3;

import ru.alexkrasnovasoft.algorithms.lesson3.queue.ArrayQueueImpl;
import ru.alexkrasnovasoft.algorithms.lesson3.queue.Queue;
import ru.alexkrasnovasoft.algorithms.lesson3.search.MyArray;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        testQueue();
        testSearch();
    }

    private static void testQueue() {
        System.out.println("Тестирование очереди:");
        Queue queue = new ArrayQueueImpl(5);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.display();

        System.out.println(queue.peek());
        queue.display();

        System.out.println(queue.poll());
        queue.display();

        queue.add(5);
        queue.add(6);
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
