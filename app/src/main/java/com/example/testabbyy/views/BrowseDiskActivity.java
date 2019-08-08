package com.example.testabbyy.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.testabbyy.R;
import com.example.testabbyy.entities.disks.Disk;

import static com.example.testabbyy.R.string.product_information;

public class BrowseDiskActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView costTextView;
    private TextView barCodeTextView;
    private TextView contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_disk);

        Disk disk = (Disk) getIntent().getSerializableExtra("item");

        createViews();
        fillViews(disk);

    }

    public void createViews(){
        nameTextView = findViewById(R.id.disk_product_name);
        costTextView = findViewById(R.id.disk_product_cost);
        barCodeTextView = findViewById(R.id.disk_product_code);
        contentTextView = findViewById(R.id.disk_product_content);
        Toolbar toolbar = findViewById(R.id.browse_toolbar);
        toolbar.setTitle(product_information);
        setSupportActionBar(toolbar);
    }

    public void fillViews(Disk disk){
        nameTextView.setText(disk.getName());
        costTextView.setText(String.valueOf(disk.getCost()));
        barCodeTextView.setText(String.valueOf(disk.getBarCode()));
        contentTextView.setText(disk.getContent().toString());
    }
}
