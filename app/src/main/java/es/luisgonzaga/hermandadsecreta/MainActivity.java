package es.luisgonzaga.hermandadsecreta;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_contrasena, et_estado;
    Button bt_hermanos, bt_estado, bt_administrador;
    DatabaseAdapter dba=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Pantalla solo en vertical
        setContentView(R.layout.activity_main);

        DeclararComponentes(); //Creamos un metodo donde declaramos todos los componentes de la vista y sus eventos.
        dba=new DatabaseAdapter(getApplicationContext());

    }

    private void DeclararComponentes(){
        et_nombre=(EditText)findViewById(R.id.ma_et_nombre);
        et_contrasena=(EditText)findViewById(R.id.ma_et_contrasena);
        et_estado=(EditText)findViewById(R.id.ma_et_estado);
        bt_administrador=(Button)findViewById(R.id.ma_bt_administrador);
        bt_estado=(Button)findViewById(R.id.ma_bt_cambiarestado);
        bt_hermanos=(Button)findViewById(R.id.ma_bt_mostrarhermanos);
    }

    //Metodo para validar la identificación de usuarios / administradores
    private boolean ValidarIdentificacion(boolean esAdministrador){
        String nombre = et_nombre.getText().toString();
        String password = et_contrasena.getText().toString();

        if(nombre.equals("") || password.equals("")){
            Toast.makeText(this, "Debes de rellenar todos los campos para comprobar el acceso",Toast.LENGTH_LONG).show();
            return false;
        }else{
            if(esAdministrador){
                if(dba.ComprobarLogin(nombre,password) && nombre.equals("admin")){
                    return true;

                }else{
                    Toast.makeText(getApplicationContext(),"No existe un adminisrador por ese nombre y/o password",Toast.LENGTH_LONG).show();

                    return false;
                }
            }else{

                if(dba.ComprobarLogin(nombre,password)){
                    return true;

                }else{
                    Toast.makeText(getApplicationContext(),"No existe un usuario por ese nombre y/o password",Toast.LENGTH_LONG).show();
                    return false;
                }

            }
        }
    }

    public void MostrarHermanos(View view){

        if(ValidarIdentificacion(false)){
            Intent i=new Intent(getApplicationContext(), ListaUsuariosActivity.class);
            startActivity(i);
        }

    }

    public void CambiarEstado(View view){

        String estado = et_estado.getText().toString();
        String nombre = et_nombre.getText().toString();
        if(estado.equals("")){
            Toast.makeText(getApplicationContext(),"Debes de rellenar un estado",Toast.LENGTH_LONG).show();
        }else{
            if(ValidarIdentificacion(false)){
                int filasAfectadas = dba.CambiarEstado(nombre,estado);
                if(filasAfectadas!=0){
                    Toast.makeText(getApplicationContext(),"Estado Modificado",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"No se ha podido modificar el estado",Toast.LENGTH_LONG).show();

                }
            }
        }

    }

    public void Administrador(View view){

        if(ValidarIdentificacion(true)){
            Intent i=new Intent(getApplicationContext(), AdministradorActivity.class);
            startActivity(i);
        }

    }

}
