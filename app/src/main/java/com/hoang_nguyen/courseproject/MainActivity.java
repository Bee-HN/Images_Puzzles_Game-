package com.hoang_nguyen.courseproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    static final int REQUEST_IMAGE_CROP = 3;
    static final int REQUEST_TAKE_PHOTO = 4;

    Intent intent;
    Uri photoURI, albumURI; // URI for photo and album.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }//end of create.

    public void resumeGame (View view){}//end of resume game button

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
    //take a picture fucntion.

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePictureIntent.resolveActivity(getPackageManager()) != null){

            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }//end of if statement.

    }//end of takePic


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){


            case REQUEST_IMAGE_CAPTURE:
                //after taking picture, grab a taken photo URI
                //then start playPuzzle class.

                Bitmap photo = (Bitmap) data.getExtras().get("Data");
                intent = new Intent(this, playPuzzle.class);
                intent.putExtra("image", photo);
                startActivity(intent);

                break;


            case REQUEST_TAKE_ALBUM:
                //lord an image from the album.

                break;
            case REQUEST_TAKE_PHOTO:

                break;

        }

    }//end of onActivityResult.

}//end of class.
