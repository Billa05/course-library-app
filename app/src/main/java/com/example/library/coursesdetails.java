package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class coursesdetails extends AppCompatActivity {

    private TextView txtnameofthebook, txtnameofthecreator, txtdurationofcourse;
    private ImageView imageView2;
    private Button btncurrentlyreading, btnaddtowishlist, btncompleted, btnaddtofavourites, btnweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesdetails);

        btnweb = findViewById(R.id.btnweb);

        intviews();

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra("bookId",-1 );
            if (bookId != -1){
                contentofallcources incomingcourse = Utils.getInstance(this).getcourseid(bookId);
                if (null != incomingcourse){
                    setData(incomingcourse);

                    handelalreadyreadcourse(incomingcourse);
                    handelWhishlist(incomingcourse);
                    handelcurrentlyreading(incomingcourse);
                    handelfavcourse(incomingcourse);
                }
            }
        }
    }

    private void handelfavcourse(final contentofallcources contentofallcources1) {
        ArrayList<contentofallcources> favcources = Utils.getInstance(this).getFavcources();

        boolean ExistsInFavCourse = false;

        for (contentofallcources c: favcources){
            if (c.getId() == contentofallcources1.getId()) {
                ExistsInFavCourse = true;
            }
        }
        if (ExistsInFavCourse){
            btnaddtofavourites.setEnabled(false);
        }else {
            btnaddtofavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(coursesdetails.this).AddToFavcourse(contentofallcources1)){
                        Toast.makeText(coursesdetails.this, "Course Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(coursesdetails.this, FavCourses.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(coursesdetails.this, "Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelcurrentlyreading(final contentofallcources contentofallcources1) {
        ArrayList<contentofallcources> ongoingcourse = Utils.getInstance(this).getOngoingcourse();

        boolean ExistsIncurrentlyreading = false;

        for (contentofallcources c: ongoingcourse){
            if (c.getId() == contentofallcources1.getId()) {
                ExistsIncurrentlyreading = true;
            }
        }
        if (ExistsIncurrentlyreading){
            btncurrentlyreading.setEnabled(false);
        }else {
            btncurrentlyreading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(coursesdetails.this).AddToCurrentlyReading(contentofallcources1)){
                        Toast.makeText(coursesdetails.this, "Course Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(coursesdetails.this, CurrentReading.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(coursesdetails.this, "Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelWhishlist(final contentofallcources contentofallcourcese1) {
        ArrayList<contentofallcources> Whishlist = Utils.getInstance(this).getWhislist();

        boolean ExistsInWhishlist = false;

        for (contentofallcources c: Whishlist){
            if (c.getId() == contentofallcourcese1.getId()) {
                ExistsInWhishlist = true;
            }
        }
        if (ExistsInWhishlist){
            btnaddtowishlist.setEnabled(false);
        }else {
            btnaddtowishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(coursesdetails.this).AddToWhislist(contentofallcourcese1)){
                        Toast.makeText(coursesdetails.this, "Course Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(coursesdetails.this, Wishlist.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(coursesdetails.this, "Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handelalreadyreadcourse(contentofallcources contentofallcources1){
        ArrayList<contentofallcources> alreadyreadcourse = Utils.getInstance(this).getCompletedcources();

        boolean ExistsInAlreadyReadBook = false;

        for (contentofallcources c: alreadyreadcourse){
            if (c.getId() == contentofallcources1.getId()) {
                ExistsInAlreadyReadBook = true;
            }
        }
        if (ExistsInAlreadyReadBook){
            btncompleted.setEnabled(false);
        }else {
            btncompleted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(coursesdetails.this).AddtoAlreadyReadCourse(contentofallcources1)){
                        Toast.makeText(coursesdetails.this, "Course Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(coursesdetails.this, AlreadyReadCourses.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(coursesdetails.this, "Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(contentofallcources contentofallcources){
        txtnameofthebook.setText(contentofallcources.getName());
        txtnameofthecreator.setText(contentofallcources.getCreator());
        txtdurationofcourse.setText(contentofallcources.getDuration());

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(contentofallcources.getUrl());
            }
        });

        Glide.with(this)
                .asBitmap().load(contentofallcources.getImageUrl())
                .into(imageView2);
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void intviews(){
        txtnameofthebook = findViewById(R.id.txtnameofthebook);
        txtnameofthecreator = findViewById(R.id.txtnameofthecreator);
        txtdurationofcourse = findViewById(R.id.txtdurationofcourse);

        btncurrentlyreading = findViewById(R.id.btncurrentlyreading);
        btnaddtowishlist = findViewById(R.id.btnaddtowishlist);
        btncompleted = findViewById(R.id.btncompleted);
        btnaddtofavourites = findViewById(R.id.btnaddtofavourites);

        imageView2 = findViewById(R.id.imageView2);

    }


}