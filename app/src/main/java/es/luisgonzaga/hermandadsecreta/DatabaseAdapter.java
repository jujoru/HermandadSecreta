package es.luisgonzaga.hermandadsecreta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by NINO on 08/12/2017.
 */

public class DatabaseAdapter {

    private static DatabaseHelper helper = null;
    Context context;
    ArrayList<Usuario> lista_usuarios=new ArrayList<Usuario>();

    public DatabaseAdapter(Context context) {
            if(this.helper==null){
                helper=new DatabaseHelper(context);
            }
            this.context = context;
    }

    public ArrayList<Usuario> ObtenerUsuarios(){

        SQLiteDatabase db = helper.getWritableDatabase();

        String[] columnas ={DatabaseHelper.UID, "NOMBRE","PASSWORD","ESTADO"};
        Cursor c= db.query(DatabaseHelper.TABLE_NAME,columnas,null,null,null,null,null);

        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("_id"));
            String nombre = c.getString(c.getColumnIndex("NOMBRE"));
            String password = c.getString(c.getColumnIndex("PASSWORD"));
            String estado = c.getString(c.getColumnIndex("ESTADO"));

            lista_usuarios.add(new Usuario(id,nombre,password,estado));
        }

        return lista_usuarios;
    }

    private boolean ExisteUsuario(String nombre){
        ObtenerUsuarios();
        boolean flag=false;
        for(int i=0; i<lista_usuarios.size(); i++){
            if(nombre.equals(lista_usuarios.get(i).getNombre())){
                flag= true;
            }
        }
        return flag;
    }
    public boolean ComprobarLogin(String nombre, String password){
        ObtenerUsuarios();

        for (int i=0; i<lista_usuarios.size(); i++){
            Usuario u = lista_usuarios.get(i);

            if(u.getNombre().equals(nombre) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }

    public long AnadirUsuario(String nombre, String contrasena){

        long res=0;
        if(ExisteUsuario(nombre)){
            res = -2;
        }else{
            ContentValues cv=new ContentValues();
            cv.put("NOMBRE",nombre);
            cv.put("PASSWORD",contrasena);
            cv.put("ESTADO","sin estado");
            SQLiteDatabase db = helper.getWritableDatabase();
            res = db.insert(DatabaseHelper.TABLE_NAME,null,cv);


        }

        return res;
    }

    public int EliminarUsuario(String nombre){
        SQLiteDatabase db = helper.getWritableDatabase();
        String seleccion = "NOMBRE LIKE ?";
        String[] argumentos = { nombre };
        return db.delete(DatabaseHelper.TABLE_NAME, seleccion,argumentos);

    }

    public int ModificarPassword(String nombre, String password_nueva){
        int res=0;
        if(ExisteUsuario(nombre)){
            res=2;
        }else {
            ContentValues cv = new ContentValues();
            cv.put("PASSWORD", password_nueva);
            String seleccion = "NOMBRE LIKE ?";
            String[] argumentos = {nombre};
            SQLiteDatabase db = helper.getWritableDatabase();
            res = db.update(DatabaseHelper.TABLE_NAME, cv, seleccion, argumentos);


        }

        return res;
    }

    public int CambiarEstado(String nombre, String estado_nuevo){
        ContentValues cv=new ContentValues();
        cv.put("ESTADO",estado_nuevo);
        String seleccion = "NOMBRE LIKE ?";
        String[] argumentos = { nombre };
        SQLiteDatabase db = helper.getWritableDatabase();
        int id = db.update(DatabaseHelper.TABLE_NAME,cv,seleccion,argumentos);

        return id;
    }

}
