package com.example.myapplication2_basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public static final String EXTRA_MESSAGE = "Informacja";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String temp = editText.getText().toString();

        editText.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //editText.setFocusable(true);
                //editText.setFocusableInTouchMode(true);
                //editText.requestFocus();
                if (editText.getText().toString().equals(temp)) {
                    editText.setText("");
                    Log.i("funkcja onClick","edittext wyczyszczony2...");
                    //dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                    showSoftKeyboard(v);
                }
                return true;
            }
        });

        /*editText.setOnClickListener(new View.OnClickListener() {
            @Override
            //Log.i("funckja onClickListener", "dodano clicklistener...");
            public void onClick(View v) {
                //if (v == editText)
                Log.i("funkcja onClick","edittext bd=edzie wyczyszcony");

                Log.i("wartośc pola editText:", temp);
                if (editText.getText().toString().equals(temp)) {
                    editText.setText("");
                    Log.i("funkcja onClick","edittext wyczyszczony2...");
                }
            }
        });*/
    }
    public void sendMessage(View view){
        //print("funkcja sendMessage 0 wciśnięto przycisk...");
        Log.i("funkcja sendMessage","funkcja działa...");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);

        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
        public void showSoftKeyboard(View view){
        if(view.requestFocus()){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
}