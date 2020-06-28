package com.example.gestorcitasmedicas;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MedicosMenu extends AppCompatActivity {
    int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos_menu);
        codigo = getIntent().getExtras().getInt("codigo");

    }

    public void ConsultarCitas (View v){
        Intent menu = new Intent(v.getContext(), MedicosConsultarCitas.class);
        startActivity(menu);
    }
    public void CancelarCitas (View v){
        Intent menu = new Intent(v.getContext(),MedicosCancelarCitas.class);
        startActivity(menu);
    }
    public void MedicoPrevencion (View v ){
        Intent  menu = new Intent(v.getContext(), MedicosPrevencion.class);
        startActivity(menu);
    }
    public void   InfoContacto (View v){
        Intent menu = new  Intent(v.getContext(), MedicosInformacionContacto.class);
        startActivity(menu);
    }
    public  void MedicoServicios(View v){
        Intent menu = new Intent(v.getContext(),MedicosServicios.class);
        startActivity(menu);
    }

    public void MedicosHorarios (View v){
        Intent horario= new Intent(v.getContext(), MedicosHorarios.class);
        startActivity(horario);

    }
    public void MedicosFechas (View v){
        Intent fechas= new Intent(v.getContext(), MedicosFechas.class);
        startActivity(fechas);

    }

}

