package com.hoang_nguyen.courseproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
                    createImageArrays(image);


                    //Eric: Please don't delete this comment.
                    //    imageView.setImageBitmap(image);
                //    createPuzzle(image);//create the game.
                    break;

                case REQUEST_TAKE_ALBUM:

                    Uri imageUri = data.getData();
                    InputStream inputStream;

                    try {
                        inputStream = getContentResolver().openInputStream(imageUri);

                        Bitmap image = BitmapFactory.decodeStream(inputStream);

                        createImageArrays(image);

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


    public void createImageArrays(Bitmap image)
    {
        Bitmap bMapScaled = Bitmap.createScaledBitmap(image, 720, 1080, true);

        Bitmap oriBit[] = new Bitmap[24];
        ImageButton imgBtn[] = new ImageButton[24];//creating size 4 x 6 image button array.

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


        //All of column 1
        Bitmap temp = Bitmap.createBitmap(bMapScaled, 0,0, 180, 180);
        imgBtn[0].setImageBitmap(temp);
        oriBit[0] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 0,180, 180, 180);
        imgBtn[4].setImageBitmap(temp);
        oriBit[4] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 0,360, 180, 180);
        imgBtn[8].setImageBitmap(temp);
        oriBit[8] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 0,540, 180, 180);
        imgBtn[12].setImageBitmap(temp);
        oriBit[12] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 0,720, 180, 180);
        imgBtn[16].setImageBitmap(temp);
        oriBit[16] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 0,900, 180, 180);
        imgBtn[20].setImageBitmap(temp);
        oriBit[20] = temp;

        //All of column 2
        temp  = Bitmap.createBitmap(bMapScaled, 180,0, 180, 180);
        imgBtn[1].setImageBitmap(temp);
        oriBit[1] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 180,180, 180, 180);
        imgBtn[5].setImageBitmap(temp);
        oriBit[5] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 180,360, 180, 180);
        imgBtn[9].setImageBitmap(temp);
        oriBit[9] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 180,540, 180, 180);
        imgBtn[13].setImageBitmap(temp);
        oriBit[13] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 180,720, 180, 180);
        imgBtn[17].setImageBitmap(temp);
        oriBit[17] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 180,900, 180, 180);
        imgBtn[21].setImageBitmap(temp);
        oriBit[21] = temp;

        //All of column 3
        temp  = Bitmap.createBitmap(bMapScaled, 360,0, 180, 180);
        imgBtn[2].setImageBitmap(temp);
        oriBit[2] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 360,180, 180, 180);
        imgBtn[6].setImageBitmap(temp);
        oriBit[6] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 360,360, 180, 180);
        imgBtn[10].setImageBitmap(temp);
        oriBit[10] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 360,540, 180, 180);
        imgBtn[14].setImageBitmap(temp);

        temp  = Bitmap.createBitmap(bMapScaled, 360,720, 180, 180);
        imgBtn[18].setImageBitmap(temp);
        oriBit[18] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 360,900, 180, 180);
        imgBtn[22].setImageBitmap(temp);
        oriBit[22] = temp;

        //All of column 4
        temp  = Bitmap.createBitmap(bMapScaled, 540,0, 180, 180);
        imgBtn[3].setImageBitmap(temp);
        oriBit[3] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 540,180, 180, 180);
        imgBtn[7].setImageBitmap(temp);
        oriBit[7] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 540,360, 180, 180);
        imgBtn[11].setImageBitmap(temp);
        oriBit[11] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 540,540, 180, 180);
        imgBtn[15].setImageBitmap(temp);
        oriBit[15] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 540,720, 180, 180);
        imgBtn[19].setImageBitmap(temp);
        oriBit[19] = temp;

        temp  = Bitmap.createBitmap(bMapScaled, 540,900, 180, 180);
        imgBtn[23].setImageBitmap(temp);
        oriBit[23] = temp;


        //Must save the original picture now to keep to that we can use whe we call check
//       SharedPreferences saveOriginal = getSharedPreferences("Original", MODE_PRIVATE);
//        SharedPreferences.Editor editor = saveOriginal.edit();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        for(int i =0; i<= oriBit.length; i++){
//            oriBit[i].compress(Bitmap.CompressFormat.JPEG, 100, stream);
 //       }

        String filename = "Original";
        //String string = "Hello world!";
        FileOutputStream outputStream;
        for(int i =0; i<= oriBit.length; i++) {
            try {
                oriBit[i].compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] bytes = stream.toByteArray();
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(bytes);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

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