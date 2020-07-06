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
import BD.Medicos;


public class UsuariosGenerarCita extends AppCompatActivity {
    public TextView nombrePaciente;


    Spinner comboservicios;
    ArrayList<String> listaServicios;
    ArrayList<Servicios> ServiciosList;

    Spinner combohorarios;
    ArrayList<String>ListaHorarios;
    ArrayList<Horarios>HorariosList;

    Spinner comboDoctores;
    ArrayList<String> listaDoctores;
    ArrayList<Medicos> doctoresList;
    ArrayList<Medicos> doctoresListId;

    BDOH conn ;
    BDOH con;

    public UsuariosGenerarCita() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_generar_cita);

        nombrePaciente = (TextView)findViewById(R.id.nombrePaciente);

        conn = new BDOH(getApplicationContext());
        con  = new BDOH(getApplicationContext());

        comboservicios =(Spinner)findViewById(R.id.comboservicios);
        consultarListaServicios();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaServicios);
        comboservicios.setAdapter(adaptador);


        combohorarios =(Spinner)findViewById(R.id.combohorario);
        consultarListaHorarios();
        ArrayAdapter<CharSequence> adaptadorh= new ArrayAdapter( this, android.R.layout.simple_spinner_item,ListaHorarios);
        combohorarios.setAdapter(adaptadorh);

        comboDoctores =(Spinner)findViewById(R.id.comboMedico);
        consultarListaDoctores();
        ArrayAdapter<CharSequence> adaptadorDoctor= new ArrayAdapter( this, android.R.layout.simple_spinner_item,listaDoctores);
        comboDoctores.setAdapter(adaptadorDoctor);
    }

    private void consultarListaDoctores() {

        SQLiteDatabase dbh = con.getReadableDatabase();
        Medicos doctorDisponible = null;
        Medicos doctorId = null;
        doctoresList = new ArrayList<Medicos>();
        doctoresListId = new ArrayList<Medicos>();
        Cursor doctores =dbh.rawQuery("SELECT * FROM Medicos", null);

        while(doctores.moveToNext()){
            doctorDisponible = new Medicos();
            doctorId = new Medicos();
            doctorDisponible.setUsermedico(doctores.getString(1));
            doctorId.setCodigomedico(doctores.getString(0));
            doctoresList.add(doctorDisponible);
            doctoresListId.add(doctorId);
        }
        ObtenerListaDoctores();

    }

    private void ObtenerListaDoctores() {

        listaDoctores =new ArrayList<String>();
        listaDoctores.add("Seleccione");

        for(int h=0; h<doctoresList.size(); h++){
            listaDoctores.add( doctoresListId.get(h).getCodigomedico() + " - " + doctoresList.get(h).getUsermedico() );
        }
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
        ListaHorarios.add("Seleccione");

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

    public boolean comprobarCampos() {
        if (nombrePaciente.getText().toString().isEmpty() || (comboservicios.getSelectedItem().toString() == "Seleccione") || (combohorarios.getSelectedItem().toString() == "Seleccione")  || (comboDoctores.getSelectedItem().toString() == "Seleccione") ) {
            //si llega a existir un campo vacio
            return false;
        } else {
            //Si no existe ningun campo vacio
            return true;
        }
    }

    public void mostrarCita(View v){

        if(comprobarCampos()){

            String itemServicio = (String) comboservicios.getSelectedItem();
            String itemHora = (String) combohorarios.getSelectedItem();
            String itemDoctorCompleta = (String) comboDoctores.getSelectedItem();
            String[] datosDoctro = itemDoctorCompleta.split(" - ");
            String paciente = nombrePaciente.getText().toString();
            String nombre = datosDoctro[1], id = datosDoctro[0];

            Long Res = BD.Tablas.FichasTbl.addFicha(this, (int) (Math.random()*1000+1), Integer.parseInt(id), paciente, itemServicio, itemHora);

            if (Res>0){
                Toast.makeText(v.getContext(),"Cita agendada correctamente",Toast.LENGTH_SHORT).show();

                Intent menu = new Intent(this, UsuariosConsultarCita.class);
                startActivity(menu);

            } else {
                Toast.makeText(v.getContext(),"No fue posible agendar",Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(v.getContext(),"Hay campos vacios", Toast.LENGTH_SHORT).show();
        }

    }



}
