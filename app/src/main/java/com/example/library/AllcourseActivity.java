package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllcourseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcourse);

        recyclerView = findViewById(R.id.recyclerview);


        coursescontent view = new coursescontent(this);

        recyclerView.setAdapter(view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        view.setMorecontents(Utils.getInstance(this).getAllcources());
    }
}