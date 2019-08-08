package com.example.testabbyy.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testabbyy.R;

import com.example.testabbyy.entities.books.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private List<Book> books;
    private BookAdapterClickListener clickListener;

    BooksAdapter(List<Book> books, BookAdapterClickListener clickListener){
        this.books = books;
        this.clickListener = clickListener;
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView bookName;
        TextView subcategoryName;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.name_product);
            subcategoryName = itemView.findViewById(R.id.subcategory_name);
        }

        void bind(int pos){
            final Book book = books.get(pos);
            bookName.setText(book.getName());
            subcategoryName.setText(book.getSubcategory());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(book);
                }
            });
        }
    }

    @NonNull
    @Override
    public BooksAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card,parent,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.BookViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
