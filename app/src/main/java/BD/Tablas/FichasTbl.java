package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import BD.BDOH;

public class FichasTbl {
    public static final String TableNameFichas   =  "Fichas";
    public static final String QueryCreateFichas =  "CREATE TABLE Fichas (idficha INTEGER PRIMARY KEY, idMedico INTEGER, paciente TEXT, proceso TEXT, horario TEXT, userId INTEGER)";
    public static final String Campo_Id_Ficha  =  "idficha";
    public static final String Campo_Id_Medico  =  "idMedico";
    public static final String Campo_Paciente  =  "paciente";
    public static final String Campo_Proceso  =  "proceso";
    public static final String Campo_Horario  =  "horario";
    public static final String Campo_userId  =  "userId";

    public static Long addFicha(Context context, Integer codFicah , Integer idMedico, String paciente, String proceso, String horario) {

        BDOH adminFicha = new BDOH(context);

        if (adminFicha != null){

            SQLiteDatabase db= adminFicha.getWritableDatabase();

            ContentValues con = new ContentValues();
            con.put(Campo_Id_Ficha, codFicah);
            con.put(Campo_Id_Medico, idMedico);
            con.put(Campo_Paciente, paciente);
            con.put(Campo_Proceso, proceso);
            con.put(Campo_Horario, horario);
            con.put(Campo_userId, UsuariosTbl.getUser(context));

            long insertarFichas=db.insert(TableNameFichas, null, con);
            db.close();
            return  insertarFichas;
        } else{
            return Long.getLong("0");
        }


    }
}
