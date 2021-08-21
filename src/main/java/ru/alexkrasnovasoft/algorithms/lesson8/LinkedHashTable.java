package ru.alexkrasnovasoft.algorithms.lesson8;

import java.util.HashMap;

public class LinkedHashTable<K, V> implements HashTable<K, V> {

    private LinkedItem<K, V>[] data;
    private int size;

    public LinkedHashTable(int initialCapacity) {
        data = new LinkedItem[initialCapacity * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new LinkedItem<>(key, value);
            size++;
            return true;
        }
        LinkedItem<K, V> current = data[index];
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new LinkedItem<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        }
        LinkedItem<K, V> current = data[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        }
        LinkedItem<K, V> current = data[index];
        LinkedItem<K, V> previous = null;
        LinkedItem<K, V> result;
        while (current != null) {
            if (current.getKey().equals(key)) {
                result = current;
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    data[index] = current.getNext();
                }
                size--;
                return result.getValue();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
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
    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            String str;
            if (data[i] == null) {
                str = null;
            } else
                str = data[i].getStringChain();
            System.out.printf("%d = [%s]%n", i, str);
        }
        System.out.println("----------------------");
    }

    static class LinkedItem<K, V> {

        private final K key;
        private V value;
        private LinkedItem<K, V> next;

        public LinkedItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public LinkedItem<K, V> getNext() {
            return next;
        }

        public void setNext(LinkedItem<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkedItem{" + "key=" + key + ", value=" + value + '}';
        }

        public String getStringChain() {
            StringBuilder sb = new StringBuilder();
            LinkedItem<K, V> current = this;
            while (current != null) {
                sb.append(current.toString()).append("} -> ");
                current = current.getNext();
            }
            if (sb.length() > 3) {
                sb.setLength(sb.length() - 4);
            }
            return sb.toString();
        }
    }
}

