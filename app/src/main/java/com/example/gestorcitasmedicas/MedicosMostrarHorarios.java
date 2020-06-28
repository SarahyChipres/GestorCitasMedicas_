package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import BD.BDOH;
import BD.Horarios;


public class MedicosMostrarHorarios extends AppCompatActivity {
    private ArrayList<Horarios> horarios =new ArrayList<>();
    private TextView datoshorario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_mostrar_horarios);
        datoshorario= findViewById(R.id.datoshora);
        LlenarListaH();
    }

    public void LlenarListaH(){
        //Conexion a la base de datos
        BDOH adminmostrarH =new BDOH(this);
        //Comprobar conexion
        if (adminmostrarH!=null){
            //Obtenemos instancia para poder ver la base de datos
            SQLiteDatabase db =adminmostrarH.getReadableDatabase();
            //Hacemos la consulta y recorremos todos los datos
            Cursor c = db.rawQuery("SELECT * FROM Horarios",null);
            //Comprobar si existen datos en la tabla
            if (c.moveToFirst()){
                do {
                    //Empezamos a llenar lista
                    String text = String.format(c.getInt(0) + " -> " + c.getString(1)+ System.getProperty ("line.separator"));
                    datoshorario.setText(datoshorario.getText() + text);
                }while (c.moveToNext());
            }
        } else {
            Toast.makeText(this, "No hay servicios registrados", Toast.LENGTH_SHORT).show();
        }
    }
}


