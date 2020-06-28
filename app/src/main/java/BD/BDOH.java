package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import BD.Tablas.FechasTbl;
import BD.Tablas.FichasTbl;
import BD.Tablas.HorariosTbl;
import BD.Tablas.MedicosTbl;
import BD.Tablas.ServiciosTbl;
import BD.Tablas.UsuariosTbl;

public class BDOH extends SQLiteOpenHelper {



    public BDOH(Context context) {
        super(context, "GestorDeCitas", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuariosTbl.QueryCreate);
        db.execSQL(MedicosTbl.QueryCreateM);
        db.execSQL(ServiciosTbl.QueryCreateS);
        db.execSQL(HorariosTbl.QueryCreateH);
        db.execSQL(FechasTbl.QueryCreateF);
        db.execSQL(FichasTbl.QueryCreateFichas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}