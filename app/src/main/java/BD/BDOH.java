package BD;

import android.content.ContentValues;
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
        super(context, "GestorDeCitas", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuariosTbl.QueryCreate);
        db.execSQL(MedicosTbl.QueryCreateM);
        db.execSQL(ServiciosTbl.QueryCreateS);
        db.execSQL(HorariosTbl.QueryCreateH);
        db.execSQL(FechasTbl.QueryCreateF);
        db.execSQL(FichasTbl.QueryCreateFichas);

        ContentValues conUsuario = new ContentValues();
        conUsuario.put(UsuariosTbl.Campo_Codigo, 1);
        conUsuario.put(UsuariosTbl.Campo_User, "usuario");
        conUsuario.put(UsuariosTbl.Campo_Password, "123");

        db.insert(UsuariosTbl.TableName, null, conUsuario);

        ContentValues conMedico = new ContentValues();
        conMedico.put(MedicosTbl.Campo_Codigo_M, 1);
        conMedico.put(MedicosTbl.Campo_User_M, "medico");
        conMedico.put(MedicosTbl.Campo_Password_M, "123");

        db.insert(MedicosTbl.TableNameM, null, conMedico);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}