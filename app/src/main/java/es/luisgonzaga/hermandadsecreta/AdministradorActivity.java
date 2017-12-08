package es.luisgonzaga.hermandadsecreta;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.temporal.ValueRange;

public class AdministradorActivity extends AppCompatActivity {

    EditText et_nombre, et_contrasena;
    Button bt_anadir, bt_eliminar, bt_modificar;
    DatabaseAdapter dba=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_administrador);

        DeclararComponentes();
        dba=new DatabaseAdapter(getApplicationContext());
    }

    private void DeclararComponentes(){
        et_nombre=(EditText)findViewById(R.id.aa_et_nombre);
        et_contrasena=(EditText)findViewById(R.id.aa_et_contrasena);
        bt_anadir=(Button)findViewById(R.id.aa_bt_anadir);
        bt_eliminar=(Button)findViewById(R.id.aa_eliminar);
        bt_modificar=(Button)findViewById(R.id.aa_modificar);
    }

    private boolean ValidarCampos(){
        String nombre = et_nombre.getText().toString();
        String password = et_contrasena.getText().toString();

        if(nombre.equals("") || password.equals("")){
            Toast.makeText(this, "Debes de rellenar todos los campos",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
    private boolean ValidarCamposEliminar(){
        String nombre = et_nombre.getText().toString();

        if(nombre.equals("")  ){
            Toast.makeText(this, "Debes de rellenar el campo Nombre",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    public void AnadirUsuario(View view){

        if(ValidarCampos()){
            String nombre = et_nombre.getText().toString();
            String password = et_contrasena.getText().toString();
            long res = dba.AnadirUsuario(nombre,password);

            if(res!=-1){
                if(res==-2){
                    Toast.makeText(getApplicationContext(),"Ya existe un usuario llamado "+nombre, Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Usuario insertado con exito", Toast.LENGTH_LONG).show();
                    LimpiarFomulario();
                }

            }else{

                    Toast.makeText(getApplicationContext(),"No se insertó el usuario con exito", Toast.LENGTH_LONG).show();

            }

        }
    }

    public void EliminarUsuario(View view){
        if(ValidarCamposEliminar()){
            String nombre = et_nombre.getText().toString();
            int res = dba.EliminarUsuario(nombre);

            if(res!=0){
                Toast.makeText(getApplicationContext(),"Usuario eliminado", Toast.LENGTH_LONG).show();
                LimpiarFomulario();
            }else{

                Toast.makeText(getApplicationContext(),"No se ha podido eliminar el usuario", Toast.LENGTH_LONG).show();

            }
        }
    }

    public void ModificarContrasena(View view){
        if(ValidarCampos()){
            String nombre = et_nombre.getText().toString();
            String password_nueva = et_contrasena.getText().toString();
            int filasAfectadas = dba.ModificarPassword(nombre,password_nueva);

            if(filasAfectadas!=0){
                if(filasAfectadas==-2){
                    Toast.makeText(getApplicationContext(),"No existe el usuario "+nombre, Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Se ha modificado la contraseña del usuario "+nombre, Toast.LENGTH_LONG).show();
                    LimpiarFomulario();
                }

            }else{

                    Toast.makeText(getApplicationContext(),"No se ha podido modificar la contraseña", Toast.LENGTH_LONG).show();



            }

        }
    }

    public void LimpiarFomulario(){
        et_nombre.setText("");
        et_contrasena.setText("");
    }


}
