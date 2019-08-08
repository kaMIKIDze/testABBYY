package com.example.testabbyy.entities.books;

public class ProgrammingBook extends Book {
    private String progLanguage;


    public ProgrammingBook() {
        super();
        setProgLanguage("NULL");
    }

    public ProgrammingBook(String name, double cost, long barCode, int numPage, String progLang) {
        super(name, cost, barCode, numPage);
        setProgLanguage(progLang);
    }

    @Override
    public void setSubcategory() {
        super.setSubcategory();
        this.subcategory = "Программирование";
    }

    public String getProgLanguage() {
        return progLanguage;
    }

    public void setProgLanguage(String progLanguage) {
        this.progLanguage = progLanguage;
    }
}
