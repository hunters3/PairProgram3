package com.example.pairprogram3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}