package com.hoang_nguyen.courseproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button resumeButton, pictureLibraryButton, takePictureButton, helpButton, quitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resumeButton = (Button) findViewById(R.id.resumeButton);
        pictureLibraryButton = (Button) findViewById(R.id.pictureLibraryButton);
        takePictureButton = (Button) findViewById(R.id.takePictureButton);
        helpButton = (Button) findViewById(R.id.helpButton);
        quitButton = (Button) findViewById(R.id.quitButton);


        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
