package com.hoang_nguyen.courseproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class playPuzzle extends AppCompatActivity {

    Intent intent;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_puzzle);

        this.setTitle("Puzzle Time");


       // imageView.setImageURI(Uri.parse(intent.getStringExtra("image")));

    }//end of on Create


}
