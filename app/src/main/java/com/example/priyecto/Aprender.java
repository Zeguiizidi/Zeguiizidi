package com.example.priyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;


public class Aprender extends AppCompatActivity {

    private MediaPlayer mp;
    private static final int intervalo = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);
        Button amarillo = (Button) findViewById(R.id.btn_Amarillo);
        mp = MediaPlayer.create(this, R.raw.color_amarillo);
        amarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                mp.seekTo(0);
            }
        });
    }
    @Override
    public void onBackPressed(){
        if (tiempoPrimerClick + intervalo > System.currentTimeMillis()){
            finish();
            return;
        }else {
            Toast.makeText(this, "Vuelve a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }
}
