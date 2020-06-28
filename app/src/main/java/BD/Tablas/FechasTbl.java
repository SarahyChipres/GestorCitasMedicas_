package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import BD.BDOH;

public class FechasTbl {
    public static final String TableNameF   =  "Fechas";
    public static final String QueryCreateF =  "CREATE TABLE Fechas (codigofecha INTEGER PRIMARY KEY, fechalaboral TEXT)";
    public static final String Campo_Id_F   =  "codigofecha";
    public static final String Campo_Fecha  =  "fechalaboral";

    public static Long AddFechas(Context context,
                                 Integer codfecha , String fechalab) {

        BDOH adminfechas = new BDOH(context);
        if (adminfechas!=null){

            SQLiteDatabase db= adminfechas.getWritableDatabase();

            ContentValues con = new ContentValues();
            con.put(Campo_Id_F,codfecha);
            con.put(Campo_Fecha,fechalab);

            long insertarfechas=db.insert(TableNameF, null, con);
            db.close();
            return  insertarfechas;
        } else{
            return Long.getLong("0");
        }


    }


    public static Long DeleteFecha(Context context, Integer idf ) {
        BDOH adminfechas = new BDOH(context);
        SQLiteDatabase bd= adminfechas.getWritableDatabase();
        long cant=bd.delete(TableNameF,Campo_Id_F+"="+ idf, null);
        return  cant;
    }


    public static Long ModificarFecha(Context context, Integer idf, String fechad) {
        BDOH adminfechas= new BDOH(context);
        SQLiteDatabase db =adminfechas.getWritableDatabase();
        ContentValues registrofecha= new ContentValues();
        registrofecha.put(Campo_Id_F,idf);
        registrofecha.put(Campo_Fecha,fechad);
        long cant= db.update(TableNameF,registrofecha,Campo_Id_F+"="+idf,null);
        return  cant;
    }
}
