package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentReading extends AppCompatActivity {

    private RecyclerView recyclerviewCurresntreading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_reading);

        recyclerviewCurresntreading = findViewById(R.id.recyclerviewCurresntreading);
        coursescontent adapter = new coursescontent(this);
        recyclerviewCurresntreading.setAdapter(adapter);
        recyclerviewCurresntreading.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setMorecontents(Utils.getInstance(this).getOngoingcourse());
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}