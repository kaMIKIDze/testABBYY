package com.example.testabbyy.entities.books;

import com.example.testabbyy.entities.Product;

public abstract class Book extends Product {
    protected int numberOfPage;

    protected Book() {
        super();
    }

    protected Book(String name, double cost, long barCode, int numPage) {
        super(name, cost, barCode);
        setNumberOfPage(numPage);
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
}
