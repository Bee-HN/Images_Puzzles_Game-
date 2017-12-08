package com.hoang_nguyen.courseproject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    boolean isAlbum = false;
    boolean isCamera = false;

    public static Button quitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end of create.

    public void resumeGame (View view){
    }//end of resume game button

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

        quitbtn = (Button)findViewById(R.id.quitButton);
        quitbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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

                }
            });



    }//end of exit.


    public void takePic (View view) {
    //take a picture fucntion.
        isCamera = true;
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("checkPic", isCamera);
        startActivity(intent);

    }//end of takePic


}//end of class.
