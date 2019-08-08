package com.example.testabbyy.entities.books;

public class EsotericBook extends Book {

    private int minAgeOfReader;

    public EsotericBook() {
        super();
        setMinAgeOfReader(0);
    }

    public EsotericBook(String name, double cost, long barCode, int numPage, int minAgeOfReader) {
        super(name, cost, barCode, numPage);
        setMinAgeOfReader(minAgeOfReader);
    }

    public int getMinAgeOfReader() {
        return minAgeOfReader;
    }

    public void setMinAgeOfReader(int minAgeOfReader) {
        this.minAgeOfReader = minAgeOfReader;
    }

    @Override
    public void setSubcategory() {
        super.setSubcategory();
        this.subcategory = "Эзотерика";
    }
}
