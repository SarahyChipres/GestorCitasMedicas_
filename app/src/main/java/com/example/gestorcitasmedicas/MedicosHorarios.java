package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MedicosHorarios extends AppCompatActivity {
    TextView id, hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_horarios);

        id= (EditText)findViewById(R.id.id);
        hora=(EditText)findViewById(R.id.hora);
    }



    public void altahorario(View v){
        //Mando llamar metodo.
        if(Comprobarcamposhorario()){
            //Declarar variables para almacenar los datos que  se ingresaran  a la base de datos

            String  idh, horah;
            idh= id.getText().toString();
            horah=hora.getText().toString();

            Long Res = BD.Tablas.HorariosTbl.AddHours(v.getContext(),Integer.getInteger(idh),horah);

            if (Res>0){
                Toast.makeText(v.getContext(),"  hora  dada de Alta correctamente",Toast.LENGTH_SHORT).show();

                id.setText("");
                hora.setText("");


            } else {
                Toast.makeText(v.getContext(),"No fue posible dar de alta esta hora",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(v.getContext()," hay campos vacios", Toast.LENGTH_SHORT).show();

        }
    }
    //Metodo para comprobar que los campos esten llenos
    public boolean Comprobarcamposhorario() {
        if (id.getText().toString().isEmpty() || hora.getText().toString().isEmpty() ) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }



    public void bajaPorid(View v) {

        String idh;
        idh= id.getText().toString();
        Long Res =BD.Tablas.HorariosTbl.DeleteHour(v.getContext(),Integer.getInteger(idh));
        id.setText("");
        hora.setText("");
        if (Res== 1)
            Toast.makeText(v.getContext(), "Se borró la hora con dicho código",
                    Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(v.getContext(), "No existe hora con dicho código",
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void modificarhora(View v) {

        String idh, horah;
        idh = id.getText().toString();
        horah = hora.getText().toString();

        Long Res = BD.Tablas.HorariosTbl.ModificarHora(v.getContext(), Integer.getInteger(idh),horah);

        if (Res == 1)
            Toast.makeText(v.getContext(), "se modificaron los datos", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(v.getContext(), "no existe hora con el código ingresado", Toast.LENGTH_SHORT).show();
        }
    }


    public void mostrarHorario(View v){
        Intent mostrarhorario = new Intent(MedicosHorarios.this,MedicosMostrarHorarios.class);
        startActivity(mostrarhorario);
    }

}


