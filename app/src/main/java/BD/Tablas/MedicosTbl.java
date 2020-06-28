package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import BD.BDOH;

public class MedicosTbl {
    public static final String TableNameM    ="Medicos";
    public static final String QueryCreateM   = "CREATE TABLE Medicos (codigomedico INTEGER PRIMARY KEY, usermedico TEXT, passwordmedico TEXT)";
    public static final String Campo_Codigo_M = "codigomedico";
    public static final String Campo_User_M   = "usermedico";
    public static final String Campo_Password_M = "passwordmedico";




    public static Long AddUser_M(Context context,
                                 Integer codmedico, String usermedico,String passmedico
    ) {


        BDOH adminmedico = new BDOH(context);
        //Comprobar si se abrio la conexion
        if(adminmedico != null){

            SQLiteDatabase db = adminmedico.getWritableDatabase();
            //Guardamos  los datos ingresados
            ContentValues con = new ContentValues();

            con.put(Campo_Codigo_M,codmedico);
            con.put(Campo_User_M,usermedico);
            con.put(Campo_Password_M,passmedico);

            long insertadomedico = db.insert(TableNameM,null, con);
            return insertadomedico;
        }else{
            return Long.getLong("0");
        }
    }
}
