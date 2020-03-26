package com.example.priyecto;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Registro extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Spinner dia = (Spinner) findViewById(R.id.espdiaNac);
        String[] dias = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","20","31"};
        ArrayAdapter<String> adpdia = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, dias);
        dia.setAdapter(adpdia);

        Spinner mes = (Spinner) findViewById(R.id.espmesNac);
        String[] meses = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter<String> adpmes = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, meses);
        mes.setAdapter(adpmes);

        Spinner año = (Spinner) findViewById(R.id.españoNac);
        String[] años = new String[] {"1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2001"};
        ArrayAdapter<String> adpaño = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, años);
        año.setAdapter(adpaño);

        Button registrar = (Button) findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = ((EditText)findViewById(R.id.edtNombre)).getText().toString();
                String paterno = ((EditText)findViewById(R.id.edtApPaterno)).getText().toString();
                String materno = ((EditText)findViewById(R.id.edtApMaterno)).getText().toString();
                String usuario = ((EditText)findViewById(R.id.edtUsuario)).getText().toString();
                String password = ((EditText)findViewById(R.id.edtPass)).getText().toString();
                String cpassword = ((EditText)findViewById(R.id.edtCPass)).getText().toString();

                if(password.equals(cpassword) && !nombre.isEmpty() && !paterno.isEmpty() && !materno.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !cpassword.isEmpty()){
                    MySQLiteHelper dbHelper = new MySQLiteHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    if (db != null) {
                        db.execSQL("INSERT INTO usuarios (nombre,paterno,materno,usuario,password) VALUES ('"+ nombre +"','"+paterno+"','"+materno+"','"+usuario+"','"+password+"')");
                        Toast.makeText(getApplicationContext(), "Registrado Correctamente!!!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
