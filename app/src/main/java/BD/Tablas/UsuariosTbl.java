package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import BD.BDOH;

public class UsuariosTbl {
    public static  final   String TableName = "Usuarios";
    public static final   String QueryCreate = "CREATE TABLE Usuarios(codigo   INTEGER  PRIMARY KEY, user TEXT, password TEXT)";
    static public final  String Campo_Codigo = "codigo";
    static  public  final  String Campo_User = "user";
    static  public  final  String Campo_Password = "password";

    public  static  Long AddUser(Context context,
                                 Integer codigo, String user, String password
    ){

        //conexion con la base de datos
        BDOH admin = new BDOH( context);
        //Comprobar si se abrio la conexion
        if(admin != null){
            SQLiteDatabase db = admin.getWritableDatabase();
            //Guardamos  los datos ingresados
            ContentValues con = new ContentValues();

            con.put(Campo_Codigo,codigo);
            con.put(Campo_User,user);
            con.put(Campo_Password,password);

            Long insertado = db.insert( TableName ,null, con);
            return  insertado;
        }else {
            return Long.getLong("0");
        }
    }


}
