package com.hoang_nguyen.courseproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class help extends AppCompatActivity {

    public static Button Authors;
    public static Button HowTo;
    public static Button Tips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.setTitle("Puzzle Time");
    }

    public void TipsAndTricks(View view) {


                AlertDialog.Builder altdial = new AlertDialog.Builder(help.this);
                altdial.setMessage("Some Tips and Tricks\n\n" +
                        "1. Try Solving the border").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("Tips and Tricks");
                alert.show();

    }

    public void HowTo(View view) {

                AlertDialog.Builder altdial = new AlertDialog.Builder(help.this);
                altdial.setMessage("How to play this game? Simple!\n\n" +
                        "1. Either open/take a picture or if you have played and saved game click Resume\n" +
                        "2. After choosing your picture, the picture will look in a scrambled state\n" +
                        "3. To solve, click a tile, and click where you want to place it\n" +
                        "4. Buttons on the bottom of puzzle screen is for convenience").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("How to Play");
                alert.show();

    }

    public void Authors(View view) {

                AlertDialog.Builder altdial = new AlertDialog.Builder(help.this);
                altdial.setMessage("This Puzzle App is created by the following GMU students:\nSeho Lee\nEmmanuel Meneses\nHoang Nguyen").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("Authors of Puzzle App");
                alert.show();


    }
}
