package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyReadCourses extends AppCompatActivity {

    private RecyclerView recviewalreadyreadcourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_courses);

        recviewalreadyreadcourse = findViewById(R.id.recviewalreadyreadcourse);
        coursescontent adapter = new coursescontent(this);
        recviewalreadyreadcourse.setAdapter(adapter);
        recviewalreadyreadcourse.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setMorecontents(Utils.getInstance(this).getCompletedcources());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}