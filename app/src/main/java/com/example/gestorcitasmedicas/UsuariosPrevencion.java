package com.example.gestorcitasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UsuariosPrevencion extends AppCompatActivity {
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_prevencion);

        texto= (TextView)findViewById(R.id.textView);

        texto.setText("Dieta sana y equilibrada" +"\n"+
                "Mantener una dieta equilibrada es la clave a la hora de cuidar la salud." +
                        " Se deben evitar los azúcares refinados y todos aquellos productos excesivamente edulcorados, así como las grasas " +
                        "saturadas y las grasas trans. Para ello, es importante combinar de forma efectiva la ingesta de proteínas (pescados, " +
                        "carnes), grasas (aceite, mantequilla) e hidratos de carbono (frutas, verduras, pasta, pan). Asimismo, es fundamental beber " +
                        "entre 1,5 y 2 litros de agua al día.\n" +
                "\n" +

                "Se deben controlar las cantidades y comer en función a lo que necesite el cuerpo de cada uno (según su consumo de energía).\n" +
                "\n" +

                "Buena higiene"+"\n"+
                "Es importante lavarse bien las manos, mantener una buena higiene bucal, etc."+
                "Ejercicio de manera regular\n" +
                        "El ejercicio moderado fortalece el corazón, mejora la circulación y ayuda a eliminar toxinas entre otros muchos beneficios." +
                        " Es importante practicar ejercicio de manera regular y acorde con la edad. La OMS recomienda al menos 30 minutos diarios de" +
                        " ejercicio para evitar problemas de salud.\n" +
                        "\n" +
                        "Como ejercicio diario podemos entender también el subir por las escaleras o caminar en vez de coger otro transporte. ¡Así de fácil!"+
                        "\n"+
                        "Evitar el consumo de sustancias tóxicas\n" +
                        "Nos referimos al consumo del tabaco, el alcohol o a cualquier otro tipo de droga.\n" +
                        "\n" +
                        "Crear un buen ambiente a nuestro alrededor\n" +
                        "Crear un buen ambiente se consigue fomentando las relaciones personales sanas, evitando el estrés, etc.\n" +
                        "\n" +
                        "Disponer de momentos para relajarse\n" +
                        "Es importante tener momentos de relajación, de pensar en otras cosas que se escapen de la rutina y las preocupaciones diarias." +
                        " Todo esto minimiza la aparición del estrés y de sus síntomas.\n" +
                        "\n" +
                        "Chequeos médicos\n" +
                        "Las revisiones médicas periódicas son la mejor manera de controlar nuestro estado de salud y poder responder a tiempo ante " +
                        "cualquier posible incidencia. Consulta en nuestro cuadro médico los mejores profesionales para tus revisiones.\n" +
                        "\n" +
                        "Asegurar el buen descanso\n" +
                        "El cerebro y el sistema nervioso necesitan reducir su actividad, descansar y depurarse para poder continuar con su funcionamiento" +
                        " a pleno rendimiento. Esto se consigue con el sueño. Cada persona puede tener un número óptimo de horas que debe cumplir y que suele" +
                        " estar entre las 6 horas y media y las ocho horas.\n" +
                        "\n" +
                        "Presta atención al modo en que te sientas, utiliza una buena almohada y un buen colchón; ayudará a mantener saludables huesos y " +
                        "músculos."

                );

    }
}
