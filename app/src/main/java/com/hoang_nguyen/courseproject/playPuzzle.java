package com.hoang_nguyen.courseproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class playPuzzle extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    static final int REQUEST_IMAGE_CROP = 3;
    static final int REQUEST_TAKE_PHOTO = 4;


    public static Button quitbtn;

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
            File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String pictureDirectoryPath = pictureDirectory.getPath();
            // finally, get a URI representation
            Uri data = Uri.parse(pictureDirectoryPath);

            // set the data and type.  Get all image types.
            intent.setDataAndType(data, "image/*");


            startActivityForResult(intent, REQUEST_TAKE_ALBUM);
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

                Uri imageUri = data.getData();
                InputStream inputStream;

                try{
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    imageView.setImageBitmap(image);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }

                break;
            case REQUEST_TAKE_PHOTO:
                break;

        }

    }//end of onActivityResult.

    public void SavePuzzle(View view) {
    }

    public void CheckPuzzle(View view) {
    }

    public void BackToHome(View view) {
    }

    public void ResetPuzzle(View view) {
    }

    public void QuitPuzzle(View view) {
        quitbtn = (Button)findViewById(R.id.QuitBtn);
        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {//Make be an error with final. May cause crash?
                AlertDialog.Builder altdial = new AlertDialog.Builder(playPuzzle.this);
                altdial.setMessage("Do you want to Save puzzle while Quitting?").setCancelable(false)
                        .setPositiveButton("Save and Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SavePuzzle(v);
                                finish();
                            }
                        })
                        .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("Save while Quitting Puzzle Game");
                alert.show();

            }
        });
    }
}