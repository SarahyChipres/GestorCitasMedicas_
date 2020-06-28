package com.example.gestorcitasmedicas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MedicosRegistro extends AppCompatActivity {
    TextView usuariomedico, passwordmedico, codigomedico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_registro);

        usuariomedico =(TextView)findViewById(R.id.usuariomedico);
        passwordmedico =(TextView)findViewById(R.id.passwordmedico);
        codigomedico =(TextView)findViewById(R.id.codigomedico);
    }
    //Metodo para registrar Medico
    public void altamedico(View v){
        //Mando llamar metodo.
        if(Comprobarcamposmedico()){
            //Declarar variables para almacenar los datos que  se ingresaran  a la base de datos

            String codmedico, usermedico, passmedico;

            codmedico = codigomedico.getText().toString();
            usermedico= usuariomedico.getText().toString();
            passmedico= passwordmedico.getText().toString();
            Long Res = BD.Tablas.MedicosTbl.AddUser_M(this, Integer.getInteger(codmedico),usermedico,passmedico);

            if (Res>0){
                Toast.makeText(MedicosRegistro.this,"  Dado de Alta correctamente",Toast.LENGTH_SHORT).show();

                codigomedico.setText("");
                usuariomedico.setText("");
                passwordmedico.setText("");

                Intent login = new Intent(this, MedicosLogin.class);
                startActivity(login);

            } else {
                Toast.makeText(MedicosRegistro.this,"No fue posible dar de alta",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(MedicosRegistro.this," hay campos vacios", Toast.LENGTH_SHORT).show();

        }
    }
    //Metodo para comprobar que los campos esten llenos
    public boolean Comprobarcamposmedico() {
        if (codigomedico.getText().toString().isEmpty() || usuariomedico.getText().toString().isEmpty() || passwordmedico.getText().toString().isEmpty()) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }
}

