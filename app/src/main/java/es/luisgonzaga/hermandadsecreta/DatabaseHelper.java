package es.luisgonzaga.hermandadsecreta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NINO on 08/12/2017.
 */

public class DatabaseHelper  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Hermandadsecreta.db";
    public static final String TABLE_NAME = "usuarios";
    public static final String UID = "_id";



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE VARCHAR(255), PASSWORD VARCHAR(255), ESTADO VARCHAR(255))");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (NOMBRE, PASSWORD, ESTADO) VALUES ('admin','1234','Administrador')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (NOMBRE, PASSWORD, ESTADO) VALUES ('Juan','Juan','Disponible')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (NOMBRE, PASSWORD, ESTADO) VALUES ('Marta','Marta','Estoy estudiando')");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (NOMBRE, PASSWORD, ESTADO) VALUES ('Jose','Jose','Estoy entrenando en el gimnasio')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}