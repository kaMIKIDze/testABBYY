package com.example.testabbyy.entities.disks;

import com.example.testabbyy.entities.Product;

public abstract class Disk extends Product  {

    public enum Content {
        NOTHING("Ничего"),
        MUSIC("Музыка"),
        VIDEO("Видео"),
        SOFTWARE("ПО");

        private String title;

        Content(String title) {
            setTitle(title);
        }

        @Override
        public String toString() {
            return title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    protected Content content;

    protected Disk(String name, double cost, long barCode, Content content) {
        super(name, cost, barCode);
        setContent(content);
        setSubcategory(content.getTitle());
    }

    protected Disk() {
        super();
        setContent(Content.NOTHING);
        setSubcategory(content.getTitle());
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
