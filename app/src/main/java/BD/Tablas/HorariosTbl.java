package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import BD.BDOH;

public class HorariosTbl {
    public static final String TableNameH= "Horarios";
    public static final String QueryCreateH ="CREATE TABLE Horarios (id INTEGER PRIMARY KEY, hora TEXT)";
    public static final String Campo_Id_H = "id";
    public static final String Campo_Hora ="hora";


    public static Long AddHours(Context context,
                                Integer idh, String horah) {

        //conexion con la base de datos
        BDOH adminhorarios = new BDOH(context);
        //Comprobar si se abrio la conexion
        if(adminhorarios!= null){
            // Ejecutamos el metodo para leer y escribir en la base de datos
            SQLiteDatabase db= adminhorarios.getWritableDatabase();
            //Guardamos  los datos ingresados
            ContentValues con=new ContentValues();
            con.put(Campo_Id_H,idh);
            con.put(Campo_Hora,horah);


            //Insersion de los datos especificanco en que tabla
            long insertadohorario = db.insert(TableNameH,null, con);
            db.close();
            return insertadohorario;
        } else{
            return Long.getLong("0");
        }
    }


    public static Long DeleteHour(Context context, Integer idh) {
        BDOH admin = new BDOH(context);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //línea que comprueba cual es el producto que se va a borrar según el código que ingresemos
        long  cant = bd.delete(TableNameH, Campo_Id_H +"=" + idh, null);
        return cant;



    }


    public static Long ModificarHora(Context context, Integer idh, String horah) {
        BDOH adminhorarios = new BDOH(context);
        SQLiteDatabase bd = adminhorarios.getWritableDatabase();
        ContentValues registrohorario = new ContentValues();
        //Datos que queremos guardar de manera momentanea
        registrohorario.put(Campo_Id_H, idh);
        registrohorario.put(Campo_Hora, horah);
        long cant = bd.update(TableNameH, registrohorario, "id=" + idh, null);
        return cant;
    }
}

