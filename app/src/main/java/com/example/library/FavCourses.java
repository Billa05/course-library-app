package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavCourses extends AppCompatActivity {

    private RecyclerView recyclerviewFavCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_courses);

        recyclerviewFavCourses = findViewById(R.id.recyclerviewFavCourses);
        coursescontent adapter = new coursescontent(this);
        recyclerviewFavCourses.setAdapter(adapter);
        recyclerviewFavCourses.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setMorecontents(Utils.getInstance(this).getFavcources());
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}