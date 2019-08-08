package com.example.testabbyy.entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String name;
    protected double cost;
    protected long barCode;

    protected String subcategory = "NULL"; // для отображения в списке

    protected Product() {
        setName("NULL");
        setBarCode(123456789012L);
    }

    protected Product(String name, double cost, long barCode) {
        setName(name);
        setCost(cost);
        setBarCode(barCode);
        setSubcategory();
    }

    public void setSubcategory() {
        this.subcategory = "NULL";
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public long getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }
}
