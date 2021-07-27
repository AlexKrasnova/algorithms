package ru.alexkrasnovasoft.algorithms.lesson2.sort;

import java.util.Objects;

public class Notebook implements Comparable<Notebook> {
    private Integer id;
    private Integer price;
    private Integer ram;
    private String brand;

    public Notebook(Integer id, Integer price, Integer ram, String brand) {
        this.id = id;
        this.price = price;
        this.ram = ram;
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getRam() {
        return ram;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return price.equals(notebook.price) &&
                ram.equals(notebook.ram) &&
                brand.equals(notebook.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ram, brand);
    }

    @Override
    public int compareTo(Notebook notebook) {
        if (this == notebook || this.equals(notebook)) {
            return 0;
        }
        if (price > notebook.getPrice()) {
            return 1;
        } else if (price < notebook.getPrice()) {
            return -1;
        } else if (ram > notebook.getRam()) {
            return 1;
        } else if (ram < notebook.getRam()) {
            return -1;
        } else if (brand.compareTo(notebook.getBrand()) > 0) {
            return 1;
        } else if (brand.compareTo(notebook.getBrand()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", price=" + price +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                '}';
    }
}
