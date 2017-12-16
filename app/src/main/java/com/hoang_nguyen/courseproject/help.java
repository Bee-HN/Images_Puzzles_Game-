package com.hoang_nguyen.courseproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
    Authors: Seho Lee and G# 00984821
             Emmanuel Meneses and G#00984596
             Hoang Nguyen and G#00924950
*/

//This activity is a helpful tutorial on how to use the app
// Please read if youre confused
public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.setTitle("Puzzle Time");
    }

    public void TipsAndTricks(View view) {
    //When user select Tip button, using alertDialog to show the tip.
        AlertDialog.Builder altdial = new AlertDialog.Builder(help.this);
        altdial.setMessage("Some Tips and Tricks\n\n" +
                "1. Try Solving the border" +
                "2. Use Check Button to see Original Picture" +
                "3. Git gud").setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = altdial.create();
        alert.setTitle("Tips and Tricks");
        alert.show();


    }//end of TipsAndTricks

    public void HowTo(View view) {
    //when user select How to play button, using alertDialog, to show the how to play.
                AlertDialog.Builder altdial = new AlertDialog.Builder(help.this);
                altdial.setMessage("How to play this game? Simple!\n\n" +
                        "1. Either open/take a picture\n" +
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

    }//end of How to play.

    public void Authors(View view) {
    //when user select authors button, using alertDiaglog to show creaters.
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
    }//end of Authors.
}
