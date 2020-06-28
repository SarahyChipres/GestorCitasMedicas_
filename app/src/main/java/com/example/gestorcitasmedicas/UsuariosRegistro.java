package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsuariosRegistro extends AppCompatActivity {
    private EditText codigo, usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_registro);
        codigo=(EditText)findViewById(R.id.codigo);
        usuario=(EditText)findViewById(R.id.usuario);
        password=(EditText)findViewById(R.id.password);
    }

    //Metodo para registrar usuario
    public void altausuario(View v){
        //Mando llamar metodo.
        if(Comprobarcampos()){
            //Declarar variables para almacenar los datos que  se ingresaran  a la base de datos

            String cod1, user1, pass1;

            cod1 = codigo.getText().toString();
            user1= usuario.getText().toString();
            pass1= password.getText().toString();
            Long Res = BD.Tablas.UsuariosTbl.AddUser( this,
                    Integer.getInteger(cod1), user1, pass1);
            //Insersion de los datos especificanco en que tabla
            if (Res>0){
                Toast.makeText(this,"  Dado de Alta correctamente",Toast.LENGTH_SHORT).show();

                codigo.setText("");
                usuario.setText("");
                password.setText("");

                Intent login = new Intent(this, MainActivity.class);
                startActivity(login);
            } else {
                Toast.makeText(UsuariosRegistro.this,"No fue posible dar de alta",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(UsuariosRegistro.this," hay campos vacios", Toast.LENGTH_SHORT).show();

        }
    }
    //Metodo para comprobar que los campos esten llenos
    public boolean Comprobarcampos() {
        if (codigo.getText().toString().isEmpty() || usuario.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }
}
