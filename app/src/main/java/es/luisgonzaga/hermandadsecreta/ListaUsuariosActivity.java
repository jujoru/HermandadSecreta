package es.luisgonzaga.hermandadsecreta;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaUsuariosActivity extends AppCompatActivity {

    ListView listaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DeclararComponentes();

    }

    private void DeclararComponentes(){

        listaUsuario = (ListView)findViewById(R.id.lv_usuarios);
    }
}
