package com.example.gestorcitasmedicas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UsuarioPerfil extends AppCompatActivity {
    TextView mensaje;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_perfil);
        mensaje =(TextView)findViewById(R.id.mensajeNombreUsuario);
        imagen=(ImageView)findViewById(R.id.imagenid);
        Bundle miBundle=this.getIntent().getExtras();
        if (miBundle!=null){
            String usuario= miBundle.getString("user");
            mensaje.setText(usuario);
        }

    }


    public  void imagen (View view){
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

    public void  irMenu (View view){
        Intent Menu =new Intent(this,UsuariosMenu.class);
        startActivity(Menu);
    }
}
