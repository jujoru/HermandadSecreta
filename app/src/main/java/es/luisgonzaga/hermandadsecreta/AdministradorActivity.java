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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_administrador);

        DeclararComponentes();
    }

    private void DeclararComponentes(){
        et_nombre=(EditText)findViewById(R.id.ma_et_nombre);
        et_contrasena=(EditText)findViewById(R.id.ma_et_contrasena);
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

    public void AnadirUsuario(View view){

        if(ValidarCampos()){

        }
    }

    public void EliminarUsuario(View view){
        if(ValidarCampos()){

        }
    }

    public void ModificarContrasena(View view){
        if(ValidarCampos()){

        }
    }


}
