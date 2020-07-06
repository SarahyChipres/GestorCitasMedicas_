package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import BD.BDOH;

public class UsuariosTbl {
    public static  final   String TableName = "Usuarios";
    public static final   String QueryCreate = "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY, user TEXT, password TEXT, conectado BIT)";
    static public final  String Campo_Codigo = "codigo";
    static  public  final  String Campo_User = "user";
    static  public  final  String Campo_Password = "password";
    static  public  final  String Campo_Conectado = "conectado";

    public  static  Long AddUser(Context context, Integer codigo, String user, String password){

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
            con.put(Campo_Conectado, false);

            Long insertado = db.insert( TableName ,null, con);
            return  insertado;
        }else {
            return Long.getLong("0");
        }
    }

    public static Long setUser(Context context, String user) {
        BDOH usuario = new BDOH(context);
        SQLiteDatabase bd = usuario.getWritableDatabase();
        ContentValues usuarioDesconectar = new ContentValues();
        //Datos que queremos guardar de manera momentanea
        usuarioDesconectar.put(Campo_Conectado, false);
        bd.update(TableName, usuarioDesconectar, "conectado=" + true, null);

        ContentValues usuarioConectado = new ContentValues();
        //Datos que queremos guardar de manera momentanea
        usuarioConectado.put(Campo_Conectado, true);
        long cant = bd.update(TableName, usuarioConectado, "user=" + user, null);

        return cant;
    }

    public static Integer getUser(Context context) {
        //Conexion a la base de datos
        BDOH usuario =new BDOH(context);
        //Comprobar conexion
        if (usuario!=null){
            //Obtenemos instancia para poder ver la base de datos
            SQLiteDatabase db =usuario.getReadableDatabase();
            //Hacemos la consulta y recorremos todos los datos
            Cursor c = db.rawQuery("SELECT codigo FROM Usuarios WHERE conectado = " + true,null);
            //Comprobar si existen datos en la tabla
            if (c.moveToFirst()){
                return c.getInt(0);
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
}
