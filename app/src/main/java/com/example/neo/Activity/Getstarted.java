package com.example.neo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.R;

public class Getstarted extends AppCompatActivity {

    Button getstarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        getstarted = findViewById(R.id.button_getstarted);
        start();
    }

    private void start(){
        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Getstarted.this, Login.class));
                finish();
            }
        });
    }
}
