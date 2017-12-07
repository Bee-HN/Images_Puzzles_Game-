package com.hoang_nguyen.courseproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    static final int REQUEST_IMAGE_CROP = 3;
    static final int REQUEST_TAKE_PHOTO = 4;

    ImageView mImageView = null;
    Intent intent;
    Uri photoURI, albumURI; // URI for photo and album.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }//end of create.

    public void startGame(Uri image){
        //starting the playPuzzle activity.
        intent = new Intent(this, playPuzzle.class);
        intent.putExtra("image", image);
        startActivity(intent);
    }
    public void resumeGame (View view){

    }//end of resume game button

    public void lordPicture(View view){
    //Open a photo album in the device and user can see pictures.
    //create new intent to access the photo album

        intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_TAKE_ALBUM);

    }//end of lord picture method.

    public void help (View view){
        //Go to help activity to explain how to play the puzzle game.
        Intent help = new Intent(MainActivity.this, help.class);
        startActivity(help);

    }//end of help.

    public void exit (View view){
        System.exit(0);
    }//end of exit.


    public void takePic (View view) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePictureIntent.resolveActivity(getPackageManager()) != null){

//            File photo = null;
//            if (photo!=null){
//
//                photoURI = Uri.fromFile(photo);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
//            }
     startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);


        }//end of if statement.


    }//end of takePic


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            mImageView.setImageBitmap(imageBitmap);

            /*
                Author: Seho Lee
                After taking the picture and call startGame subroutine function to start
                playPuzzle class.
             */
            Uri image ;
            image = data.getData();
            startGame(image);

        }//end of if statement

    }//end of onActivityResult.

}//end of class.
