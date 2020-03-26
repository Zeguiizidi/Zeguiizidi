package com.example.priyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton aprender = (ImageButton) findViewById(R.id.imbAprender);
        aprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Menu.this, Aprender.class);
            startActivity(intent);
            }
        });
        ImageButton practicar = (ImageButton) findViewById(R.id.imbPracticar);
        practicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Menu.this, Practicar.class);
            startActivity(intent);
            }
        });
    }

}
