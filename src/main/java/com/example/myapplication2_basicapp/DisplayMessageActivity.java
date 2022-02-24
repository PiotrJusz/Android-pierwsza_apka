package com.example.myapplication2_basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        ImageView imageView;
        imageView = (ImageView)findViewById(R.id.imageView);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (message.equals("Hello World!")) {
            Log.i("Message:", message);
            message = "Witaj Wielki Programisto!";
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        //ImageViev imageViev = findViewById(R.id.imageView);
        textView.setText(message);
    }
}


