package com.example.testabbyy.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.testabbyy.R;
import com.example.testabbyy.entities.books.Book;
import com.example.testabbyy.entities.books.CookingBook;
import com.example.testabbyy.entities.books.EsotericBook;
import com.example.testabbyy.entities.books.ProgrammingBook;

import static com.example.testabbyy.R.string.product_information;

public class BrowseBookActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView costTextView;
    private TextView barCodeTextView;
    private TextView numberPageTextView;
    private TextView universalBookTextView;
    private TextView universalBookTextTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_browse_book);

        Book book = (Book) getIntent().getSerializableExtra("item");

        createViews();
        fillViews(book);
    }

    public void createViews(){
        nameTextView = findViewById(R.id.book_product_name);
        costTextView = findViewById(R.id.book_product_cost);
        barCodeTextView = findViewById(R.id.book_product_code);
        numberPageTextView = findViewById(R.id.book_product_number_page);
        universalBookTextTextView = findViewById(R.id.book_universal_field_text);
        universalBookTextView = findViewById(R.id.book_universal_field);
        Toolbar toolbar = findViewById(R.id.browse_toolbar);
        toolbar.setTitle(product_information);
        setSupportActionBar(toolbar);
    }

    public void fillViews(Book book){
        nameTextView.setText(book.getName());
        costTextView.setText(String.valueOf(book.getCost()));
        barCodeTextView.setText(String.valueOf(book.getBarCode()));
        numberPageTextView.setText(String.valueOf(book.getNumberOfPage()));

        switch (book.getClass().getSimpleName()){
            case ("EsotericBook"):
                universalBookTextTextView.setText(getString(R.string.age_limitation));
                EsotericBook esotericBook = (EsotericBook) book;
                universalBookTextView.setText(String.valueOf(esotericBook.getMinAgeOfReader()));
                break;

            case ("CookingBook"):
                universalBookTextTextView.setText(getString(R.string.basic_ingredient));
                CookingBook cookingBook = (CookingBook) book;
                universalBookTextView.setText(cookingBook.getBasicIngredient());
                break;

            case ("ProgrammingBook"):
                universalBookTextTextView.setText(getString(R.string.programming_language));
                ProgrammingBook programmingBook = (ProgrammingBook) book;
                universalBookTextView.setText(programmingBook.getProgLanguage());
                break;

            default:
                break;
        }

    }
}
