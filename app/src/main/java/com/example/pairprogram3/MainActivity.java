package com.example.pairprogram3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button button;

    TouchListener touchListener;

    static final int REQUEST_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        touchListener = new TouchListener(this);
        image = (ImageView) findViewById(R.id.imageView);
        image.setOnTouchListener(touchListener);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePicIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePicIntent, REQUEST_IMAGE);
                }
            }
        });
    }

    public void rotate(int angle) {
        Matrix matrix = new Matrix();
        image.setScaleType(ImageView.ScaleType.MATRIX);   //required
        matrix.postRotate((float) angle, image.getPivotX(), image.getPivotY());
        image.setImageMatrix(matrix);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnail = (Bitmap) extras.get("data");
            image.setImageBitmap(thumbnail);
            //myCanvas.setBackground(new BitmapDrawable(getResources(), thumbnail));
        }
    }
}