package ru.alexkrasnovasoft.algorithms.lesson5;

public class Thing implements Comparable<Thing> {
    private String name;
    private Integer mass;
    private Integer price;

    public Thing(String name, Integer mass, Integer price) {
        this.name = name;
        this.mass = mass;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getMass() {
        return mass;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Thing thing) {
        if (this == thing || this.equals(thing)) {
            return 0;
        }
        if (name.compareTo(thing.getName())>0) {
            return 1;
        } else if (name.compareTo(thing.getName())<0) {
            return -1;
        } else if (price > thing.getPrice()) {
            return 1;
        } else if (price < thing.getPrice()) {
            return -1;
        } else if (mass > thing.getMass()) {
            return 1;
        } else if (mass < thing.getMass()) {
            return -1;
        } else {
            return 0;
        }
    }
}
