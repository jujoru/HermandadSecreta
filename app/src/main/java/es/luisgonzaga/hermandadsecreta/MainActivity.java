package es.luisgonzaga.hermandadsecreta;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_contrasena, et_estado;
    Button bt_hermanos, bt_estado, bt_administrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Pantalla solo en vertical
        setContentView(R.layout.activity_main);

        DeclararComponentes(); //Creamos un metodo donde declaramos todos los componentes de la vista y sus eventos.

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
                if(nombre.equals("admin")){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }
    }
    public void MostrarHermanos(View view){

        if(ValidarIdentificacion(false)){

        }

    }

    public void CambiarEstado(View view){
        if(ValidarIdentificacion(false)){

        }
    }

    public void Administrador(View view){

        if(ValidarIdentificacion(true)){
            
        }

    }

}
