package com.example.gestorcitasmedicas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import BD.Servicios;

public class MedicosMostrarServicios extends AppCompatActivity {

    private ArrayList<Servicios> servicios;
    private TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_mostrar_servicios);
        datos= findViewById(R.id.datos);
        LlenarLista();
    }

    public void LlenarLista(){
        servicios = BD.Tablas.ServiciosTbl.ListarServicios(MedicosMostrarServicios.this);
        MostarLista();
    }

    protected void MostarLista(){
        for (Servicios servicio: servicios
        ) {
            //Empezamos a llenar lista
            String text = String.format(servicio.getNombreservicio() + " -> "
                    + servicio.getNombreservicio() + " -> $"
                    + servicio.getPrecioservicio() + System.getProperty ("line.separator"));
            datos.setText(datos.getText() + text);
        }
    }
}


