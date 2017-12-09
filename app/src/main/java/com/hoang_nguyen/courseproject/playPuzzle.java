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
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class playPuzzle extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;

    Intent intent;
    ImageView imageView;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_puzzle);
        this.setTitle("Puzzle Time");

        //imageView = (ImageView) findViewById(R.id.setImage);

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

        if(resultCode == RESULT_OK) {
          //  imageView = (ImageView) findViewById(R.id.setImage);
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE:
                    image = (Bitmap) data.getExtras().get("data");

                    //Eric: Please don't delete this comment.
                    //    imageView.setImageBitmap(image);
                    createPuzzle(image);//create the game.
                    break;

                case REQUEST_TAKE_ALBUM:

                    Uri imageUri = data.getData();
                    InputStream inputStream;

                    try {
                        inputStream = getContentResolver().openInputStream(imageUri);

                        Bitmap image = BitmapFactory.decodeStream(inputStream);

                        //Eric: Please don't delete this comment.
                        //imageView.setImageBitmap(image);

                        createPuzzle(image);//create the game.
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }else{
            finish();
        }

    }//end of onActivityResult.

    public void createPuzzle(Bitmap image){

        int index = 0;
        ImageButton imgBtn [] = new ImageButton[29];//creating size 5 x 6 image button array.

        //initialize all button with their ID.
        imgBtn[0] = (ImageButton) findViewById(R.id.imageButton);
        imgBtn[1] = (ImageButton) findViewById(R.id.imageButton2);
        imgBtn[2] = (ImageButton) findViewById(R.id.imageButton3);
        imgBtn[3] = (ImageButton) findViewById(R.id.imageButton4);
        imgBtn[4] = (ImageButton) findViewById(R.id.imageButton5);
        imgBtn[5] = (ImageButton) findViewById(R.id.imageButton6);
        imgBtn[6] = (ImageButton) findViewById(R.id.imageButton7);
        imgBtn[7] = (ImageButton) findViewById(R.id.imageButton8);
        imgBtn[8] = (ImageButton) findViewById(R.id.imageButton9);
        imgBtn[9] = (ImageButton) findViewById(R.id.imageButton10);
        imgBtn[10] = (ImageButton) findViewById(R.id.imageButton11);
        imgBtn[11] = (ImageButton) findViewById(R.id.imageButton12);
        imgBtn[12] = (ImageButton) findViewById(R.id.imageButton13);
        imgBtn[13] = (ImageButton) findViewById(R.id.imageButton14);
        imgBtn[14] = (ImageButton) findViewById(R.id.imageButton15);
        imgBtn[15] = (ImageButton) findViewById(R.id.imageButton16);
        imgBtn[16] = (ImageButton) findViewById(R.id.imageButton17);
        imgBtn[17] = (ImageButton) findViewById(R.id.imageButton18);
        imgBtn[18] = (ImageButton) findViewById(R.id.imageButton19);
        imgBtn[19] = (ImageButton) findViewById(R.id.imageButton20);
        imgBtn[20] = (ImageButton) findViewById(R.id.imageButton21);
        imgBtn[21] = (ImageButton) findViewById(R.id.imageButton22);
        imgBtn[22] = (ImageButton) findViewById(R.id.imageButton23);
        imgBtn[23] = (ImageButton) findViewById(R.id.imageButton24);
        imgBtn[24] = (ImageButton) findViewById(R.id.imageButton25);
        imgBtn[25] = (ImageButton) findViewById(R.id.imageButton26);
        imgBtn[26] = (ImageButton) findViewById(R.id.imageButton27);
        imgBtn[27] = (ImageButton) findViewById(R.id.imageButton28);
        imgBtn[28] = (ImageButton) findViewById(R.id.imageButton29);
        imgBtn[29] = (ImageButton) findViewById(R.id.imageButton30);


        while(imgBtn.length!= index){

            imgBtn[index].setOnClickListener(click);

        }

    }//end of createPuzzle

    public View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View view){

        }

    };

    public void SavePuzzle(View view) {

    }//end of SavePuzzle

    public void CheckPuzzle(View view) {

    }//end of checkPuzzle


    public void ResetPuzzle(View view) {


    }
    public void BackToHome(View view) {

        AlertDialog.Builder altdial = new AlertDialog.Builder(playPuzzle.this);
        altdial.setMessage("Do you want to Go Back To Home Screen").setCancelable(false)
                .setPositiveButton("Save and Go Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //   SavePuzzle(view);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });

        AlertDialog alert = altdial.create();
        alert.setTitle("Save while Quitting Puzzle Game");
        alert.show();
    }


    public void QuitPuzzle(View view) {

                AlertDialog.Builder altdial = new AlertDialog.Builder(playPuzzle.this);
                altdial.setMessage("Do you want to Save puzzle while Quitting?").setCancelable(false)
                        .setPositiveButton("Save and Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                             //   SavePuzzle(view);
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                              System.exit(0);
                            }
                        });
                AlertDialog alert = altdial.create();
                alert.setTitle("Save while Quitting Puzzle Game");
                alert.show();
    }
}