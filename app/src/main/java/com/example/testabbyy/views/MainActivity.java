package com.example.testabbyy.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.testabbyy.R;
import com.example.testabbyy.entities.books.Book;
import com.example.testabbyy.entities.books.CookingBook;
import com.example.testabbyy.entities.books.EsotericBook;
import com.example.testabbyy.entities.books.ProgrammingBook;
import com.example.testabbyy.entities.disks.Disk;
import com.example.testabbyy.entities.disks.DiskCD;
import com.example.testabbyy.entities.disks.DiskDVD;

import java.util.ArrayList;
import java.util.List;

import static com.example.testabbyy.R.string.product_information;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBooks;
    private RecyclerView.Adapter mAdapterBooks;
    private RecyclerView.LayoutManager layoutManagerBooks;
    private RecyclerView recyclerViewDisks;
    private RecyclerView.Adapter mAdapterDisks;
    private RecyclerView.LayoutManager layoutManagerDisks;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecyclerView(setBook(), setDisk());

        toolbar = findViewById(R.id.browse_toolbar);
        toolbar.setTitle(product_information);
        setSupportActionBar(toolbar);

    }

    public void createRecyclerView(List<Book> books, final List<Disk> disks) {
        recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        layoutManagerBooks = new LinearLayoutManager(this);
        recyclerViewBooks.setLayoutManager(layoutManagerBooks);
        mAdapterBooks = new BooksAdapter(books, new BookAdapterClickListener() {

            @Override
            public void onItemClick(Book item) {
                Intent i = new Intent(MainActivity.this, BrowseBookActivity.class);
                i.putExtra("item", item);
                startActivityForResult(i, 1);
            }
        });
        recyclerViewBooks.setAdapter(mAdapterBooks);

        recyclerViewDisks = findViewById(R.id.recyclerViewDisk);
        layoutManagerDisks = new LinearLayoutManager(this);
        recyclerViewDisks.setLayoutManager(layoutManagerDisks);
        mAdapterDisks = new DisksAdapter(disks, new DiskAdapterClickListener() {
            @Override
            public void onItemClick(Disk item) {
                Intent i = new Intent(MainActivity.this, BrowseDiskActivity.class);
                i.putExtra("item", item);
                startActivityForResult(i, 1);
            }
        });
        recyclerViewDisks.setAdapter(mAdapterDisks);

    }

    public List<Book> setBook() {
        List<Book> books = new ArrayList<>();

        books.add(new ProgrammingBook("Самоучитель по Java", 857.9, 152346781520L, 547, "Java"));
        books.add(new ProgrammingBook("C++ для детей", 569.2, 142365987120L, 325, "C++"));
        books.add(new EsotericBook("Магия для Магглов", 436.4, 142365897452L, 245, 12));
        books.add(new CookingBook("Готовим с Гордоном Рамзи", 1200.5, 142356785412L, 240, "Бекон"));
        books.add(new CookingBook("100 способов приготовления яиц", 450, 423651523698L, 110, "Яйцо"));

        return books;
    }

    public List<Disk> setDisk() {
        List<Disk> disks = new ArrayList<>();

        disks.add(new DiskDVD("Фиксики", 100.0, 132546758965L, Disk.Content.VIDEO));
        disks.add(new DiskDVD("Игра Престолов 1 сезон", 125.0, 134567819452L, Disk.Content.VIDEO));
        disks.add(new DiskDVD("Windows 10 Professional", 1600.0, 134567289463L, Disk.Content.SOFTWARE));
        disks.add(new DiskCD("Manowar", 420.0, 132445698756L, Disk.Content.MUSIC));
        disks.add(new DiskCD("Sabaton", 480.0, 132564789542L, Disk.Content.MUSIC));

        return disks;
    }

}
