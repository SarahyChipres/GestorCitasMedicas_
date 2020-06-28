package BD.Tablas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import BD.BDOH;
import BD.Servicios;

public class ServiciosTbl {
    public static final String TableNameS= "Servicios";
    public static final String QueryCreateS ="CREATE TABLE Servicios (codigoservicio INTEGER PRIMARY KEY, nombreservicio TEXT, precioservicio TEXT)";
    public static final String Campo_Codigo_S = "codigoservicio";
    public static final String Campo_Nombre_S ="nombreservicio";
    public static final String Campo_Precio_S ="precioservicio";

    public static Long AddService(Context context,
                                  Integer codservicio, String nomservicio, String preservicio) {

        BDOH adminservicios = new BDOH(context);
        //Comprobar si se abrio la conexion
        if(adminservicios!= null){
            // Ejecutamos el metodo para leer y escribir en la base de datos
            SQLiteDatabase db= adminservicios.getWritableDatabase();
            //Guardamos  los datos ingresados
            ContentValues con=new ContentValues();
            con.put(Campo_Codigo_S,codservicio);
            con.put(Campo_Nombre_S,nomservicio);
            con.put(Campo_Precio_S,preservicio);

            //Insersion de los datos especificanco en que tabla
            long insertado = db.insert(TableNameS,null, con);
            db.close();
            return  insertado;

        } else { return  Long.getLong("0");
        }
    }

    public static Servicios ConsultaPorCodigo(Context context, Integer codservicio) {

        BDOH adminservicio= new BDOH(context);
        SQLiteDatabase bd = adminservicio.getWritableDatabase();
        //Se usan las constantes para mantener un estandar en las palabras y no equivocarnos
        Cursor fila = bd.rawQuery("select  "+
                Campo_Nombre_S+"," +
                Campo_Precio_S +" from "+ TableNameS +" where "+Campo_Codigo_S +" = " + codservicio, null);
        //Nuevo objeto servicio a devolver
        Servicios servicio = new Servicios();
        //Si tiene una o mas fila guardo los datos en el objeto
        if (fila.getCount() > 0){
            fila.moveToFirst();
            servicio.setCodigoservicio(codservicio);
            servicio.setNombreservicio(fila.getString(fila.getColumnIndex(Campo_Nombre_S)));
            servicio.setPrecioservicio(fila.getString(fila.getColumnIndex(Campo_Precio_S)));
        }
        fila.close();
        bd.close();
        return  servicio;
    }

    public static int BajaPorCodido(Context context, Integer codservicio) {
        BDOH admin = new BDOH(context);
        SQLiteDatabase bd = admin.getWritableDatabase();
        int cant = bd.delete(TableNameS, Campo_Codigo_S+ "=" + codservicio, null);
        bd.close();
        return cant;
    }

    public static int ModificarServicio(Context context, Integer codservicio, String preservicio, String nomservicio) {
        BDOH adminservicios = new BDOH(context);

        SQLiteDatabase bd = adminservicios.getWritableDatabase();
        ContentValues registroservicios = new ContentValues();

        //Datos que queremos guardar de manera momentanea
        registroservicios.put(Campo_Codigo_S, codservicio);
        registroservicios.put(Campo_Nombre_S, nomservicio);
        registroservicios.put(Campo_Precio_S, preservicio);
        int cant = bd.update(TableNameS, registroservicios, Campo_Codigo_S+ "=" + codservicio, null);
        bd.close();
        return cant;

    }

    public  static ArrayList<Servicios> ListarServicios(Context context){
        ArrayList<Servicios> serviciosList = new ArrayList<Servicios>();
        //Conexion a la base de datos
        BDOH adminmostrar =new BDOH(context);
        //Comprobar conexion
        if (adminmostrar!=null){
            //Obtenemos instancia para poder ver la base de datos
            SQLiteDatabase db =adminmostrar.getReadableDatabase();
            //Hacemos la consulta y recorremos todos los datos
            Cursor c = db.rawQuery("SELECT * FROM "+ TableNameS,null);
            //Comprobar si existen datos en la tabla
            if(c.getCount() > 0){
                c.moveToFirst(); //*inicia en primer posición.
                while (!c.isAfterLast()) {
                    serviciosList.add(
                            new Servicios(
                                    //Obtener datos del cursors por el nombre de la columna
                                    c.getInt(c.getColumnIndex(Campo_Codigo_S)),
                                    c.getString(c.getColumnIndex(Campo_Nombre_S)),
                                    c.getString(c.getColumnIndex(Campo_Precio_S))
                            )
                    ); //add the item
                    c.moveToNext();
                }
            }
            c.close();
            db.close();
        }
        return  serviciosList;
    }
}

