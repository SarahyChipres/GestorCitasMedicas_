package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import BD.BDOH;

public class MedicosLogin extends AppCompatActivity {
    TextView usuariomedico, passwordmedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_login);
        usuariomedico=(TextView)findViewById(R.id.usuariomedico);
        passwordmedico =(TextView)findViewById(R.id.passwordmedico);
    }

    public  void Ingresarmedico (View view){

        BDOH adminmedico = new BDOH(this);
        SQLiteDatabase bd = adminmedico.getWritableDatabase();

        String usermedico = usuariomedico.getText().toString();
        String passmedico = passwordmedico.getText().toString();



        if (!usermedico.isEmpty() && !passmedico.isEmpty()){
            Cursor fila = bd.rawQuery("select codigomedico, passwordmedico from Medicos where usermedico='" + usermedico +"'", null);
            //identificar si la consulta realizada tene valores y mostrarlos
            if (fila.moveToFirst()) {
                //logeado correctamente
                if (fila.getString(1).equals(passmedico)){
                    Intent menumedico = new Intent(this, MedicosMenu.class);
                    menumedico.putExtra("codigomedico", fila.getInt(0));
                    startActivity(menumedico);
                } else {
                    Toast.makeText(this, "Error en password", Toast.LENGTH_SHORT).show();
                    bd.close();
                }
            } else {
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
                bd.close();
            }
        } else {
            Toast.makeText(this, "Debes introducir todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void registromedico (View v){
        BDOH admin = new BDOH(this);
        Intent registromedico = new Intent(this, MedicosRegistro.class);
        startActivity(registromedico);
    }

}
