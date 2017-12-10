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

        boolean isAlbum = getIntent().getExtras().getBoolean("checkAlbum");
        boolean isCamera = getIntent().getExtras().getBoolean("checkPic");



        if (isAlbum) {
        //if user pick album, then load images.
            intent = new Intent(Intent.ACTION_PICK);
            File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String pictureDirectoryPath = pictureDirectory.getPath();
            // finally, get a URI representation
            Uri data = Uri.parse(pictureDirectoryPath);
            //createPuzzle(image);
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

//                    ImageButton imgBtn = (ImageButton) findViewById(R.id.btn0);
//
//
//                    Bitmap bMapScaled = Bitmap.createScaledBitmap(image, 720, 1080, true);
//                    Bitmap temp = Bitmap.createBitmap(bMapScaled, 0,0, 180, 180);
//                    imgBtn.setImageBitmap(temp);
//

                    //Eric: Please don't delete this comment.
                    //    imageView.setImageBitmap(image);
                //    createPuzzle(image);//create the game.
                    break;

                case REQUEST_TAKE_ALBUM:

                    Uri imageUri = data.getData();
                    InputStream inputStream;

                    try {
                        inputStream = getContentResolver().openInputStream(imageUri);
                        ImageButton imgBtn = (ImageButton) findViewById(R.id.btn0);
                        Bitmap image = BitmapFactory.decodeStream(inputStream);
                        Bitmap bMapScaled = Bitmap.createScaledBitmap(image, 720, 1080, true);
                        Bitmap temp = Bitmap.createBitmap(bMapScaled, 0,0, 180, 180);
                        imgBtn.setImageBitmap(temp);
                        //Eric: Please don't delete this comment.
                        //imageView.setImageBitmap(image);

                   //     createPuzzle(image);//create the game.
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
        imgBtn[0] = (ImageButton) findViewById(R.id.btn0);
        imgBtn[1] = (ImageButton) findViewById(R.id.btn1);
        imgBtn[2] = (ImageButton) findViewById(R.id.btn2);
        imgBtn[3] = (ImageButton) findViewById(R.id.btn3);
        imgBtn[4] = (ImageButton) findViewById(R.id.btn4);
        imgBtn[5] = (ImageButton) findViewById(R.id.btn5);
        imgBtn[6] = (ImageButton) findViewById(R.id.btn6);
        imgBtn[7] = (ImageButton) findViewById(R.id.btn7);
        imgBtn[8] = (ImageButton) findViewById(R.id.btn8);
        imgBtn[9] = (ImageButton) findViewById(R.id.btn9);
        imgBtn[10] = (ImageButton) findViewById(R.id.btn10);
        imgBtn[11] = (ImageButton) findViewById(R.id.btn11);
        imgBtn[12] = (ImageButton) findViewById(R.id.btn12);
        imgBtn[13] = (ImageButton) findViewById(R.id.btn13);
        imgBtn[14] = (ImageButton) findViewById(R.id.btn14);
        imgBtn[15] = (ImageButton) findViewById(R.id.btn15);
        imgBtn[16] = (ImageButton) findViewById(R.id.btn16);
        imgBtn[17] = (ImageButton) findViewById(R.id.btn17);
        imgBtn[18] = (ImageButton) findViewById(R.id.btn18);
        imgBtn[19] = (ImageButton) findViewById(R.id.btn19);
        imgBtn[20] = (ImageButton) findViewById(R.id.btn20);
        imgBtn[21] = (ImageButton) findViewById(R.id.btn21);
        imgBtn[22] = (ImageButton) findViewById(R.id.btn22);
        imgBtn[23] = (ImageButton) findViewById(R.id.btn23);

        while(imgBtn.length!= index){

            imgBtn[index].setOnClickListener(click);

        }

    }//end of createPuzzle

/*
    void createImageArrays()
    {
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), image);
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 240, 240, true);

        bitmapsArray[0] = Bitmap.createBitmap(bMapScaled, 0, 0, 80, 80);
        bitmapsArray[1] = Bitmap.createBitmap(bMapScaled, 80, 0, 80, 80);
        bitmapsArray[2] = Bitmap.createBitmap(bMapScaled, 160, 0, 80, 80);
        bitmapsArray[3] = Bitmap.createBitmap(bMapScaled, 0, 80, 80, 80);
        bitmapsArray[4] = Bitmap.createBitmap(bMapScaled, 80, 80, 80, 80);
        bitmapsArray[5] = Bitmap.createBitmap(bMapScaled, 160, 80, 80, 80);
        bitmapsArray[6] = Bitmap.createBitmap(bMapScaled, 0, 160, 80, 80);
        bitmapsArray[7] = Bitmap.createBitmap(bMapScaled, 80, 160, 80, 80);
        bitmapsArray[8] = Bitmap.createBitmap(bMapScaled, 160, 160, 80, 80);

    }
*/
    public View.OnClickListener click = new View.OnClickListener(){

        @Override
        public void onClick(View view){

            int x, y;

            for(y= 0; y < 6 ; y++){

                for (x = 0 ; x < 5; x ++){




                }
            }

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