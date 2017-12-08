package com.hoang_nguyen.courseproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class playPuzzle extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    static final int REQUEST_IMAGE_CROP = 3;
    static final int REQUEST_TAKE_PHOTO = 4;

    Intent intent;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_puzzle);
        this.setTitle("Puzzle Time");

        imageView = (ImageView) findViewById(R.id.setImage);

        boolean isAlbum = getIntent().getExtras().getBoolean("checkAlbum");
        boolean isCamera = getIntent().getExtras().getBoolean("checkPic");

        if (isAlbum) {
        //if user pick album, then load images.
            album();
        }

        if (isCamera) {
            //if user select taking picture, then run camera.
           // camera();
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }//end of takePic

        }


    }//end of on Create

    public void camera() {
        //take a picture fucntion.

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }//end of takePic

    }
    public void album (){
        //Open a photo album in the device and user can see pictures.
        //create new intent to access the photo album
        intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_TAKE_ALBUM);

    }//end of lord picture method.



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        imageView = (ImageView) findViewById(R.id.setImage);

        switch (requestCode){
            case REQUEST_IMAGE_CAPTURE:
                //after taking picture, grab a taken photo URI
                //then start playPuzzle class.
//                Bitmap photo = (Bitmap) data.getExtras().get("Data");
//                intent = new Intent(this, playPuzzle.class);
//                intent.putExtra("image", photo);
//                startActivity(intent);

                imageView.setImageURI(data.getData());

                break;


            case REQUEST_TAKE_ALBUM:
                //lord an image from the album.
                break;
            case REQUEST_TAKE_PHOTO:
                break;

        }

    }//end of onActivityResult.

}