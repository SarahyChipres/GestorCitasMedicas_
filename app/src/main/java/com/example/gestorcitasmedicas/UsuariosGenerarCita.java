package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import BD.BDOH;
import BD.Horarios;
import BD.Servicios;


public class UsuariosGenerarCita extends AppCompatActivity {
    TextView procesoMedico, fechayhorario;

    Spinner comboservicios;
    ArrayList<String> listaServicios;
    ArrayList<Servicios> ServiciosList;

    Spinner combohorarios;
    ArrayList<String>ListaHorarios;
    ArrayList<Horarios>HorariosList;


    BDOH conn ;
    BDOH con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        procesoMedico=(TextView)findViewById(R.id.procesoMedico) ;
        fechayhorario=(TextView)findViewById(R.id.horayfecha);
        setContentView(R.layout.activity_usuarios_generar_cita);
        conn = new BDOH(getApplicationContext());
        con  = new BDOH(getApplicationContext());

        comboservicios =(Spinner)findViewById(R.id.comboservicios);
        /*comboservicios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        consultarListaServicios();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaServicios);
        comboservicios.setAdapter(adaptador);


        combohorarios =(Spinner)findViewById(R.id.combohorario);
        consultarListaHorarios();
        ArrayAdapter<CharSequence> adaptadorh= new ArrayAdapter( this, android.R.layout.simple_spinner_item,ListaHorarios);
        combohorarios.setAdapter(adaptadorh);

        combohorarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(parent.getContext(),"Hora y fehca seleccionada:"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                fechayhorario.setText("Seleccion:"+parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        comboservicios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                procesoMedico.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void consultarListaHorarios() {

        SQLiteDatabase dbh =con.getReadableDatabase();
        Horarios HoraDisponible=null;
        HorariosList=new ArrayList<Horarios>();
        Cursor cursorh =dbh.rawQuery("SELECT * FROM Horarios", null);

        while(cursorh.moveToNext()){

            HoraDisponible =new Horarios();
            HoraDisponible.setHora(cursorh.getString(1));
            HorariosList.add(HoraDisponible);
        }
        ObtenerListaHorarios();
    }

    private void ObtenerListaHorarios() {

        ListaHorarios =new ArrayList<String>();
        ListaHorarios.add("selecciona");

        for(int h=0; h<HorariosList.size(); h++){
            ListaHorarios.add( HorariosList.get(h).getHora());

        }
    }

    private void consultarListaServicios() {
        SQLiteDatabase db =conn.getReadableDatabase();
        Servicios procesomedico=null;
        ServiciosList= new ArrayList<Servicios>();
        Cursor cursor=db.rawQuery("SELECT * FROM Servicios  ",null);

        while (cursor.moveToNext()){
            procesomedico= new Servicios();
            procesomedico.setCodigoservicio(cursor.getInt(0));
            procesomedico.setNombreservicio(cursor.getString(1));
            procesomedico.setPrecioservicio(cursor.getString(2));
            ServiciosList.add(procesomedico);
        }
        obtenerLista();
    }
    private void obtenerLista() {
        listaServicios =new ArrayList<String>();
        listaServicios.add("Seleccione");
        for (int i=0; i<ServiciosList.size();i++){
            listaServicios.add(ServiciosList.get(i).getCodigoservicio()+" - "+
                    ServiciosList.get(i).getNombreservicio()+" - $ "+
                    ServiciosList.get(i).getPrecioservicio());
        }
    }


    public void mostrarCita(View view){
        Intent menu = new Intent(this, UsuariosConsultarCita.class);
        startActivity(menu);
    }


}
