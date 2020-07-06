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
import BD.Tablas.MedicosTbl;
import BD.Tablas.UsuariosTbl;

public class UsuariosConsultarCita extends AppCompatActivity {

    private ArrayList<Horarios> citas =new ArrayList<>();
    private TextView datosCitras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_consultar_cita);
        datosCitras= findViewById(R.id.datosCitas);
        LlenarListaCitas();
    }

    public void LlenarListaCitas(){
        //Conexion a la base de datos
        BDOH adminmostrarCitas =new BDOH(this);
        //Comprobar conexion
        if (adminmostrarCitas!=null){
            //Obtenemos instancia para poder ver la base de datos
            SQLiteDatabase db =adminmostrarCitas.getReadableDatabase();
            //Hacemos la consulta y recorremos todos los datos
            Integer usuario = UsuariosTbl.getUser(this);
            Cursor c = db.rawQuery("SELECT * FROM Fichas WHERE userId = " + usuario,null);
            //Comprobar si existen datos en la tabla
            if (c.moveToFirst()){
                do {
                    //Empezamos a llenar lista
                    String text = String.format(c.getInt(0) + " -> " + MedicosTbl.getUserMedico(this, c.getInt(1)) +
                            " -> " + c.getString(2) + " -> " + c.getString(3) + " -> " + c.getString(4)
                            + System.getProperty ("line.separator"));
                    datosCitras.setText(datosCitras.getText() + text);
                }while (c.moveToNext());
            }
        } else {
            Toast.makeText(this, "No hay servicios registrados", Toast.LENGTH_SHORT).show();
        }
    }
}
