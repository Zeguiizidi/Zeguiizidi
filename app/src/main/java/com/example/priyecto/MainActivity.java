package com.example.priyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btningresar = (Button) findViewById(R.id.btnIngresar);
        Button btnregistrarse = (Button) findViewById(R.id.btnRegistrarme);
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.edtUser)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.edtContraseña)).getText().toString();

                MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Cursor c = db.rawQuery("SELECT usuario, password FROM usuarios WHERE usuario = '"+usuario+"' and password = '"+contraseña+"'", null);
                    if (c != null) {
                        String user = c.getString(c.getColumnIndex("usuario"));
                        String pass = c.getString(c.getColumnIndex("password"));
                        if (usuario.equals(user) && contraseña.equals(pass)) {
                            Intent intent = new Intent(MainActivity.this, Menu.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario No Registrado!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Registro.class);
                    startActivity(intent);
            }
        });

    }
}
