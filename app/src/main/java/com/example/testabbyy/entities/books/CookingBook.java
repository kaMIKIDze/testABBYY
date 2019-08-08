package com.example.testabbyy.entities.books;

public class CookingBook extends Book {

    private String basicIngredient;

    public CookingBook() {
        super();
        setBasicIngredient("NULL");
    }

    public CookingBook(String name, double cost, long barCode, int numPage, String basicIngredient) {
        super(name, cost, barCode, numPage);
        setBasicIngredient(basicIngredient);
    }

    public String getBasicIngredient() {
        return basicIngredient;
    }

    public void setBasicIngredient(String basicIngredient) {
        this.basicIngredient = basicIngredient;
    }

    @Override
    public void setSubcategory() {
        super.setSubcategory();
        this.subcategory = "Кулинария";
    }
}
