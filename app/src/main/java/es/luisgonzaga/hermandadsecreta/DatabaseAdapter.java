package es.luisgonzaga.hermandadsecreta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NINO on 08/12/2017.
 */

public class DatabaseAdapter extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "usuarios.db";

    public DatabaseAdapter(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void AnadirUsuario(){

    }

    public void EliminarUsuario(){

    }

    public void ModificarUsuario(){

    }

    public void AnadirUbicacion(){

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
