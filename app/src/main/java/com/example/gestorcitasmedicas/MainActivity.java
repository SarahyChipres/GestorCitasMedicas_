package com.example.gestorcitasmedicas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BD.BDOH;

public class MainActivity extends AppCompatActivity {
    public TextView usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario =(TextView)findViewById(R.id.usuario);
        password = (TextView)findViewById(R.id.password);
    }

    public void ingresar (View v){
        //conexion con la base de datos
        BDOH admin = new BDOH(this);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String user = usuario.getText().toString();
        String pass = password.getText().toString();



        if (!user.isEmpty() && !pass.isEmpty()){
            // crear un objeto de una nueva clase como apoyo para seleccionar un producto a traves de su código
            Cursor fila = bd.rawQuery("select codigo, password from Usuarios where user='" + user +"'", null);
            //identificar si la consulta realizada tene valores y mostrarlos
            if (fila.moveToFirst()) {
                //logeado correctamente
                if (fila.getString(1).equals(pass)){
                    Intent menu = new Intent(this, UsuariosMenu.class);
                    menu.putExtra("codigo", fila.getInt(0));
                    startActivity(menu);
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

    public void registro (View v){
        Intent registro = new Intent(this, UsuariosRegistro.class);
        startActivity(registro);
    }
    public void soyMedico(View v){
        Intent loginmedico =new Intent(this, MedicosLogin.class);
        startActivity(loginmedico);

    }
}

