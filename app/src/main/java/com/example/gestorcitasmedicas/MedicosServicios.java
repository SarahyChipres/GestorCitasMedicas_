package com.example.gestorcitasmedicas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BD.Servicios;

public class MedicosServicios extends AppCompatActivity {
    EditText codigoservicio, precioservicio, nombreservicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_servicios);
        codigoservicio=(EditText)findViewById(R.id.codigoservicio);
        nombreservicio=(EditText)findViewById(R.id.nombreservicio);
        precioservicio=(EditText)findViewById(R.id.precioservicio);
    }

    //Metodo para el boton alta por codigo
    public void altaservicio(View v){
        //Mando llamar metodo.
        if(Comprobarcamposservicios()){
            //Declarar variables para almacenar los datos que  se ingresaran  a la base de datos

            String nomservicio ,preservicio,codservicio;
            codservicio = codigoservicio.getText().toString();
            nomservicio=nombreservicio.getText().toString();
            preservicio=precioservicio.getText().toString();


            Long Res= BD.Tablas.ServiciosTbl.AddService( this, Integer.parseInt(codservicio),nomservicio,preservicio);

            if (Res>0){
                Toast.makeText(MedicosServicios.this,"  servicio dado de Alta correctamente",Toast.LENGTH_SHORT).show();

                codigoservicio.setText("");
                nombreservicio.setText("");
                precioservicio.setText("");

            } else {
                Toast.makeText(MedicosServicios.this,"No fue posible dar de alta este servicio",Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(MedicosServicios.this," hay campos vacios", Toast.LENGTH_SHORT).show();

        }
    }
    //Metodo para comprobar que los campos esten llenos
    public boolean Comprobarcamposservicios() {
        if (codigoservicio.getText().toString().isEmpty() || nombreservicio.getText().toString().isEmpty() || precioservicio.getText().toString().isEmpty()) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }


    public void consultaPorCodigo(View v) {

        String codservicio = codigoservicio.getText().toString();
        if (!codservicio.isEmpty()){
            // crear un objeto de una nueva clase como apoyo para seleccionar un servicio atraves de su código

            Servicios Res = BD.Tablas.ServiciosTbl.ConsultaPorCodigo(this, Integer.parseInt(codservicio));
            //identificar si la consulta realizada tene valores y mostrarlos
            if (Res.getCodigoservicio() > 0) {
                codigoservicio.setText(String.valueOf(Res.getCodigoservicio()));
                nombreservicio.setText(Res.getNombreservicio());
                precioservicio.setText(Res.getPrecioservicio());
            } else {
                Toast.makeText(this, "No existe servicio con dicho código", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debes introducir el código del servicio", Toast.LENGTH_SHORT).show();
        }
    }

    public void bajaPorCodigo(View v) {

        String codservicio= codigoservicio.getText().toString();
        //línea que comprueba cual es el producto que se va a borrar según el código que ingresemos
        if(!codservicio.isEmpty()) {
            int Res = BD.Tablas.ServiciosTbl.BajaPorCodido(this, Integer.parseInt(codservicio));

            codigoservicio.setText("");
            nombreservicio.setText("");
            precioservicio.setText("");
            if (Res == 1)
                Toast.makeText(this, "Se borró el servicio con dicho código",
                        Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "No existe un servicio con dicho código",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Debes introducir el código del servicio", Toast.LENGTH_SHORT).show();
        }
    }


    public void modificar(View v) {
        String codservicio= codigoservicio.getText().toString();
        String nomservicio = nombreservicio.getText().toString();
        String preservicio = precioservicio.getText().toString();
        if(!codservicio.isEmpty()) {

            //Línea de código que nos permite modificar los datos anteriores por los nuevos datos
            int Res = BD.Tablas.ServiciosTbl.ModificarServicio(this, Integer.parseInt(codservicio), preservicio, nomservicio);

            if (Res == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Debes introducir el código del servicio", Toast.LENGTH_SHORT).show();
        }
    }


    public void mostrar(View v){
        Intent mostrarservicios = new Intent(MedicosServicios.this,MedicosMostrarServicios.class);
        startActivity(mostrarservicios);
    }
}

