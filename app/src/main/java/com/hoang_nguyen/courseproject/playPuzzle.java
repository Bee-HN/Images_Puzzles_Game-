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
import java.util.Arrays;
import java.util.Collections;

/*
    Authors: Seho Lee and G# 00984821
             Emmanuel Meneses and G#00984596
             Hoang Nguyen and G#00924950
 */


public class playPuzzle extends AppCompatActivity {

    /*
        intent = Using intent value to use intent.
        image = lord a picture from album or camera.
        oriBit = hold piece of images in Bitmap array.
        imgBtn = use image button array to create puzzle table.

     */
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_ALBUM = 2;
    Intent intent;
    Bitmap image, oriBit[];
    ImageButton imgBtn[] = new ImageButton[24];//creating size 4 x 6 image button array.
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_puzzle);
        this.setTitle("Puzzle Time");//set title of game.

        //get boolean intent value from MainActivity
        boolean isAlbum = getIntent().getExtras().getBoolean("checkAlbum");
        boolean isCamera = getIntent().getExtras().getBoolean("checkPic");

        if (isAlbum) {
        //if user select "isAlbum" in MainActivity, then start Album.
            intent = new Intent(Intent.ACTION_PICK);
            File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String pictureDirectoryPath = pictureDirectory.getPath();
            Uri data = Uri.parse(pictureDirectoryPath);//Parse string address to Uri
            intent.setDataAndType(data, "image/*");
            startActivityForResult(intent, REQUEST_TAKE_ALBUM);
        }//end of isAlbum

        if (isCamera) {
            //if user select "isCamera" in MainActivity, then start Camera.
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }//end of takePic
        }
    }//end of on Create

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK) {
        //Based on RequestCode, do the activity.
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE:
                    //This is cameara
                    //Using URI address to get data.
                    image = (Bitmap) data.getExtras().get("data");
                    //call subrutine fuction to create puzzle.
                    createImageArrays(image);
                    break;

                case REQUEST_TAKE_ALBUM:
                    //Using Uri address to get image address
                    Uri imageUri = data.getData();

                    InputStream inputStream;
                    try {
                        //Using inputStreem to grab image from album
                        inputStream = getContentResolver().openInputStream(imageUri);
                        image = BitmapFactory.decodeStream(inputStream);
                        createImageArrays(image);//call subrutine to create puzzle.

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }else{
            //finish the activity.
            finish();
        }//end of if-else.
}//end of onActivityResult.


    public void createImageArrays(Bitmap image)
    {
        Bitmap bitmapSize = Bitmap.createScaledBitmap(image, 720, 1080, true);

        int j = 0;
        oriBit = new Bitmap[24];
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


        //using createBitmap fucntion to create puzzle images
        Bitmap temp = Bitmap.createBitmap(bitmapSize, 0,0, 180, 180);
        oriBit[0] = temp;//save image pieces into array

        temp  = Bitmap.createBitmap(bitmapSize, 0,180, 180, 180);
        oriBit[4] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 0,360, 180, 180);
        oriBit[8] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 0,540, 180, 180);
        oriBit[12] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 0,720, 180, 180);
        oriBit[16] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 0,900, 180, 180);
        oriBit[20] = temp;

        //All of column 2
        temp  = Bitmap.createBitmap(bitmapSize, 180,0, 180, 180);
        oriBit[1] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 180,180, 180, 180);
        oriBit[5] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 180,360, 180, 180);
        oriBit[9] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 180,540, 180, 180);
        oriBit[13] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 180,720, 180, 180);
        oriBit[17] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 180,900, 180, 180);
        oriBit[21] = temp;

        //All of column 3
        temp  = Bitmap.createBitmap(bitmapSize, 360,0, 180, 180);
        oriBit[2] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 360,180, 180, 180);
        oriBit[6] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 360,360, 180, 180);
        oriBit[10] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 360,540, 180, 180);
        oriBit[14] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 360,720, 180, 180);
        oriBit[18] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 360,900, 180, 180);
        oriBit[22] = temp;

        //All of column 4
        temp  = Bitmap.createBitmap(bitmapSize, 540,0, 180, 180);
        oriBit[3] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 540,180, 180, 180);
        oriBit[7] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 540,360, 180, 180);
        oriBit[11] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 540,540, 180, 180);
        oriBit[15] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 540,720, 180, 180);
        oriBit[19] = temp;

        temp  = Bitmap.createBitmap(bitmapSize, 540,900, 180, 180);
        oriBit[23] = temp;


        while(imgBtn.length!= j){
        //initialize image Button listener so that whenever user click image button,
        //the button respond.
            imgBtn[j].setOnClickListener(click);
            j++;
        }

        //Call collections to shuffle our images.
        //which is creating puzzle.
        Collections.shuffle(Arrays.asList(oriBit));

        for(int i =0; i< oriBit.length; i++){
            //set shuffled images into image button.
            imgBtn[i].setImageBitmap(oriBit[i]);

        }
    }//end of createImage


    public View.OnClickListener click = new View.OnClickListener(){
    //This public listenr fucntion determine that selected puzzle pieces

        ImageButton firstImage, secondImage;
        @Override
        public void onClick(View view){
            if(count == 0){
                //keep track the first click image
                firstImage = (ImageButton) view;
                count++;//increasing click counting.

            }else if(count == 1){
                //second click, then call swap fucntion to change puzzle images.
                secondImage = (ImageButton) view;
                count = 0;
                swap(firstImage, secondImage);// call swap fucntion to switch the puzzle images.
            }//end of if-else
        }//end of onClick

    };

    public void swap (ImageButton firstImage, ImageButton secondImage){
        //find out each image's coordinate and then using layout to replace their images.
        //based on coordinate, swap the puzzle image positions.
        int left = firstImage.getLeft();
        int right = firstImage.getRight();
        int top = firstImage.getTop();
        int bottom= firstImage.getBottom();

        firstImage.layout(secondImage.getLeft(),secondImage.getTop(), secondImage.getRight(), secondImage.getBottom());
        secondImage.layout(left, top, right, bottom);

    }//end of swap

    public void CheckPuzzle(View view) {
    //using alertDialog to show original picutre so that user can compare thier answer.
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(playPuzzle.this);
        alertDialog.setMessage("This is the original picture");
        alertDialog.setNegativeButton("Back", null);

        ImageView imageView = new ImageView(playPuzzle.this);
        imageView.setImageBitmap(image);
        alertDialog.setView(imageView);
        alertDialog.create();
        alertDialog.show();

    }//end of checkPuzzle


    public void resetImage (View view) {
    //Reset the game by calling createImageArrays.

        AlertDialog.Builder altdial = new AlertDialog.Builder(playPuzzle.this);
        altdial.setMessage("Do you want to reset the game?").setCancelable(false)
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createImageArrays(image);
                    }
                });
        AlertDialog alert = altdial.create();
        alert.setTitle("Reset Puzzle Game");
        alert.show();



    }//end of resetImag

    public void QuitPuzzle(View view) {

                AlertDialog.Builder altdial = new AlertDialog.Builder(playPuzzle.this);
                altdial.setMessage("Do you want to go back home screen?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                             //   SavePuzzle(view);
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alert = altdial.create();
                alert.setTitle("Quit Puzzle Game");
                alert.show();
    }
}