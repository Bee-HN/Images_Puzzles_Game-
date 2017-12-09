package com.hoang_nguyen.courseproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    boolean isAlbum = false;
    boolean isCamera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Puzzle Time");
    }//end of create.

    public void resumeGame (View view){
    }//end of resume game button


    public void takePic (View view) {
        //take a picture fucntion.
        isCamera = true;
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("checkPic", isCamera);
        startActivity(intent);

    }//end of takePic
    public void lordPicture(View view){

        isAlbum = true;
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("checkAlbum", isAlbum);
        startActivity(intent);
    }//end of lord picture method.

    public void help (View view){
        //Go to help activity to explain how to play the puzzle game.
        Intent help = new Intent(MainActivity.this, help.class);
        startActivity(help);

    }//end of help.

    public void exit (View view){



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
