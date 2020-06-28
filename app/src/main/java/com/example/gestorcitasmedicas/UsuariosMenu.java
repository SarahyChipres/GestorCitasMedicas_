package com.example.gestorcitasmedicas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UsuariosMenu extends AppCompatActivity {
    int codigo;
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_menu);
        codigo = getIntent().getExtras().getInt("codigo");
    }

    public void CitaMedica (View v){
        Intent menu = new Intent(this, UsuariosGenerarCita.class);
        startActivity(menu);
    }

    // Metodo del boton ir a productos
    public void MisCitas (View v){
        Intent menu = new Intent(this, UsuariosConsultarCita.class);
        startActivity(menu);
    }

    public void Prevencion (View v){
        Intent menu = new Intent(this, UsuariosPrevencion.class);
        startActivity(menu);
    }



    public void CancelarCita (View v){
        Intent menu = new Intent(this, UsuarioCancelarCita.class);
        startActivity(menu);
    }

    public void Contacto (View v){
        Intent menu = new Intent(this, UsuariosInformacionContacto.class);
        startActivity(menu);
    }
    public void verPerfil(View view){
        Intent perfil = new Intent(this, UsuarioPerfil.class);
        startActivity(perfil);
    }
}


