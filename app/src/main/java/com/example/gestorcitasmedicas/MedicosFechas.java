package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MedicosFechas extends AppCompatActivity {
 EditText codigofecha, fechalaboral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_fechas);
        codigofecha= (EditText)findViewById(R.id.codigofecha);
        fechalaboral=(EditText)findViewById(R.id.fechalaboral);
    }



    public void altaFechas(View v){
        //Mando llamar metodo.
        if(ComprobarcamposhorarioF()){
            //Declarar variables para almacenar los datos que  se ingresaran  a la base de datos

            String  codfecha, fechalab;

            codfecha= codigofecha.getText().toString();
            fechalab=fechalaboral.getText().toString();

            Long Res = BD.Tablas.FechasTbl.AddFechas(v.getContext(),Integer.getInteger(codfecha),fechalab);

            if (Res>0){
                Toast.makeText(v.getContext(),"Fecha dada de Alta correctamente",Toast.LENGTH_SHORT).show();

                codigofecha.setText("");
                fechalaboral.setText("");

            } else {
                Toast.makeText(v.getContext(),"No fue posible dar de alta esta hora",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(v.getContext(),"Hay campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para comprobar que los campos esten llenos
    public boolean ComprobarcamposhorarioF() {
        if (codigofecha.getText().toString().isEmpty() || fechalaboral.getText().toString().isEmpty() ) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }



    public void bajaPoridFecha(View v) {

        if(!codigofecha.getText().toString().isEmpty()){

            String codfecha;
            codfecha= codigofecha.getText().toString();
            Long Res =BD.Tablas.FechasTbl.DeleteFecha(v.getContext(),Integer.parseInt(codfecha));
            codigofecha.setText("");
            fechalaboral.setText("");
            if (Res== 1){
                Toast.makeText(v.getContext(), "Se borró la fecha con dicho código",
                        Toast.LENGTH_SHORT).show();
                codigofecha.setText("");
            }
            else {
                Toast.makeText(v.getContext(), "No existe fecha con dicho código",
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(v.getContext(),"Inserte el codigo de la fecha", Toast.LENGTH_SHORT).show();
        }

    }


    public void modificarFecha(View v) {

        if(ComprobarcamposhorarioF()){

            String codfecha, fechalab;
            codfecha= codigofecha.getText().toString();
            fechalab = fechalaboral.getText().toString();

            Long Res = BD.Tablas.FechasTbl.ModificarFecha(v.getContext(), Integer.parseInt(codfecha),fechalab);

            if (Res == 1) {
                Toast.makeText(v.getContext(), "Se modificaron los datos", Toast.LENGTH_SHORT).show();

                codigofecha.setText("");
                fechalaboral.setText("");
            }
            else{
                Toast.makeText(v.getContext(), "No existe fecha con el código ingresado", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(v.getContext(),"Hay campos vacios", Toast.LENGTH_SHORT).show();
        }

    }


    public void mostrarFechas(View v){
        Intent mostrarhorario = new Intent(MedicosFechas.this,MedicosMostrarFechas.class);
        startActivity(mostrarhorario);
    }

}


