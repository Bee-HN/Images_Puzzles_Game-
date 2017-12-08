package com.hoang_nguyen.courseproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;

public class playPuzzle extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    static final int REQUEST_IMAGE_CROP = 3;
    static final int REQUEST_TAKE_PHOTO = 4;

    Intent intent;
    ImageView imageView;
    Bitmap image;

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
            intent = new Intent(Intent.ACTION_PICK);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), REQUEST_TAKE_ALBUM);
        }

        if (isCamera) {
            //if user select taking picture, then run camera.
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }//end of takePic

        }

    }//end of on Create

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        imageView = (ImageView) findViewById(R.id.setImage);

        switch (requestCode){
            case REQUEST_IMAGE_CAPTURE:
                image = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(image);
                break;

            case REQUEST_TAKE_ALBUM:
                Uri imgUri = data.getData();
                String imagePath = getRealPathFromURI(imgUri);
                ExifInterface exit = null;

                try{
                    exit = new ExifInterface(imagePath);

                }catch (IOException e){
                    e.printStackTrace();
                }

                int exitOrienation = exit.getAttributeInt(ExifInterface.TAG_APERTURE_VALUE, ExifInterface.ORIENTATION_NORMAL);
                int exitDegree = exifOreientationToDegrees(exitOrienation);

                image = BitmapFactory.decodeFile(imagePath);
                imageView.setImageBitmap(image);
                break;
            case REQUEST_TAKE_PHOTO:
                break;

        }

    }//end of onActivityResult.

    public String getRealPathFromURI(Uri contentUri){

        int index = 0;
        String [] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);

        if(cursor.moveToFirst()){
            index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        }
        return cursor.getString(index);
    }

    public int exifOreientationToDegrees (int exif){

        if(exif == ExifInterface.ORIENTATION_ROTATE_90){
            return 90;
        }else if(exif == ExifInterface.ORIENTATION_ROTATE_180){
            return 180;
        }else if (exif == ExifInterface.ORIENTATION_ROTATE_270){
            return 270;
        }
        return 0;
    }

}