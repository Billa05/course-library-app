package com.example.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnshowallcource, btnwishlist, btnprogress, btnCompleted, btnfavourites, btnaboutus;
    private ImageView catlogo;
    private Drawable catdialogicon;
    private TextView textappname, txtlincense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intviews();

        btnshowallcource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllcourseActivity.class);
                startActivity(intent);
            }
        });

        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadCourses.class);
                startActivity(intent);
            }
        });

        btnfavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavCourses.class);
                startActivity(intent);
            }
        });

        btnprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentReading.class);
                startActivity(intent);
            }
        });

        btnwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Wishlist.class);
                startActivity(intent);
            }
        });

        btnaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hellu I am Billa");
                builder.setMessage(" I have completed the 15hrs course of freecodecamp and made this app." +
                        " Thank you for the quality content freecodecamp. Next goal is to learn UI/UX & Databases. ");
                builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });

        Utils.getInstance(this);
    }

    private void intviews(){
        btnshowallcource = findViewById(R.id.btnshowallcource);
        btnwishlist = findViewById(R.id.btnwishlist);
        btnprogress = findViewById(R.id.btnprogress);
        btnCompleted = findViewById(R.id.btnCompleted);
        btnfavourites = findViewById(R.id.btnfavourites);
        btnaboutus = findViewById(R.id.btnaboutus);

    }
}