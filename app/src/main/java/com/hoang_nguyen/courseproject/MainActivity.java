package com.hoang_nguyen.courseproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
    Authors: Seho Lee and G# 00984821
             Emmanuel Menases and G#

             MainActivity:

             MainActivity class simply provides some buttons such as help, take picture,
             open album, and exit in order to run the puzzle game.

 */
public class MainActivity extends AppCompatActivity {

    Intent intent;
    boolean isAlbum = false;//determine user selsect is album
    boolean isCamera = false;//determine user select take picture.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Puzzle Time");

    }//end of create.

    public void takePic (View view) {
    //If user select "Take Picture" then,
    //playPuzzle class will activate Camera function.
        isCamera = true;//set false to true.
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("checkPic", isCamera);//passing boolean value.
        startActivity(intent);//start playPuzzle class.

    }//end of takePic
    public void lordPicture(View view){
    //if user select "Open picture" then start Puzzle class with isAlbum boolean.
        isAlbum = true;
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("checkAlbum", isAlbum);//passing isAlbum value.
        startActivity(intent);//start playPuzzle class.
    }//end of lord picture method.

    public void help (View view){
        //Go to help activity to explain how to play the puzzle game.
        Intent help = new Intent(MainActivity.this, help.class);
        startActivity(help);

    }//end of help.

    public void exit (View view){
        //Before terminating the game, using alertDialog to give options.
        AlertDialog.Builder altdial = new AlertDialog.Builder(MainActivity.this);
        altdial.setMessage("Do you want to Quit this app?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = altdial.create();
        alert.setTitle("Quitting Puzzle Game");
        alert.show();

    }//end of exit.

}//end of class.
